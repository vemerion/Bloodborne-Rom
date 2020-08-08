package mod.vemerion.bloodbornerom.mobs.entities;

import mod.vemerion.bloodbornerom.BloodborneRom;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class MissileEntity extends AbstractArrowEntity {
	private int duration = 100;

	public MissileEntity(EntityType<? extends MissileEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
		this.setHitSound(SoundEvents.ENTITY_DOLPHIN_SPLASH);
		this.setNoGravity(true);
	}

	public MissileEntity(World worldIn) {
		this(BloodborneRom.MISSILE_ENTITY, worldIn);
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult hitEntity) {
	}

	@Override
	public void onCollideWithPlayer(PlayerEntity player) {
		player.attackEntityFrom(DamageSource.MAGIC, 6);
	}

	@Override
	public void tick() {
		super.tick();
		if (!world.isRemote) {
			if (duration-- < 0 || inGround) {
				remove();
			}
			addSmokeParticles(10);
		}
	}

	private void addSmokeParticles(int count) {
		float width = getWidth() * 0.5f;
		float height = getHeight() * 0.5f;
		for (int i = 0; i < count; ++i) {
			Vec3d offset = new Vec3d(0, 0, 0);
			offset = offset.add(rand.nextDouble() * width - width / 2, rand.nextDouble() * height - height / 2,
					rand.nextDouble() * width - width / 2);
			Vec3d position = new Vec3d(getPosX(), getPosYEye(), getPosZ());
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(BloodborneRom.BLUE_SMOKE_PARTICLE_TYPE, position.x, position.y,
						position.z, 1, offset.x, offset.y + 0.05D, offset.z, 0.1D);

			}
		}
	}

	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected ItemStack getArrowStack() {
		return null;
	}

}
