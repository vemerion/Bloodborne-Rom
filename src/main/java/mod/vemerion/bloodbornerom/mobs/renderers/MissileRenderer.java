package mod.vemerion.bloodbornerom.mobs.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.vemerion.bloodbornerom.BloodborneRom;
import mod.vemerion.bloodbornerom.mobs.entities.MissileEntity;
import mod.vemerion.bloodbornerom.mobs.models.MissileModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class MissileRenderer extends EntityRenderer<MissileEntity> {
	private final MissileModel model = new MissileModel();
	private static final ResourceLocation MISSILE_TEXTURES = new ResourceLocation(BloodborneRom.MODID, "textures/entity/missile.png");


	public MissileRenderer(EntityRendererManager rendererManager) {
		super(rendererManager);
	}

	@Override
	protected int getBlockLight(MissileEntity entityIn, float partialTicks) {
		return 15;
	}

	@Override
	public void render(MissileEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		model.setRotationAngles(entityIn, 0, 0, entityIn.ticksExisted + partialTicks, 0, 0);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.getRenderType(getEntityTexture(entityIn)));
		this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
				1.0F);
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(MissileEntity entity) {
		return MISSILE_TEXTURES;
	}
}
