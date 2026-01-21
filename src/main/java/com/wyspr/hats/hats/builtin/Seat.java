package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_BLEND;

public class Seat {
	public static void render() {
		float scale  = 0.625F;
		float offset = -0.3125F;
		GL11.glTranslatef(offset, -0.25F, offset);
		GL11.glScalef(scale, -scale, scale);

		GL11.glEnable(GL_BLEND);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		TextureRegistry.blockAtlas.bind();


		BlockModel<?> model = BlockModelDispatcher
			.getInstance()
			.getDispatch(Blocks.SEAT);

		AABB bounds = model.getBlockBoundsForItemRender();

		Tessellator.instance.startDrawingQuads();
		Tessellator.instance.setNormal(0.0F, 1.0F, 0.0F);
		model.renderTopFace(
			Tessellator.instance, bounds, 0.0F, 0.0F,
			0.0F, model.getBlockTextureFromSideAndMetadata(Side.TOP, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		model.renderNorthFace(
			Tessellator.instance, bounds, 0.0F, 0.0F,
			0.0F, model.getBlockTextureFromSideAndMetadata(Side.NORTH, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		model.renderSouthFace(
			Tessellator.instance, bounds, 0.0F, 0.0F,
			0.0F, model.getBlockTextureFromSideAndMetadata(Side.SOUTH, 0)
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		model.renderWestFace(
			Tessellator.instance, bounds, 0.0F, 0.0F,
			0.0F, model.getBlockTextureFromSideAndMetadata(Side.WEST, 0)
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		model.renderEastFace(
			Tessellator.instance, bounds, 0.0F, 0.0F,
			0.0F, model.getBlockTextureFromSideAndMetadata(Side.EAST, 0)
		);

		Tessellator.instance.draw();
		GL11.glEnable(GL_BLEND);
	}
}
