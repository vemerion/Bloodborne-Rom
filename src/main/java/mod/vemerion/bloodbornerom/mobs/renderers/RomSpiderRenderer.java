package mod.vemerion.bloodbornerom.mobs.renderers;

import mod.vemerion.bloodbornerom.BloodborneRom;
import mod.vemerion.bloodbornerom.mobs.entities.RomSpiderEntity;
import mod.vemerion.bloodbornerom.mobs.models.RomSpiderModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RomSpiderRenderer extends MobRenderer<RomSpiderEntity, RomSpiderModel> {
	private static final ResourceLocation ROM_SPIDER_TEXTURES = new ResourceLocation(BloodborneRom.MODID, "textures/entity/rom_spider.png");


	public RomSpiderRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RomSpiderModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(RomSpiderEntity entity) {
		return ROM_SPIDER_TEXTURES;
	}
}
