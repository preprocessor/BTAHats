package com.wyspr.hats.hats.custom;

import net.minecraft.client.render.tessellator.Tessellator;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class PlumBob {
	public static void render() {
		float scale = 0.5625F;
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -0.625F, 0.0F);
		GL11.glScalef(scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);

		GL11.glEnable(GL_BLEND);
		GL11.glCullFace(GL_FRONT);
		GL11.glEnable(GL_CULL_FACE);
		GL11.glDisable(GL_LIGHTING);
		GL11.glDisable(GL_TEXTURE_2D);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		float longSideLength  = 0.5F;
		float shortSideLength = 0.25F;
		float d               = shortSideLength - 0.0335F;
		float e               = longSideLength;
		float f               = shortSideLength / 2;

		float bgScale = 1.1F;
		GL11.glScalef(bgScale, bgScale, bgScale);
		GL11.glTranslatef(0.0F, -0.05F, 0.0F);

		float outlineR = 0.0F;
		float outlineG = 0.247F;
		float outlineB = 0.098F;
		float outlineA = 0.5F;

		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);

		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, -2 *longSideLength, 0.0F);

		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		renderTri(outlineR, outlineG, outlineB, outlineA, d, e, f);

		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, -2 *longSideLength, 0.0F);
		GL11.glScalef(1 / bgScale, 1 / bgScale, 1 / bgScale);
		GL11.glTranslatef(0.0F, 0.05F, 0.0F);

		GL11.glCullFace(GL_BACK);

		renderHalf(d, e, f);

		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, -2 *longSideLength, 0.0F);

		renderHalf(d, e, f);

		GL11.glEnable(GL_TEXTURE_2D);
		GL11.glEnable(GL_LIGHTING);
		GL11.glDisable(GL_CULL_FACE);
		GL11.glDisable(GL_BLEND);
		GL11.glPopMatrix();
	}

	private static void renderHalf(float d, float e, float f) {
		renderTri(0.43F, 0.78F, 0.12F, 0.75F, d, e, f);

		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

		renderTri(0.43F, 0.68F, 0.12F, 0.75F, d, e, f);

		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

		renderTri(0.43F, 0.78F, 0.12F, 0.75F, d, e, f);

		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

		renderTri(0.43F, 0.68F, 0.12F, 0.75F, d, e, f);

		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

		renderTri(0.43F, 0.78F, 0.12F, 0.75F, d, e, f);

		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

		renderTri(0.43F, 0.68F, 0.12F, 0.75F, d, e, f);
	}

	private static void renderTri(
		float r,
		float g,
		float b,
		float alpha,
		float d,
		float e,
		float f
	)
	{
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();

		tess.setColorRGBA_F(r, g, b, alpha);

		tess.addVertex(0.0F, 0.0F, 0.0F);
		tess.addVertex(d, e, -f);
		tess.addVertex(d, e, f);
		tess.addVertex(0.0F, 0.0F, 0.0F);

		Tessellator.instance.draw();
	}
}
