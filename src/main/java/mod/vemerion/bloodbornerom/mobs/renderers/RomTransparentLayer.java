package mod.vemerion.bloodbornerom.mobs.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.vemerion.bloodbornerom.BloodborneRom;
import mod.vemerion.bloodbornerom.mobs.entities.RomEntity;
import mod.vemerion.bloodbornerom.mobs.models.RomModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RomTransparentLayer extends LayerRenderer<RomEntity, RomModel> {
	private static final ResourceLocation ROM_TRANSPARENT = new ResourceLocation(BloodborneRom.MODID,
			"textures/entity/rom_transparent.png");
	private final RomModel romModel = new RomModel();

	public RomTransparentLayer(IEntityRenderer<RomEntity, RomModel> p_i50923_1_) {
		super(p_i50923_1_);
	}

	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, RomEntity entity,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		if (entity.getTeleportDuration() < 50) {
			this.getEntityModel().copyModelAttributesTo(romModel);
			this.romModel.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTicks);
			this.romModel.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(ROM_TRANSPARENT));
			this.romModel.render(matrixStackIn, ivertexbuilder, packedLightIn,
					LivingRenderer.getPackedOverlay(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}