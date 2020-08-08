package mod.vemerion.bloodbornerom.mobs.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.vemerion.bloodbornerom.BloodborneRom;
import mod.vemerion.bloodbornerom.mobs.entities.RomEntity;
import mod.vemerion.bloodbornerom.mobs.models.RomModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RomRenderer extends MobRenderer<RomEntity, RomModel> {
	private static final ResourceLocation ROM_TEXTURES = new ResourceLocation(BloodborneRom.MODID,
			"textures/entity/rom.png");

	public RomRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RomModel(), 1f);
		this.addLayer(new RomTransparentLayer(this));
	}

	@Override
	public void render(RomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		if (entityIn.isTeleporting())
			matrixStackIn.rotate(new Quaternion(0, entityIn.getTurningValue(partialTicks), 0, true));
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		matrixStackIn.pop();
	}

	@Override
	public ResourceLocation getEntityTexture(RomEntity entity) {
		return ROM_TEXTURES;
	}
}
