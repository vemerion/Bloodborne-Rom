package mod.vemerion.bloodbornerom;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.LargeSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;

public class BlueSmokeParticle extends LargeSmokeParticle {
	protected BlueSmokeParticle(World world, double x, double y, double z, double speedX, double speedY, double speedZ,
			IAnimatedSprite sprite) {
		super(world, x, y, z, speedX, speedY, speedZ, sprite);
		this.particleRed = rand.nextFloat() * 0.3f + 0.5f;
		this.particleGreen = rand.nextFloat() * 0.3f + 0.7f;
		this.particleBlue = rand.nextFloat() * 0.1f + 0.9f;
	}

	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite p_i50554_1_) {
			this.spriteSet = p_i50554_1_;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z,
				double xSpeed, double ySpeed, double zSpeed) {
			return new BlueSmokeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}
}
