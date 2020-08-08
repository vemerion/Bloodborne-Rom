package mod.vemerion.bloodbornerom.mobs.entities;

import java.util.EnumSet;
import java.util.UUID;

import mod.vemerion.bloodbornerom.BloodborneRom;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RomSpiderEntity extends CreatureEntity implements IMob {

	private static final DataParameter<Boolean> MELEE_ATTACK = EntityDataManager.createKey(RomSpiderEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> COBWEB_ATTACK = EntityDataManager.createKey(RomSpiderEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> JUMP_ATTACKING = EntityDataManager.createKey(RomSpiderEntity.class,
			DataSerializers.BOOLEAN);

	private int attackCooldown = 100;
	private float jumpRotation;
	private float prevJumpRotation;
	private UUID mastersId;

	public RomSpiderEntity(EntityType<? extends RomSpiderEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public RomSpiderEntity(EntityType<? extends RomSpiderEntity> type, World worldIn, UUID mastersId) {
		super(type, worldIn);
		this.mastersId = mastersId;
	}

	@Override
	protected void registerData() {
		super.registerData();
		dataManager.register(MELEE_ATTACK, false);
		dataManager.register(COBWEB_ATTACK, false);
		dataManager.register(JUMP_ATTACKING, false);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
	}

	public boolean isMeleeAttacking() {
		return dataManager.get(MELEE_ATTACK);
	}

	public void setMeleeAttacking(boolean value) {
		this.dataManager.set(MELEE_ATTACK, value);
	}

	public boolean isCobwebSpraying() {
		return dataManager.get(COBWEB_ATTACK);
	}

	public void setCobwaySpray(boolean value) {
		this.dataManager.set(COBWEB_ATTACK, value);
	}

	public boolean isJumpAttacking() {
		return dataManager.get(JUMP_ATTACKING);
	}

	public void setJumpAttacking(boolean value) {
		this.dataManager.set(JUMP_ATTACKING, value);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		if (mastersId != null) {
			compound.putUniqueId("mastersId", mastersId);
		}
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.hasUniqueId("mastersId")) {
			mastersId = compound.getUniqueId("mastersId");
		}
	}

	@Override
	public void setMotionMultiplier(BlockState state, Vec3d motionMultiplierIn) {
		if (state.getBlock() != Blocks.COBWEB) {
			super.setMotionMultiplier(state, motionMultiplierIn);
		}

	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (world.isRemote)
			return false;
		Vec3d head = getPositionVec().add(getFacing().scale(0.5));
		Vec3d damageLocation = source.getDamageLocation();
		if (damageLocation != null && !isJumpAttacking()
				&& damageLocation.squareDistanceTo(head) < damageLocation.squareDistanceTo(getPositionVec())) {
			playerHitHeadSound();
			return false;
		} else {
			return super.attackEntityFrom(source, amount);
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (!world.isRemote) {
			if (getAttackTarget() != null) {
				attackCooldown--;
			} else {
				setMeleeAttacking(false);
				setCobwaySpray(false);
				setJumpAttacking(false);
			}

			if (mastersId != null) {
				Entity master = ((ServerWorld) world).getEntityByUuid(mastersId);
				if (master != null && !master.isAlive())
					attackEntityFrom(DamageSource.MAGIC, Integer.MAX_VALUE);
			}
		}

		prevJumpRotation = jumpRotation;
		if (isJumpAttacking()) {
			if (onGround) {
				jumpRotation = Math.max(0, jumpRotation - (float) Math.PI * 0.015f);
			} else {
				jumpRotation = Math.min((float) Math.PI / 2, jumpRotation + (float) Math.PI * 0.03f);
			}
		} else {
			jumpRotation = 0;
		}
	}

	public float getJumpRotationAmount(float partialTick) {
		return MathHelper.lerp(partialTick, prevJumpRotation, jumpRotation);
	}

	private void playerHitHeadSound() {
		playSound(SoundEvents.BLOCK_STONE_HIT, this.getSoundVolume() * 2f, this.getSoundPitch() * 0.4f);
	}

	@Override
	protected void jump() {
		Vec3d vec3d = this.getFacing().scale(0.4f);
		this.setMotion(vec3d.x, (double) this.getJumpUpwardsMotion() * 3, vec3d.z);
		this.isAirBorne = true;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new RomSpiderEntity.MeleeAttackGoal(this));
		this.goalSelector.addGoal(0, new RomSpiderEntity.SprayCobwebGoal(this));
		this.goalSelector.addGoal(0, new RomSpiderEntity.JumpAttackGoal(this));
		this.goalSelector.addGoal(4, new RomSpiderEntity.MoveToTargetGoal(this));
		this.goalSelector.addGoal(5, new RomSpiderEntity.BackAwayGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	private Vec3d getFacing() {
		return Vec3d.fromPitchYaw(new Vec2f(0, rotationYaw));
	}

	@Override
	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
	}

	private int generateAttackCooldown() {
		return 150;
	}

	public class BackAwayGoal extends Goal {
		private RomSpiderEntity entity;

		public BackAwayGoal(RomSpiderEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			return true;
		}

		@Override
		public void startExecuting() {
		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			if (target != null) {
				entity.getLookController().setLookPosition(target.getPosX(), target.getPosYEye(), target.getPosZ());
				entity.faceEntity(target, 2.0F, 2.0F);
			}

			Vec3d motion = entity.getFacing().scale(-0.01).add(0, entity.getMotion().getY(), 0);
			entity.setMotion(motion);
		}
	}

	public static class MoveToTargetGoal extends Goal {
		private RomSpiderEntity entity;

		public MoveToTargetGoal(RomSpiderEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			return entity.attackCooldown < 0 && entity.getAttackTarget() != null;
		}

		@Override
		public void startExecuting() {
		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			if (target != null) {
				entity.getLookController().setLookPosition(target.getPosX(), target.getPosYEye(), target.getPosZ());
				entity.faceEntity(target, 2.0F, 2.0F);
				entity.setMotion(entity.getFacing().scale(0.01));
			}
		}
	}

	public static class MeleeAttackGoal extends Goal {
		private RomSpiderEntity entity;
		private int duration;

		public MeleeAttackGoal(RomSpiderEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			Entity target = entity.getAttackTarget();
			return entity.attackCooldown < 0 && target != null && entity.getRNG().nextDouble() < 0.01
					&& target.getDistanceSq(entity) < 13;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return entity.getAttackTarget() != null && duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = 40;
			entity.setMeleeAttacking(true);
		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			duration--;
			if (target != null) {
				if (duration % 15 == 0)
					entity.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entity.getSoundVolume() * 0.8f,
							entity.getSoundPitch() * 0.45f);
				entity.getLookController().setLookPosition(target.getPosX(), target.getPosYEye(), target.getPosZ());
				entity.faceEntity(target, 2.0F, 2.0F);
				entity.setMotion(entity.getFacing().scale(0.1));
				for (Entity e : entity.world.getEntitiesInAABBexcluding(entity, entity.getBoundingBox().grow(0.4),
						null)) {
					if (e instanceof PlayerEntity) {
						e.attackEntityFrom(DamageSource.causeMobDamage(entity), 5);
					}
				}
			}

			if (duration <= 0) {
				entity.setMeleeAttacking(false);
			}
		}
	}

	public static class SprayCobwebGoal extends Goal {
		private RomSpiderEntity entity;
		private int duration;
		private int maxDuration = 60;

		public SprayCobwebGoal(RomSpiderEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			Entity target = entity.getAttackTarget();
			return entity.attackCooldown < 0 && target != null && entity.getRNG().nextDouble() < 0.01
					&& target.getDistanceSq(entity) > 4 && entity.getDistanceSq(target) < 20;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return entity.getAttackTarget() != null && duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = maxDuration;
			entity.setCobwaySpray(true);

		}

		@Override
		public void tick() {
			Entity target = entity.getAttackTarget();
			duration--;
			if (target != null) {
				entity.getLookController().setLookPosition(target.getPosX(), target.getPosYEye(), target.getPosZ());
				entity.faceEntity(target, 2.0F, 2.0F);
				if (duration % 5 == 0 && duration < maxDuration / 3) {
					BlockPos position = new BlockPos(entity.getPositionVec()
							.add(entity.getFacing().scale(entity.getRNG().nextDouble() * 2 + 1)));
					if (entity.world.isAirBlock(position)) {
						entity.world.setBlockState(position, Blocks.COBWEB.getDefaultState());
					}
				}

				if (duration % 10 == 0)
					entity.playSound(BloodborneRom.ROM_SPIDER_COBWEB_SOUND, entity.getSoundVolume(),
							entity.getSoundPitch());
			}

			if (duration <= 0) {
				entity.setCobwaySpray(false);
			}
		}
	}

	public static class JumpAttackGoal extends Goal {
		private RomSpiderEntity entity;
		private int duration;
		private int maxDuration = 60;

		public JumpAttackGoal(RomSpiderEntity entity) {
			this.entity = entity;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean shouldExecute() {
			Entity target = entity.getAttackTarget();
			return entity.attackCooldown < 0 && target != null && entity.getRNG().nextDouble() < 0.01
					&& entity.getDistanceSq(target) < 20;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return entity.getAttackTarget() != null && duration >= 0;
		}

		@Override
		public void startExecuting() {
			entity.attackCooldown = entity.generateAttackCooldown();
			duration = maxDuration;
			entity.setJumpAttacking(true);
			entity.jump();
			entity.playSound(SoundEvents.ENTITY_HORSE_JUMP, entity.getSoundVolume(), entity.getSoundPitch());
		}

		@Override
		public void tick() {
			duration--;

			for (Entity e : entity.world.getEntitiesInAABBexcluding(entity, entity.getBoundingBox().grow(0.5), null)) {
				if (e instanceof PlayerEntity) {
					e.attackEntityFrom(DamageSource.causeMobDamage(entity), 10);
				}
			}

			if (duration == 30) {
				entity.playSound(SoundEvents.ENTITY_DOLPHIN_SPLASH, entity.getSoundVolume() * 2,
						entity.getSoundPitch());
			}

			if (duration <= 0) {
				entity.setJumpAttacking(false);
			}
		}
	}
}
