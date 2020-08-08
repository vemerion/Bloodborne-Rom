package mod.vemerion.bloodbornerom.mobs.models;


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.vemerion.bloodbornerom.mobs.entities.RomEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Created using Tabula 8.0.0
 */
public class RomModel extends EntityModel<RomEntity> {
	public ModelRenderer middle;
	public ModelRenderer front1;
	public ModelRenderer back1;
	public ModelRenderer leg1;
	public ModelRenderer leg5;
	public ModelRenderer flowersMiddleLeft;
	public ModelRenderer flowersMiddleRight;
	public ModelRenderer front2;
	public ModelRenderer leg3;
	public ModelRenderer leg7;
	public ModelRenderer flowersFront1Left;
	public ModelRenderer flowersFront1Right;
	public ModelRenderer front3;
	public ModelRenderer leg4;
	public ModelRenderer leg8;
	public ModelRenderer flowersFront2Left;
	public ModelRenderer flowersFront2Right;
	public ModelRenderer head;
	public ModelRenderer eye1;
	public ModelRenderer eye2;
	public ModelRenderer eye3;
	public ModelRenderer eye4;
	public ModelRenderer eye5;
	public ModelRenderer eye6;
	public ModelRenderer eye7;
	public ModelRenderer eye8;
	public ModelRenderer eye9;
	public ModelRenderer eye10;
	public ModelRenderer eye11;
	public ModelRenderer eye12;
	public ModelRenderer eye13;
	public ModelRenderer eye14;
	public ModelRenderer eye15;
	public ModelRenderer eye16;
	public ModelRenderer eye17;
	public ModelRenderer eye18;
	public ModelRenderer back2;
	public ModelRenderer leg2;
	public ModelRenderer leg6;
	public ModelRenderer flowersBack1Left;
	public ModelRenderer flowersBack1Right;
	public ModelRenderer back3;
	public ModelRenderer flowersBack2Left;
	public ModelRenderer flowersBack2Right;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tail4;

	private float animationStart;

