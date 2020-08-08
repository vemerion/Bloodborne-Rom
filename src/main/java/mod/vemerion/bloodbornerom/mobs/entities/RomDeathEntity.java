package mod.vemerion.bloodbornerom.mobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class RomDeathEntity extends Entity {

	private int duration = 140;
	
	public RomDeathEntity(EntityType<RomDeathEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	
	@Override
	public void tick() {
		super.tick();
		if (!world.isRemote) {
			duration--;
			addDeathParticles(130);
			if (duration <= 0) {
				remove();
			}
		}
	}
	
	private void addDeathParticles(int count) {
		float width = 30;
		float height = 10;
		for (int i = 0; i < count; ++i) {
			Vec3d position = new Vec3d(getPosX() + rand.nextDouble() * width - width / 2, getPosYEye() + height + rand.nextDouble() * 10, getPosZ() + rand.nextDouble() * width - width / 2);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(
						new ItemParticleData(ParticleTypes.ITEM, new ItemStack(Items.REDSTONE)), position.x, position.y,
						position.z, 1, 0, 0, 0, 0.0D);
			}
		}
	}

	@Override
	protected void registerData() {
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
