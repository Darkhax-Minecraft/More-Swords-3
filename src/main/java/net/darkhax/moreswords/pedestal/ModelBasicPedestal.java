package net.darkhax.moreswords.pedestal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelBasicPedestal extends ModelBase {

	ModelRenderer base;
	ModelRenderer peg1;
	ModelRenderer peg2;

	public ModelBasicPedestal() {

		textureWidth = 64;
		textureHeight = 32;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 12, 3, 12);
		base.setRotationPoint(-6F, 21F, -6F);
		base.setTextureSize(64, 32);
		base.mirror = true;
		setRotation(base, 0F, -0.0185893F, 0F);

		peg1 = new ModelRenderer(this, 2, 19);
		peg1.addBox(0F, 0F, 0F, 2, 5, 2);
		peg1.setRotationPoint(-1F, 16F, 2F);
		peg1.setTextureSize(64, 32);
		peg1.mirror = true;
		setRotation(peg1, 0F, -0.0185893F, 0F);

		peg2 = new ModelRenderer(this, 2, 19);
		peg2.addBox(0F, 0F, 0F, 2, 5, 2);
		peg2.setRotationPoint(-1F, 16F, -4F);
		peg2.setTextureSize(64, 32);
		peg2.mirror = true;
		setRotation(peg2, 0F, 0F, 0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
