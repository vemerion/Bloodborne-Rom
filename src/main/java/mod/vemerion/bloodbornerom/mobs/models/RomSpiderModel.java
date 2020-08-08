package mod.vemerion.bloodbornerom.mobs.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.vemerion.bloodbornerom.mobs.entities.RomSpiderEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Created using Tabula 8.0.0
 */
public class RomSpiderModel extends EntityModel<RomSpiderEntity> {
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer neck;
	public ModelRenderer leg1Base;
	public ModelRenderer leg2Base;
	public ModelRenderer leg3Base;
	public ModelRenderer leftArmBase;
	public ModelRenderer leg4Base;
	public ModelRenderer leg5Base;
	public ModelRenderer leg6Base;
	public ModelRenderer rightArmBase;
	public ModelRenderer tail;
	public ModelRenderer eye1;
	public ModelRenderer eye2;
	public ModelRenderer eye3;
	public ModelRenderer eye4;
	public ModelRenderer eye5;
	public ModelRenderer eye6;
	public ModelRenderer eye7;
	public ModelRenderer eye8;
	public ModelRenderer leg1Top;
	public ModelRenderer leg1End;
	public ModelRenderer leg2Top;
	public ModelRenderer leg2End;
	public ModelRenderer leg3Top;
	public ModelRenderer leg3End;
	public ModelRenderer leftArmMiddle;
	public ModelRenderer leftArmCurv1;
	public ModelRenderer leftArmCurv2;
	public ModelRenderer leftArmCurv3;
	public ModelRenderer leg4Top;
	public ModelRenderer leg4End;
	public ModelRenderer leg5Top;
	public ModelRenderer leg5End;
	public ModelRenderer leg6Top;
	public ModelRenderer leg6End;
	public ModelRenderer rightArmMiddle;
	public ModelRenderer rightArmCurv1;
	public ModelRenderer rightArmCurv2;
	public ModelRenderer rightArmCurv3;


