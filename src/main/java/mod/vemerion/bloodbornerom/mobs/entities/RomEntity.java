package mod.vemerion.bloodbornerom.mobs.entities;

import java.util.EnumSet;
import java.util.Random;

import mod.vemerion.bloodbornerom.BloodborneRom;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

public class RomEntity extends CreatureEntity implements IMob {
	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));

	private static final DataParameter<Boolean> MISSILE_BARRAGE = EntityDataManager.createKey(RomEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> AREA_OF_EFFECT = EntityDataManager.createKey(RomEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> CIRCLE_MISSILES = EntityDataManager.createKey(RomEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELEE_ATTACK = EntityDataManager.createKey(RomEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> TELEPORT = EntityDataManager.createKey(RomEntity.class,
			DataSerializers.BOOLEAN);

	private int attackCooldown;
	private float prevTurning;
	private float turning;
	private int teleportDuration;
	private boolean engaged;
	private float startHealth;

	public RomEntity(EntityType<? extends RomEntity> type, World worldIn) {
		super(type, worldIn);
		this.bossInfo.setVisible(false);
		this.startHealth = this.getMaxHealth();
	}

	@Override
	protected void registerData() {
		super.registerData();
		dataManager.register(MISSILE_BARRAGE, false);
		dataManager.register(AREA_OF_EFFECT, false);
		dataManager.register(CIRCLE_MISSILES, false);
		dataManager.register(MELEE_ATTACK, false);
		dataManager.register(TELEPORT, false);
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("notvacuous", engaged);
		compound.putFloat("startHealth", getHealthPercent());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		engaged = compound.getBoolean("notvacuous");
		if (engaged) {
			bossInfo.setVisible(true);
		}
		
		if (compound.contains("startHealth")) {
			startHealth = compound.getFloat("startHealth");
		}
	}

	public boolean doingMissileBarrage() {
		return dataManager.get(MISSILE_BARRAGE);
	}

	public void setMissileBarrage(boolean value) {
		this.dataManager.set(MISSILE_BARRAGE, value);
	}

	public boolean doingAreaOfEffect() {
		return dataManager.get(AREA_OF_EFFECT);
	}

	public void setAreaOfEffect(boolean value) {
		this.dataManager.set(AREA_OF_EFFECT, value);
	}

	public boolean doingCircleMissiles() {
		return dataManager.get(CIRCLE_MISSILES);
	}

	public void setCircleMissiles(boolean value) {
		this.dataManager.set(CIRCLE_MISSILES, value);
	}

	public boolean doingMeleeAttack() {
		return dataManager.get(MELEE_ATTACK);
	}

	public void setMeleeAttack(boolean value) {
		this.dataManager.set(MELEE_ATTACK, value);
	}

	public boolean isTeleporting() {
		return dataManager.get(TELEPORT);
	}

	public void setTeleporting(boolean value) {
		this.dataManager.set(TELEPORT, value);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new RomEntity.TeleportGoal(this, 0.33f));
		this.goalSelector.addGoal(0, new RomEntity.TeleportGoal(this, 0.67f));
		this.goalSelector.addGoal(1, new RomEntity.MissileBarrageGoal(this));
		this.goalSelector.addGoal(1, new RomEntity.AreaOfEffectGoal(this));
		this.goalSelector.addGoal(1, new RomEntity.CircleMissilesGoal(this));
		this.goalSelector.addGoal(1, new RomEntity.MeleeAttackGoal(this));
		this.goalSelector.addGoal(5, new RomEntity.FleeGoal(this));
		this.goalSelector.addGoal(6, new RomEntity.BackAwayGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (!engaged) {
			engaged = true;
			bossInfo.setVisible(true);
			if (!world.isRemote) {
				spawnSpiders();
			}
		}
		return super.attackEntityFrom(source, amount);
	}

	private void spawnSpiders() {
		float radius = 6.5f;
		for (int i = 0; i < 10; i++) {
			float angle = (360f / 10) * i;
			Vec3d position = getPositionVec().add(Vec3d.fromPitchYaw(0, angle).scale(radius));
			RomSpiderEntity spider = new RomSpiderEntity(BloodborneRom.ROM_SPIDER_ENTITY, world, getUniqueID());
			spider.setPosition(position.getX(), position.getY() + 4, position.getZ());
			world.addEntity(spider);
		}
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	@Override
	public void tick() {
		super.tick();
		if (!world.isRemote) {
			if (getAttackTarget() != null) {
				attackCooldown--;
			}
		} else {
			prevTurning = turning;
			if (isTeleporting()) {
				turning += 360f / 80;
				teleportDuration++;
			} else {
				teleportDuration = 0;
			}
		}

		bossInfo.setPercent(getHealthPercent());
	}

	private float getHealthPercent() {
		return getHealth() / getMaxHealth();
	}

	public float getTeleportDuration() {
		return teleportDuration;
	}

	public float getTurningValue(float partialTick) {
		return MathHelper.lerp(partialTick, prevTurning, turning);
	}

	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		RomDeathEntity entity = new RomDeathEntity(BloodborneRom.ROM_DEATH_ENTITY, world);
		entity.setPosition(getPosX(), getPosY(), getPosZ());
		world.addEntity(entity);
	}

	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	private int generateAttackCooldown() {
		return 200 + getRNG().nextInt(200);
	}

	private Vec3d getFacing() {
		return Vec3d.fromPitchYaw(new Vec2f(0, rotationYaw));
	}

	public static class FleeGoal extends Goal {
		private RomEntity entity;
		private int duration;
		private int maxDuration = 20;

		public FleeGoal(RomEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			return entity.hurtTime > 0 && entity.getRNG().nextDouble() < 0.01;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return duration >= 0;
		}

		@Override
		public void startExecuting() {
			duration = maxDuration;
		}

		@Override
		public void tick() {
			duration--;
			entity.setMotion(entity.getFacing().scale(-0.2));
		}
	}

	public static class MissileBarrageGoal extends Goal {
		private RomEntity entity;
		private int duration;
		private int count;

		public MissileBarrageGoal(RomEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			return entity.attackCooldown < 0 && entity.getAttackTarget() != null && entity.getRNG().nextDouble() < 0.25
					&& entity.getHealthPercent() < 0.67f;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = 120;
			count = 5;
			entity.setMissileBarrage(true);
		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			duration--;
			if (target != null) {
				if (duration > 40 && duration % 15 == 0 && count-- > 0) {
					spawnMissile();
				}
			}

			if (duration <= 0) {
				entity.setMissileBarrage(false);
			}
		}

		private void spawnMissile() {
			Random rand = entity.getRNG();
			Vec3d target = entity.getAttackTarget().getPositionVec();
			Vec3d position = entity.getPositionVec().add(rand.nextDouble() * 4 - 2, 20, rand.nextDouble() * 4);
			World world = entity.world;
			MissileEntity missile = new MissileEntity(world);
			missile.setPosition(position.getX(), position.getY(), position.getZ());
			missile.shoot(target.getX() - position.getX(), target.getY() - position.getY(),
					target.getZ() - position.getZ(), 0.8f, 0);
			world.addEntity(missile);
		}
	}

	public static class AreaOfEffectGoal extends Goal {
		private RomEntity entity;
		private int duration;
		private int radius = 10;

		public AreaOfEffectGoal(RomEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			Entity target = entity.getAttackTarget();
			return target != null && target.getDistanceSq(entity) < 50 && entity.attackCooldown < 0
					&& entity.getRNG().nextDouble() < 1d / 3d && entity.getHealthPercent() < 0.67f;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = 120;
			entity.setAreaOfEffect(true);
			entity.playSound(BloodborneRom.ROM_AOE_WINDUP_SOUND, entity.getSoundVolume(), entity.getSoundPitch());
		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			duration--;
			if (target != null) {
				if (duration == 60) {
					entity.playSound(BloodborneRom.ROM_AOE_SOUND, entity.getSoundVolume(), entity.getSoundPitch());
					AxisAlignedBB area = new AxisAlignedBB(entity.getPosition()).grow(radius);
					for (Entity e : entity.world.getEntitiesInAABBexcluding(entity, area, null)) {
						if (e instanceof PlayerEntity) {
							e.attackEntityFrom(DamageSource.causeMobDamage(entity), 12);
						}
					}
				}
				if (duration > 60 && duration < 65) {
					areaOfEffectParticles(300);
				}
			}

			if (duration <= 0) {
				entity.setAreaOfEffect(false);
			}
		}

		private void areaOfEffectParticles(int count) {
			Random rand = entity.getRNG();
			World world = entity.world;
			for (int i = 0; i < count; ++i) {
				Vec3d offset = new Vec3d(0, 0, 0);
				double distance = radius - rand.nextDouble() * 3;
				float yaw = rand.nextInt(360);
				float pitch = rand.nextInt(180) - 180;
				Vec3d position = new Vec3d(entity.getPosX(), entity.getPosY(), entity.getPosZ());
				position = position.add(Vec3d.fromPitchYaw(pitch, yaw).scale(distance));
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(BloodborneRom.BLUE_SMOKE_PARTICLE_TYPE, position.x, position.y,
							position.z, 1, offset.x, offset.y, offset.z, 0.1D);

				}
			}
		}
	}

	public static class CircleMissilesGoal extends Goal {
		private RomEntity entity;
		private int duration;
		private Vec3d[] spawnPositions = new Vec3d[16];

		public CircleMissilesGoal(RomEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			Entity target = entity.getAttackTarget();
			return target != null && target.getDistanceSq(entity) < 100 && entity.attackCooldown < 0
					&& entity.getRNG().nextDouble() < 0.5 && entity.getHealthPercent() < 0.67f;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = 140;
			entity.setCircleMissiles(true);
		}

		@Override
		public void tick() {
			duration--;
			int time = 140 - duration;
			if (time < 40) {
				entity.setMotion(entity.getFacing().rotateYaw(90).scale(0.05));
			} else if (time > 80 && time < 110) {
				entity.setMotion(entity.getFacing().rotateYaw(-90).scale(0.05));
			} else if (time == 50) {
				// 'hop'
				entity.setVelocity(0, 0.3, 0);
				generateSpawnPositions();
			} else if (time > 50 && time < 80) {
				groundParticles(50);
			} else if (time == 80) {
				spawnMissiles();
				for (int i = 0; i < 5; i++) {
					entity.playSound(SoundEvents.ENTITY_DOLPHIN_SPLASH, entity.getSoundVolume() * 1.5f,
							entity.getSoundPitch() * 0.7f);
				}

			}

			if (duration <= 0) {
				entity.setCircleMissiles(false);
			}
		}

		private void generateSpawnPositions() {
			for (int i = 0; i < spawnPositions.length; i++) {
				float angle = (360f / spawnPositions.length) * i;
				Vec3d missilePosition = entity.getPositionVec()
						.add(Vec3d.fromPitchYaw(0, angle).scale(entity.getRNG().nextDouble() * 6 + 4));
				spawnPositions[i] = missilePosition;
			}
		}

		private void spawnMissiles() {
			World world = entity.world;
			for (int i = 0; i < spawnPositions.length; i++) {
				Vec3d position = spawnPositions[i];
				MissileEntity missile = new MissileEntity(world);
				missile.setPosition(position.getX(), position.getY(), position.getZ());
				missile.shoot(0, 20, 0, 0.8f, 0);
				world.addEntity(missile);
			}
		}

		private void groundParticles(int count) {
			Random rand = entity.getRNG();
			World world = entity.world;
			for (int i = 0; i < spawnPositions.length; i++) {
				Vec3d missilePosition = spawnPositions[i];
				for (int j = 0; j < count; ++j) {
					Vec3d position = new Vec3d(missilePosition.getX() + rand.nextDouble() * 4 - 2,
							missilePosition.getY() + rand.nextDouble() * 0.3,
							missilePosition.getZ() + rand.nextDouble() * 4 - 2);
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.BUBBLE, position.x, position.y, position.z, 1,
								0, 0, 0, 0.1D);

					}
				}
			}
		}
	}

	public static class MeleeAttackGoal extends Goal {
		private RomEntity entity;
		private int duration;

		public MeleeAttackGoal(RomEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			Entity target = entity.getAttackTarget();
			return target != null && target.getDistanceSq(entity) < 25 && entity.attackCooldown < 0
					&& entity.getHealthPercent() < 0.67f;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = 80;
			entity.setMeleeAttack(true);

		}

		@Override
		public void tick() {
			duration--;
			AxisAlignedBB area = new AxisAlignedBB(entity.getPosition()).grow(3);
			for (Entity e : entity.world.getEntitiesInAABBexcluding(entity, area, null)) {
				if (e instanceof PlayerEntity) {
					e.attackEntityFrom(DamageSource.causeMobDamage(entity), 12);
				}
			}

			if (duration % 15 == 0 && duration > 30)
				entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entity.getSoundVolume(),
						entity.getSoundPitch() * 0.1f);

			if (duration <= 0) {
				entity.setMeleeAttack(false);
			}
		}
	}

	public static class BackAwayGoal extends Goal {
		private RomEntity entity;

		public BackAwayGoal(RomEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			return entity.engaged;
		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			if (target != null) {
				entity.getLookController().setLookPosition(target.getPosX(), target.getPosYEye(), target.getPosZ());
				entity.faceEntity(target, 0.1F, 0.1F);
			}
			entity.setMotion(entity.getFacing().scale(-0.005));
		}
	}

	public static class TeleportGoal extends Goal {
		private RomEntity entity;
		private float healthPercent;
		private boolean hasTeleported = false;
		private int duration;

		public TeleportGoal(RomEntity entity, float healthPercent) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
			this.healthPercent = healthPercent;
			if (entity.getHealthPercent() < healthPercent)
				hasTeleported = true;
		}

		@Override
		public boolean shouldExecute() {
			return entity.getHealthPercent() < healthPercent && entity.startHealth > healthPercent && !hasTeleported && !entity.doingAreaOfEffect()
					&& !entity.doingCircleMissiles() && !entity.doingMeleeAttack() && !entity.doingMissileBarrage()
					&& !entity.isTeleporting();
		}

		@Override
		public boolean shouldContinueExecuting() {
			return duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = 80;
			hasTeleported = true;
			entity.setTeleporting(true);
			entity.playSound(BloodborneRom.ROM_AOE_WINDUP_SOUND, entity.getSoundVolume(), entity.getSoundPitch());
		}

		@Override
		public void tick() {
			duration--;
			Random rand = entity.getRNG();

			if (duration == 79) {
				entity.setInvisible(true);
			} else if (duration == 20) {
				Vec3d teleport = entity.getPositionVec().add(Vec3d.fromPitchYaw(0, rand.nextFloat() * 360).scale(30));
				entity.attemptTeleport(teleport.getX(), teleport.getY(), teleport.getZ(), true);
			} else if (duration == 1) {
				entity.spawnSpiders();
			}

			if (duration <= 0) {
				entity.setInvisible(false);
				entity.setTeleporting(false);
			}
		}
	}
}