	public RomModel() {
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.flowersMiddleRight = new ModelRenderer(this, 36, 138);
		this.flowersMiddleRight.setRotationPoint(-24.0F, -24.0F, 0.0F);
		this.flowersMiddleRight.addBox(0.0F, -8.0F, 0.0F, 48.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flowersMiddleRight, 0.0F, -3.141592653589793F, -1.5707963267948966F);
		this.front2 = new ModelRenderer(this, 140, 0);
		this.front2.setRotationPoint(3.0F, 3.0F, -19.0F);
		this.front2.addBox(-16.0F, -16.0F, -9.0F, 32.0F, 32.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.back1 = new ModelRenderer(this, 0, 70);
		this.back1.setRotationPoint(2.0F, 2.0F, 21.0F);
		this.back1.addBox(-20.0F, -20.0F, -10.0F, 40.0F, 40.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 0);
		this.leg2.setRotationPoint(20.0F, 16.0F, 0.0F);
		this.leg2.addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.eye12 = new ModelRenderer(this, 0, 9);
		this.eye12.setRotationPoint(-13.0F, -9.0F, -18.0F);
		this.eye12.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.eye1 = new ModelRenderer(this, 0, 9);
		this.eye1.setRotationPoint(-7.0F, -5.0F, -25.0F);
		this.eye1.addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye6 = new ModelRenderer(this, 0, 9);
		this.eye6.setRotationPoint(-8.0F, -10.0F, -25.0F);
		this.eye6.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye7 = new ModelRenderer(this, 0, 9);
		this.eye7.setRotationPoint(7.0F, -9.0F, -25.0F);
		this.eye7.addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.front1 = new ModelRenderer(this, 0, 70);
		this.front1.setRotationPoint(2.0F, 2.0F, -21.0F);
		this.front1.addBox(-20.0F, -20.0F, -10.0F, 40.0F, 40.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.eye9 = new ModelRenderer(this, 0, 9);
		this.eye9.setRotationPoint(-9.0F, 1.0F, -25.0F);
		this.eye9.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.leg7 = new ModelRenderer(this, 0, 0);
		this.leg7.setRotationPoint(16.0F, 20.0F, 0.0F);
		this.leg7.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.flowersBack2Right = new ModelRenderer(this, 36, 138);
		this.flowersBack2Right.setRotationPoint(-16.0F, -16.0F, 0.0F);
		this.flowersBack2Right.addBox(0.0F, -8.0F, 0.0F, 32.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flowersBack2Right, 0.0F, -3.141592653589793F, -1.5707963267948966F);
		this.flowersBack1Right = new ModelRenderer(this, 36, 138);
		this.flowersBack1Right.setRotationPoint(-20.0F, -20.0F, 0.0F);
		this.flowersBack1Right.addBox(0.0F, -8.0F, 0.0F, 40.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flowersBack1Right, 0.0F, -3.141592653589793F, -1.5707963267948966F);
		this.leg4 = new ModelRenderer(this, 0, 0);
		this.leg4.setRotationPoint(16.0F, 14.0F, 0.0F);
		this.leg4.addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.leg8 = new ModelRenderer(this, 0, 0);
		this.leg8.setRotationPoint(14.0F, 16.0F, 0.0F);
		this.leg8.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.flowersBack2Left = new ModelRenderer(this, 36, 138);
		this.flowersBack2Left.setRotationPoint(-16.0F, -24.0F, 0.0F);
		this.flowersBack2Left.addBox(0.0F, 0.0F, 0.0F, 32.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.leg6 = new ModelRenderer(this, 0, 0);
		this.leg6.setRotationPoint(16.0F, 20.0F, 0.0F);
		this.leg6.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.eye11 = new ModelRenderer(this, 0, 9);
		this.eye11.setRotationPoint(-3.0F, -10.0F, -25.0F);
		this.eye11.addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye14 = new ModelRenderer(this, 0, 9);
		this.eye14.setRotationPoint(-13.0F, -6.0F, -21.0F);
		this.eye14.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye3 = new ModelRenderer(this, 0, 9);
		this.eye3.setRotationPoint(4.0F, -6.0F, -25.0F);
		this.eye3.addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye16 = new ModelRenderer(this, 0, 9);
		this.eye16.setRotationPoint(12.0F, -3.0F, -20.0F);
		this.eye16.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.eye13 = new ModelRenderer(this, 0, 9);
		this.eye13.setRotationPoint(-13.0F, -4.0F, -18.0F);
		this.eye13.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.flowersFront2Left = new ModelRenderer(this, 36, 138);
		this.flowersFront2Left.setRotationPoint(-16.0F, -24.0F, 0.0F);
		this.flowersFront2Left.addBox(0.0F, 0.0F, 0.0F, 32.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.eye2 = new ModelRenderer(this, 0, 9);
		this.eye2.setRotationPoint(-6.0F, -6.0F, -25.0F);
		this.eye2.addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.eye18 = new ModelRenderer(this, 0, 9);
		this.eye18.setRotationPoint(12.0F, -4.0F, -14.0F);
		this.eye18.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.flowersFront1Left = new ModelRenderer(this, 36, 138);
		this.flowersFront1Left.setRotationPoint(-20.0F, -28.0F, 0.0F);
		this.flowersFront1Left.addBox(0.0F, 0.0F, 0.0F, 40.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.eye4 = new ModelRenderer(this, 0, 9);
		this.eye4.setRotationPoint(3.0F, -5.0F, -25.0F);
		this.eye4.addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 120, 90);
		this.head.setRotationPoint(3.0F, 3.0F, -8.0F);
		this.head.addBox(-12.0F, -12.0F, -24.0F, 24.0F, 24.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(head, 0.0F, 0.0F, -0.7853981633974483F);
		this.flowersFront2Right = new ModelRenderer(this, 36, 138);
		this.flowersFront2Right.setRotationPoint(-16.0F, -16.0F, 0.0F);
		this.flowersFront2Right.addBox(0.0F, -8.0F, 0.0F, 32.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flowersFront2Right, 0.0F, -3.141592653589793F, -1.5707963267948966F);
		this.eye5 = new ModelRenderer(this, 0, 9);
		this.eye5.setRotationPoint(2.0F, -8.0F, -25.0F);
		this.eye5.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.back2 = new ModelRenderer(this, 140, 0);
		this.back2.setRotationPoint(3.0F, 3.0F, 19.0F);
		this.back2.addBox(-16.0F, -16.0F, -9.0F, 32.0F, 32.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.tail2 = new ModelRenderer(this, 0, 130);
		this.tail2.setRotationPoint(4.0F, -3.0F, 8.0F);
		this.tail2.addBox(-1.5F, -1.0F, -1.0F, 3.0F, 80.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(tail2, 1.5707963267948966F, 0.0F, 0.0F);
		this.flowersFront1Right = new ModelRenderer(this, 36, 138);
		this.flowersFront1Right.setRotationPoint(-20.0F, -20.0F, 0.0F);
		this.flowersFront1Right.addBox(0.0F, -8.0F, 0.0F, 40.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flowersFront1Right, 0.0F, -3.141592653589793F, -1.5707963267948966F);
		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.setRotationPoint(24.0F, 16.0F, 0.0F);
		this.leg1.addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.middle = new ModelRenderer(this, 0, 0);
		this.middle.setRotationPoint(0.0F, -10.0F, 0.0F);
		this.middle.addBox(-24.0F, -24.0F, -11.0F, 48.0F, 48.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(middle, 0.0F, 0.0F, 0.7853981633974483F);
		this.flowersBack1Left = new ModelRenderer(this, 36, 138);
		this.flowersBack1Left.setRotationPoint(-20.0F, -28.0F, 0.0F);
		this.flowersBack1Left.addBox(0.0F, 0.0F, 0.0F, 40.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.tail1 = new ModelRenderer(this, 28, 130);
		this.tail1.setRotationPoint(6.0F, 4.0F, 8.0F);
		this.tail1.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 50.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(tail1, 1.5707963267948966F, 0.0F, 0.0F);
		this.eye15 = new ModelRenderer(this, 0, 9);
		this.eye15.setRotationPoint(12.0F, -7.0F, -18.0F);
		this.eye15.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.back3 = new ModelRenderer(this, 140, 50);
		this.back3.setRotationPoint(3.0F, 3.0F, 17.0F);
		this.back3.addBox(-12.0F, -12.0F, -8.0F, 24.0F, 24.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.front3 = new ModelRenderer(this, 140, 50);
		this.front3.setRotationPoint(3.0F, 3.0F, -17.0F);
		this.front3.addBox(-12.0F, -12.0F, -8.0F, 24.0F, 24.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.eye10 = new ModelRenderer(this, 0, 9);
		this.eye10.setRotationPoint(-10.0F, 5.0F, -25.0F);
		this.eye10.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.tail4 = new ModelRenderer(this, 10, 130);
		this.tail4.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.tail4.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 35.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(tail4, 1.5707963267948966F, 0.0F, 0.0F);
		this.leg5 = new ModelRenderer(this, 0, 0);
		this.leg5.setRotationPoint(16.0F, 24.0F, 0.0F);
		this.leg5.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.leg3 = new ModelRenderer(this, 0, 0);
		this.leg3.setRotationPoint(20.0F, 16.0F, 0.0F);
		this.leg3.addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.eye8 = new ModelRenderer(this, 0, 9);
		this.eye8.setRotationPoint(8.0F, 3.0F, -25.0F);
		this.eye8.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.flowersMiddleLeft = new ModelRenderer(this, 36, 138);
		this.flowersMiddleLeft.setRotationPoint(-24.0F, -32.0F, 0.0F);
		this.flowersMiddleLeft.addBox(0.0F, 0.0F, 0.0F, 48.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.eye17 = new ModelRenderer(this, 0, 9);
		this.eye17.setRotationPoint(12.0F, -10.0F, -20.0F);
		this.eye17.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.tail3 = new ModelRenderer(this, 16, 130);
		this.tail3.setRotationPoint(-4.0F, 6.0F, 8.0F);
		this.tail3.addBox(-1.5F, -1.5F, -1.5F, 3.0F, 60.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(tail3, 1.5707963267948966F, 0.0F, 0.0F);
		this.middle.addChild(this.flowersMiddleRight);
		this.front1.addChild(this.front2);
		this.middle.addChild(this.back1);
		this.back1.addChild(this.leg2);
		this.head.addChild(this.eye12);
		this.head.addChild(this.eye1);
		this.head.addChild(this.eye6);
		this.head.addChild(this.eye7);
		this.middle.addChild(this.front1);
		this.head.addChild(this.eye9);
		this.front1.addChild(this.leg7);
		this.back2.addChild(this.flowersBack2Right);
		this.back1.addChild(this.flowersBack1Right);
		this.front2.addChild(this.leg4);
		this.front2.addChild(this.leg8);
		this.back2.addChild(this.flowersBack2Left);
		this.back1.addChild(this.leg6);
		this.head.addChild(this.eye11);
		this.head.addChild(this.eye14);
		this.head.addChild(this.eye3);
		this.head.addChild(this.eye16);
		this.head.addChild(this.eye13);
		this.front2.addChild(this.flowersFront2Left);
		this.head.addChild(this.eye2);
		this.head.addChild(this.eye18);
		this.front1.addChild(this.flowersFront1Left);
		this.head.addChild(this.eye4);
		this.front3.addChild(this.head);
		this.front2.addChild(this.flowersFront2Right);
		this.head.addChild(this.eye5);
		this.back1.addChild(this.back2);
		this.back3.addChild(this.tail2);
		this.front1.addChild(this.flowersFront1Right);
		this.middle.addChild(this.leg1);
		this.back1.addChild(this.flowersBack1Left);
		this.back3.addChild(this.tail1);
		this.head.addChild(this.eye15);
		this.back2.addChild(this.back3);
		this.front2.addChild(this.front3);
		this.head.addChild(this.eye10);
		this.back3.addChild(this.tail4);
		this.middle.addChild(this.leg5);
		this.front1.addChild(this.leg3);
		this.head.addChild(this.eye8);
		this.middle.addChild(this.flowersMiddleLeft);
		this.head.addChild(this.eye17);
		this.back3.addChild(this.tail3);
	}


	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {

		ImmutableList.of(this.middle).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(RomEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		setRotateAngle(head, headPitch * ((float) Math.PI / 180F), netHeadYaw * ((float) Math.PI / 180F),
				(float) -Math.PI / 4);

		if (entityIn.doingMissileBarrage()) {
			curvLShape(animationStart, ageInTicks);
		} else if (entityIn.doingAreaOfEffect()) {
			curvUShape(animationStart, ageInTicks);
		} else if (entityIn.doingCircleMissiles()) {
			roll(animationStart, ageInTicks);
		} else if (entityIn.doingMeleeAttack()) {
			shake(animationStart, ageInTicks);
		} else {
			animationStart = ageInTicks;
			setRotateAngle(middle, 0, 0, (float) Math.PI / 4);
			setRotateAngle(back1, 0, 0, 0);
			setRotateAngle(back2, 0, 0, 0);
			setRotateAngle(back3, 0, 0, 0);
			setRotateAngle(front1, 0, 0, 0);
			setRotateAngle(front2, 0, 0, 0);
			setRotateAngle(front3, 0, 0, 0);

			// Legs
			leg1.rotateAngleZ = -(MathHelper.sin((ageInTicks / 21) * (float) Math.PI * 2) + 1) * 0.2f;
			leg2.rotateAngleZ = -(MathHelper.sin((ageInTicks / 15) * (float) Math.PI * 2) + 1) * 0.2f;
			leg3.rotateAngleZ = -(MathHelper.sin((ageInTicks / 12) * (float) Math.PI * 2) + 1) * 0.2f;
			leg4.rotateAngleZ = -(MathHelper.sin((ageInTicks / 24) * (float) Math.PI * 2) + 1) * 0.2f;
			leg5.rotateAngleZ = (MathHelper.sin((ageInTicks / 20) * (float) Math.PI * 2) + 1) * 0.2f;
			leg6.rotateAngleZ = (MathHelper.sin((ageInTicks / 21) * (float) Math.PI * 2) + 1) * 0.2f;
			leg7.rotateAngleZ = (MathHelper.sin((ageInTicks / 19) * (float) Math.PI * 2) + 1) * 0.2f;
			leg8.rotateAngleZ = (MathHelper.sin((ageInTicks / 16) * (float) Math.PI * 2) + 1) * 0.2f;

		}
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private void curvUShape(float ageInTicksStart, float ageInTicks) {
		float interval = ageInTicks - ageInTicksStart;
		if (interval < 40) {
			ImmutableList.of(front1, front2, front3).forEach((model) -> {
				setRotateAngle(model, -MathHelper.lerp(interval / 40, 0, (float) Math.PI / 8),
						MathHelper.lerp(interval / 40, 0, (float) Math.PI / 8), model.rotateAngleZ);
			});
			ImmutableList.of(back1, back2, back3).forEach((model) -> {
				setRotateAngle(model, MathHelper.lerp(interval / 40, 0, (float) Math.PI / 8),
						-MathHelper.lerp(interval / 40, 0, (float) Math.PI / 8), model.rotateAngleZ);
			});
		} else if (interval > 60) {
			float pct = Math.min(1, (interval - 60) / 40);
			ImmutableList.of(front1, front2, front3).forEach((model) -> {
				setRotateAngle(model, -MathHelper.lerp(pct, (float) Math.PI / 8, 0),
						MathHelper.lerp(pct, (float) Math.PI / 8, 0), model.rotateAngleZ);
			});
			ImmutableList.of(back1, back2, back3).forEach((model) -> {
				setRotateAngle(model, MathHelper.lerp(pct, (float) Math.PI / 8, 0),
						-MathHelper.lerp(pct, (float) Math.PI / 8, 0), model.rotateAngleZ);
			});
		}
	}

	private void curvLShape(float ageInTicksStart, float ageInTicks) {
		float interval = ageInTicks - ageInTicksStart;
		if (interval < 40) {
			ImmutableList.of(front1, front2).forEach((model) -> {
				setRotateAngle(model, -MathHelper.lerp(interval / 40, 0, (float) Math.PI / 10),
						MathHelper.lerp(interval / 40, 0, (float) Math.PI / 10), model.rotateAngleZ);
			});
		} else if (interval >= 60) {
			float pct = Math.min(1, (interval - 60) / 40);
			ImmutableList.of(front1, front2).forEach((model) -> {
				setRotateAngle(model, -MathHelper.lerp(pct, (float) Math.PI / 10, 0),
						MathHelper.lerp(pct, (float) Math.PI / 10, 0), model.rotateAngleZ);
			});
		}
	}

	private void roll(float ageInTicksStart, float ageInTicks) {
		float interval = ageInTicks - ageInTicksStart;
		if (interval < 40) {
			setRotateAngle(middle, middle.rotateAngleX, middle.rotateAngleY,
					MathHelper.lerp(interval / 40, (float) Math.PI / 4, (float) Math.PI * 1.25f));
		} else if (interval >= 80) {
			float pct = Math.min(1, (interval - 80) / 40);
			ImmutableList.of(front1, front2).forEach((model) -> {
				setRotateAngle(middle, middle.rotateAngleX, middle.rotateAngleY,
						MathHelper.lerp(pct, (float) Math.PI * 1.25f, (float) Math.PI / 4));
			});
		}
	}

	private void shake(float ageInTicksStart, float ageInTicks) {
		float interval = ageInTicks - ageInTicksStart;
		if (interval < 60) {
			middle.rotateAngleX = MathHelper.sin((interval / 30) * (float) Math.PI * 2) * 0.1f;
			middle.rotateAngleY = MathHelper.sin((interval / 30) * (float) Math.PI * 2) * 0.1f;
			front1.rotateAngleX = MathHelper.sin((interval / 30) * (float) Math.PI * 2) * 0.43f;
			front1.rotateAngleY = MathHelper.sin((interval / 30) * (float) Math.PI * 2) * 0.43f;

		}
	}

	@SuppressWarnings("unused")
	private void shiver(float ageInTicksStart, float ageInTicks) {
		float interval = ageInTicks - ageInTicksStart;
		middle.rotateAngleZ = MathHelper.sin((interval / 15) * (float) Math.PI * 2) * ((float) Math.PI / 50)
				+ (float) Math.PI / 4;
		front1.rotateAngleZ = MathHelper.sin((interval / 13) * (float) Math.PI * 2) * ((float) Math.PI / 30);
		front2.rotateAngleZ = -MathHelper.sin((interval / 9) * (float) Math.PI * 2) * ((float) Math.PI / 30);
		front3.rotateAngleZ = MathHelper.sin((interval / 14) * (float) Math.PI * 2) * ((float) Math.PI / 30);
		back1.rotateAngleZ = -MathHelper.sin((interval / 16) * (float) Math.PI * 2) * ((float) Math.PI / 30);
		back2.rotateAngleZ = MathHelper.sin((interval / 8) * (float) Math.PI * 2) * ((float) Math.PI / 30);
		back3.rotateAngleZ = -MathHelper.sin((interval / 13) * (float) Math.PI * 2) * ((float) Math.PI / 30);
	}
}