	public RomSpiderModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.leftArmCurv1 = new ModelRenderer(this, 32, 0);
		this.leftArmCurv1.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.leftArmCurv1.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftArmCurv1, 1.5247196451948906F, 0.0F, 0.0F);
		this.leg5Base = new ModelRenderer(this, 8, 0);
		this.leg5Base.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.leg5Base.addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg5Base, 0.1563815016444822F, 3.102497182471321F, -0.23457224414434488F);
		this.leftArmCurv3 = new ModelRenderer(this, 50, 0);
		this.leftArmCurv3.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.leftArmCurv3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftArmCurv3, 1.681101130194616F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 17.0F, 6.0F);
		this.body.addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.leg2Base = new ModelRenderer(this, 8, 0);
		this.leg2Base.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.leg2Base.addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg2Base, -0.11728612207217244F, 0.0F, 0.19547687289441354F);
		this.eye4 = new ModelRenderer(this, 0, 24);
		this.eye4.setRotationPoint(-3.0F, 1.0F, -4.5F);
		this.eye4.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.leftArmMiddle = new ModelRenderer(this, 55, 11);
		this.leftArmMiddle.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.leftArmMiddle.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftArmMiddle, -1.759291939273506F, 0.0F, 0.0F);
		this.leg1End = new ModelRenderer(this, 4, 0);
		this.leg1End.setRotationPoint(8.0F, 1.0F, 0.0F);
		this.leg1End.addBox(0.0F, -1.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg1End, 0.0F, 0.0F, -0.3909537457888271F);
		this.leftArmBase = new ModelRenderer(this, 8, 8);
		this.leftArmBase.setRotationPoint(3.0F, -4.0F, -8.0F);
		this.leftArmBase.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftArmBase, -1.0695377443168363F, -0.8210028961170991F, -0.03909537541112055F);
		this.leg1Top = new ModelRenderer(this, 32, 12);
		this.leg1Top.setRotationPoint(0.0F, -11.0F, 0.0F);
		this.leg1Top.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.rightArmCurv1 = new ModelRenderer(this, 32, 0);
		this.rightArmCurv1.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.rightArmCurv1.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightArmCurv1, 1.5247196451948906F, 0.0F, 0.0F);
		this.eye8 = new ModelRenderer(this, 0, 24);
		this.eye8.setRotationPoint(3.5F, 0.0F, -2.0F);
		this.eye8.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.rightArmBase = new ModelRenderer(this, 8, 8);
		this.rightArmBase.setRotationPoint(-3.0F, -4.0F, -8.0F);
		this.rightArmBase.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightArmBase, -0.8740609213566932F, 0.7428121536172364F, -0.03909537541112055F);
		this.eye6 = new ModelRenderer(this, 0, 24);
		this.eye6.setRotationPoint(-4.5F, -3.0F, 0.0F);
		this.eye6.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.leg5Top = new ModelRenderer(this, 32, 14);
		this.leg5Top.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.leg5Top.addBox(0.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg5Top, 0.0F, 0.0F, 0.5864306020384839F);
		this.eye7 = new ModelRenderer(this, 0, 24);
		this.eye7.setRotationPoint(3.5F, -2.0F, 0.0F);
		this.eye7.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 32, 24);
		this.tail.setRotationPoint(0.0F, 0.0F, 11.0F);
		this.tail.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.eye3 = new ModelRenderer(this, 0, 24);
		this.eye3.setRotationPoint(-2.0F, -3.0F, -4.5F);
		this.eye3.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye5 = new ModelRenderer(this, 0, 24);
		this.eye5.setRotationPoint(-4.5F, -1.0F, -3.0F);
		this.eye5.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.rightArmCurv3 = new ModelRenderer(this, 50, 0);
		this.rightArmCurv3.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.rightArmCurv3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightArmCurv3, 1.681101130194616F, 0.0F, 0.0F);
		this.leg1Base = new ModelRenderer(this, 0, 0);
		this.leg1Base.setRotationPoint(4.0F, 0.0F, -6.0F);
		this.leg1Base.addBox(0.0F, -10.0F, 0.0F, 1.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg1Base, -0.11728612207217244F, 0.0781907508222411F, 0.27366763203903305F);
		this.head = new ModelRenderer(this, 0, 24);
		this.head.setRotationPoint(0.0F, -2.0F, -16.0F);
		this.head.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(head, -0.3909537457888271F, 0.0F, 0.0F);
		this.eye1 = new ModelRenderer(this, 0, 24);
		this.eye1.setRotationPoint(0.0F, 0.0F, -4.5F);
		this.eye1.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.leg6End = new ModelRenderer(this, 12, 0);
		this.leg6End.setRotationPoint(8.0F, 0.0F, 0.0F);
		this.leg6End.addBox(0.0F, -1.0F, 0.0F, 1.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg6End, 0.0F, 0.0F, -0.5864306020384839F);
		this.leg3Top = new ModelRenderer(this, 32, 14);
		this.leg3Top.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.leg3Top.addBox(0.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg3Top, 0.0F, 0.0F, 0.46914448828868976F);
		this.rightArmMiddle = new ModelRenderer(this, 55, 11);
		this.rightArmMiddle.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.rightArmMiddle.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightArmMiddle, -1.759291939273506F, 0.0F, 0.0F);
		this.leg6Base = new ModelRenderer(this, 8, 0);
		this.leg6Base.setRotationPoint(-4.0F, 0.0F, 5.0F);
		this.leg6Base.addBox(0.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg6Base, 0.23457224414434488F, -2.94611583062965F, -0.1563815016444822F);
		this.neck = new ModelRenderer(this, 32, 0);
		this.neck.setRotationPoint(0.0F, 0.0F, -10.0F);
		this.neck.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.leg2Top = new ModelRenderer(this, 32, 14);
		this.leg2Top.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.leg2Top.addBox(0.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg2Top, 0.0F, 0.0F, 0.5864306020384839F);
		this.rightArmCurv2 = new ModelRenderer(this, 50, 12);
		this.rightArmCurv2.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.rightArmCurv2.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightArmCurv2, 1.1728612040769677F, 0.0F, 0.0F);
		this.leftArmCurv2 = new ModelRenderer(this, 50, 12);
		this.leftArmCurv2.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.leftArmCurv2.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftArmCurv2, 1.1728612040769677F, 0.0F, 0.0F);
		this.leg5End = new ModelRenderer(this, 12, 0);
		this.leg5End.setRotationPoint(8.0F, 0.0F, 0.0F);
		this.leg5End.addBox(0.0F, -1.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg5End, 0.0F, 0.0F, -0.7428121536172364F);
		this.leg6Top = new ModelRenderer(this, 32, 14);
		this.leg6Top.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.leg6Top.addBox(0.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg6Top, 0.0F, 0.0F, 0.46914448828868976F);
		this.leg3End = new ModelRenderer(this, 12, 0);
		this.leg3End.setRotationPoint(8.0F, 0.0F, 0.0F);
		this.leg3End.addBox(0.0F, -1.0F, 0.0F, 1.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg3End, 0.0F, 0.0F, -0.5864306020384839F);
		this.leg4Base = new ModelRenderer(this, 0, 0);
		this.leg4Base.setRotationPoint(-4.0F, 0.0F, -6.0F);
		this.leg4Base.addBox(0.0F, -10.0F, 0.0F, 1.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg4Base, 0.03909537541112055F, 3.141592653589793F, -0.27366763203903305F);
		this.leg3Base = new ModelRenderer(this, 8, 0);
		this.leg3Base.setRotationPoint(4.0F, 0.0F, 5.0F);
		this.leg3Base.addBox(0.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg3Base, -0.1563815016444822F, -0.27366763203903305F, 0.19547687289441354F);
		this.leg4End = new ModelRenderer(this, 4, 0);
		this.leg4End.setRotationPoint(8.0F, 1.0F, 0.0F);
		this.leg4End.addBox(0.0F, -1.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg4End, 0.0F, 0.0F, -0.3909537457888271F);
		this.leg4Top = new ModelRenderer(this, 32, 12);
		this.leg4Top.setRotationPoint(0.0F, -11.0F, 0.0F);
		this.leg4Top.addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye2 = new ModelRenderer(this, 0, 24);
		this.eye2.setRotationPoint(2.0F, -2.0F, -4.5F);
		this.eye2.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.leg2End = new ModelRenderer(this, 12, 0);
		this.leg2End.setRotationPoint(8.0F, 0.0F, 0.0F);
		this.leg2End.addBox(0.0F, -1.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leg2End, 0.0F, 0.0F, -0.7428121536172364F);
		this.leftArmMiddle.addChild(this.leftArmCurv1);
		this.body.addChild(this.leg5Base);
		this.leftArmCurv2.addChild(this.leftArmCurv3);
		this.body.addChild(this.leg2Base);
		this.head.addChild(this.eye4);
		this.leftArmBase.addChild(this.leftArmMiddle);
		this.leg1Top.addChild(this.leg1End);
		this.body.addChild(this.leftArmBase);
		this.leg1Base.addChild(this.leg1Top);
		this.rightArmMiddle.addChild(this.rightArmCurv1);
		this.head.addChild(this.eye8);
		this.body.addChild(this.rightArmBase);
		this.head.addChild(this.eye6);
		this.leg5Base.addChild(this.leg5Top);
		this.head.addChild(this.eye7);
		this.body.addChild(this.tail);
		this.head.addChild(this.eye3);
		this.head.addChild(this.eye5);
		this.rightArmCurv2.addChild(this.rightArmCurv3);
		this.body.addChild(this.leg1Base);
		this.body.addChild(this.head);
		this.head.addChild(this.eye1);
		this.leg6Top.addChild(this.leg6End);
		this.leg3Base.addChild(this.leg3Top);
		this.rightArmBase.addChild(this.rightArmMiddle);
		this.body.addChild(this.leg6Base);
		this.body.addChild(this.neck);
		this.leg2Base.addChild(this.leg2Top);
		this.rightArmCurv1.addChild(this.rightArmCurv2);
		this.leftArmCurv1.addChild(this.leftArmCurv2);
		this.leg5Top.addChild(this.leg5End);
		this.leg6Base.addChild(this.leg6Top);
		this.leg3Top.addChild(this.leg3End);
		this.body.addChild(this.leg4Base);
		this.body.addChild(this.leg3Base);
		this.leg4Top.addChild(this.leg4End);
		this.leg4Base.addChild(this.leg4Top);
		this.head.addChild(this.eye2);
		this.leg2Top.addChild(this.leg2End);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.body).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(RomSpiderEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// Move head
		if (!entityIn.isCobwebSpraying()) {
			setRotateAngle(head, headPitch * ((float) Math.PI / 180F), netHeadYaw * ((float) Math.PI / 180F), 0);
		} else {
			setRotateAngle(head, headPitch * ((float) Math.PI / 180F) - 0.2f, netHeadYaw * ((float) Math.PI / 180F), 0);

		}

		// Move legs
		if (!entityIn.isCobwebSpraying() && !entityIn.isJumpAttacking()) {
			setRotateAngle(leg1Base, leg1Base.rotateAngleX,
					MathHelper.sin((ageInTicks / 40) * (float) Math.PI * 2) * 0.1f,
					MathHelper.sin(((ageInTicks % 40 + 40) / 80) * (float) Math.PI * 2) * 0.1f + 0.3f);
			setRotateAngle(leg2Base, leg2Base.rotateAngleX,
					MathHelper.sin(((ageInTicks + 2) / 40) * (float) Math.PI * 2) * 0.1f,
					MathHelper.sin((((ageInTicks + 6) % 40 + 40) / 80) * (float) Math.PI * 2) * 0.1f + 0.1f);
			setRotateAngle(leg3Base, leg3Base.rotateAngleX,
					MathHelper.sin(((ageInTicks + 5) / 40) * (float) Math.PI * 2) * 0.1f,
					MathHelper.sin((((ageInTicks + 9) % 40 + 40) / 80) * (float) Math.PI * 2) * 0.1f + 0.1f);
			setRotateAngle(leg4Base, leg4Base.rotateAngleX,
					MathHelper.sin((ageInTicks / 40) * (float) Math.PI * 2) * 0.1f + (float) Math.PI * 1.2f,
					MathHelper.sin(((ageInTicks % 40 + 40) / 80) * (float) Math.PI * 2) * -0.1f - 0.35f);
			setRotateAngle(leg5Base, leg5Base.rotateAngleX,
					MathHelper.sin(((ageInTicks + 2) / 40) * (float) Math.PI * 2) * 0.1f + (float) Math.PI * 1.2f,
					MathHelper.sin((((ageInTicks + 6) % 40 + 40) / 80) * (float) Math.PI * 2) * -0.1f - 0.1f);
			setRotateAngle(leg6Base, leg6Base.rotateAngleX,
					MathHelper.sin(((ageInTicks + 5) / 40) * (float) Math.PI * 2) * 0.1f + (float) Math.PI * 1.2f,
					MathHelper.sin((((ageInTicks + 9) % 40 + 40) / 80) * (float) Math.PI * 2) * -0.1f - 0.1f);
		}

		// Move Arms
		if (!entityIn.isJumpAttacking()) {
			if (!entityIn.isMeleeAttacking()) {
				leftArmBase.rotateAngleX = MathHelper.sin((ageInTicks / 40) * (float) Math.PI * 2) * 0.1f
						- (float) Math.PI * 0.3f;
				rightArmBase.rotateAngleX = MathHelper.sin((ageInTicks / 34) * (float) Math.PI * 2) * 0.1f
						- (float) Math.PI * 0.38f;
			} else {
				leftArmBase.rotateAngleX = MathHelper.sin((ageInTicks / 15) * (float) Math.PI * 2) * 0.1f
						- (float) Math.PI * 0.3f;
				rightArmBase.rotateAngleX = MathHelper.sin((ageInTicks / 9) * (float) Math.PI * 2) * 0.1f
						- (float) Math.PI * 0.38f;
			}
		}

	}
	
	   public void setLivingAnimations(RomSpiderEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
			body.rotateAngleX = entityIn.getJumpRotationAmount(partialTick);
	   }

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
