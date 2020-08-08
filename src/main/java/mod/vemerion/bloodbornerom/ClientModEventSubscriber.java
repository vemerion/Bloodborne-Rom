package mod.vemerion.bloodbornerom;

import mod.vemerion.bloodbornerom.mobs.entities.RomDeathEntity;
import mod.vemerion.bloodbornerom.mobs.renderers.MissileRenderer;
import mod.vemerion.bloodbornerom.mobs.renderers.RomRenderer;
import mod.vemerion.bloodbornerom.mobs.renderers.RomSpiderRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = BloodborneRom.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {
	@SubscribeEvent
	public static void onRegister(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(BloodborneRom.ROM_SPIDER_ENTITY,
				(renderManager) -> new RomSpiderRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(BloodborneRom.ROM_ENTITY,
				(renderManager) -> new RomRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(BloodborneRom.MISSILE_ENTITY,
				(renderManager) -> new MissileRenderer(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(BloodborneRom.ROM_DEATH_ENTITY,
				(renderManager) -> new EntityRenderer<RomDeathEntity>(renderManager) {
					@Override
					public ResourceLocation getEntityTexture(RomDeathEntity entity) {
						return null;
					}
				});
	}
	
	@SubscribeEvent
	public static void onRegisterParticleFactories(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(BloodborneRom.BLUE_SMOKE_PARTICLE_TYPE,
				sprite -> new BlueSmokeParticle.Factory(sprite));
	}
}
