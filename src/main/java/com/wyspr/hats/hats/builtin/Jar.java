package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

// it broked :(

public class Jar {
	public static void render() {
		GL11.glEnable(GL_BLEND);
		GL11.glDisable(GL_LIGHTING);
		GL11.glDisable(GL_TEXTURE_2D);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		Tessellator tessellator = Tessellator.instance;

		TextureRegistry.blockAtlas.bind();
		tessellator.startDrawingQuads();

		float brightness = 1.0F;
		float x = -0.5F;
		float y = 0.75F;
		float z = -0.5F;

		float          yOffset  = 0.0F;
		float extMinX = x + 0.5F - 0.1875F;
		float extMinY = y + yOffset;
		float extMinZ = z + 0.5F - 0.1875F;
		float extMaxX = x + 0.5F + 0.1875F;
		float extMaxY = y + 0.5F + yOffset;
		float extMaxZ = z + 0.5F + 0.1875F;
		float fillMaxY = y + 0.5F + yOffset - 0.25F;
		float intMinX = x + 0.5F - 0.1875F;
		float intMinY = y + yOffset;
		float intMinZ = z + 0.5F - 0.1875F;
		float intMaxX = x + 0.5F + 0.1875F;
		float intMaxY = y + 0.5F + yOffset;
		float          intMaxZ  = z + 0.5F + 0.1875F;
		IconCoordinate texIndex =  TextureRegistry.getTexture("minecraft:block/jar");
		double         texU     = texIndex.getIconUMin();
		double texV = texIndex.getIconVMin();
		double onePix = 0.0625F;
		double extSideMaxU = texIndex.getSubIconU(onePix * (double)6.0F);
		double extSideMinV = texIndex.getSubIconV(onePix * (double)6.0F);
		double extSideMaxV = texIndex.getSubIconV(onePix * (double)14.0F);
		double extBottomMinU = texIndex.getSubIconU(onePix * (double)6.0F);
		double extBottomMaxU = texIndex.getSubIconU(onePix * (double)12.0F);
		double extBottomMaxV = texIndex.getSubIconV(onePix * (double)6.0F);
		double extTopMaxU = texIndex.getSubIconU(onePix * (double)6.0F);
		double extTopMaxV = texIndex.getSubIconV(onePix * (double)6.0F);
		tessellator.setColorOpaque_F(brightness, brightness, brightness);
		tessellator.addVertexWithUV(intMaxX, intMinY, intMaxZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(intMinX, intMinY, intMaxZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(intMinX, intMaxY, intMaxZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(intMaxX, intMaxY, intMaxZ, texU, extSideMinV);
		tessellator.addVertexWithUV(intMinX, intMinY, intMinZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(intMaxX, intMinY, intMinZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(intMaxX, intMaxY, intMinZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(intMinX, intMaxY, intMinZ, texU, extSideMinV);
		tessellator.addVertexWithUV(intMinX, intMinY, intMaxZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(intMinX, intMinY, intMinZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(intMinX, intMaxY, intMinZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(intMinX, intMaxY, intMaxZ, texU, extSideMinV);
		tessellator.addVertexWithUV(intMaxX, intMinY, intMinZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(intMaxX, intMinY, intMaxZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(intMaxX, intMaxY, intMaxZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(intMaxX, intMaxY, intMinZ, texU, extSideMinV);
		tessellator.addVertexWithUV(extMinX, fillMaxY, extMaxZ, texU, extTopMaxV);
		tessellator.addVertexWithUV(extMaxX, fillMaxY, extMaxZ, extTopMaxU, extTopMaxV);
		tessellator.addVertexWithUV(extMaxX, fillMaxY, extMinZ, extTopMaxU, texV);
		tessellator.addVertexWithUV(extMinX, fillMaxY, extMinZ, texU, texV);
		tessellator.addVertexWithUV(
			extMinX, extMinY + 0.01F,
			extMaxZ, extBottomMinU, extBottomMaxV);
		tessellator.addVertexWithUV(
			extMaxX, extMinY + 0.01F,
			extMaxZ, extBottomMaxU, extBottomMaxV);
		tessellator.addVertexWithUV(extMaxX, extMinY + 0.01F, extMinZ, extBottomMaxU, texV);
		tessellator.addVertexWithUV(extMinX, extMinY + 0.01F, extMinZ, extBottomMinU, texV);
		tessellator.addVertexWithUV(extMaxX, extMinY, extMinZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(extMinX, extMinY, extMinZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(extMinX, extMaxY, extMinZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(extMaxX, extMaxY, extMinZ, texU, extSideMinV);
		tessellator.addVertexWithUV(extMinX, extMinY, extMaxZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(extMaxX, extMinY, extMaxZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(extMaxX, extMaxY, extMaxZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(extMinX, extMaxY, extMaxZ, texU, extSideMinV);
		tessellator.addVertexWithUV(extMaxX, extMinY, extMaxZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(extMaxX, extMinY, extMinZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(extMaxX, extMaxY, extMinZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(extMaxX, extMaxY, extMaxZ, texU, extSideMinV);
		tessellator.addVertexWithUV(extMinX, extMinY, extMinZ, texU, extSideMaxV);
		tessellator.addVertexWithUV(extMinX, extMinY, extMaxZ, extSideMaxU, extSideMaxV);
		tessellator.addVertexWithUV(extMinX, extMaxY, extMaxZ, extSideMaxU, extSideMinV);
		tessellator.addVertexWithUV(extMinX, extMaxY, extMinZ, texU, extSideMinV);
		tessellator.addVertexWithUV(intMinX, intMinY, intMinZ, extBottomMinU, texV);
		tessellator.addVertexWithUV(intMaxX, intMinY, intMinZ, extBottomMaxU, texV);
		tessellator.addVertexWithUV(intMaxX, intMinY, intMaxZ, extBottomMaxU, extBottomMaxV);
		tessellator.addVertexWithUV(intMinX, intMinY, intMaxZ, extBottomMinU, extBottomMaxV);
		tessellator.addVertexWithUV(extMinX, extMinY, extMinZ, extBottomMinU, texV);
		tessellator.addVertexWithUV(extMaxX, extMinY, extMinZ, extBottomMaxU, texV);
		tessellator.addVertexWithUV(extMaxX, extMinY, extMaxZ, extBottomMaxU, extBottomMaxV);
		tessellator.addVertexWithUV(extMinX, extMinY, extMaxZ, extBottomMinU, extBottomMaxV);


		GL11.glEnable(GL_TEXTURE_2D);
		GL11.glEnable(GL_LIGHTING);
		GL11.glDisable(GL_BLEND);

		Tessellator.instance.draw();
	}
}
