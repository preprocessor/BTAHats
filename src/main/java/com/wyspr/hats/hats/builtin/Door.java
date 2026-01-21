package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_BLEND;

public class Door {
	public static void render(Block<?> doorBottom, Block<?> doorTop) {
		float scale  = 0.625F;
		GL11.glTranslatef(-0.3125F, -0.5625F, -0.9375F);
		GL11.glScalef(scale, -scale, scale);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);

		GL11.glEnable(GL_BLEND);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		TextureRegistry.blockAtlas.bind();

		float f = 0.1875F;

		BlockModel<?> topModel = BlockModelDispatcher
			.getInstance()
			.getDispatch(doorTop);

		AABB topBounds = AABB.getTemporaryBB(0.0F, 1.0F, 0.0F, 1.0F, 2.0F, f);

		Tessellator.instance.startDrawingQuads();
		Tessellator.instance.setNormal(0.0F, 1.0F, 0.0F);
		topModel.renderTopFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topModel.getBlockTextureFromSideAndMetadata(Side.TOP, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		topModel.renderNorthFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topModel.getBlockTextureFromSideAndMetadata(Side.NORTH, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		topModel.renderSouthFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topModel.getBlockTextureFromSideAndMetadata(Side.SOUTH, 0)
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		topModel.renderWestFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topModel.getBlockTextureFromSideAndMetadata(Side.WEST, 0)
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		topModel.renderEastFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topModel.getBlockTextureFromSideAndMetadata(Side.EAST, 0)
		);

		BlockModel<?> bottomModel = BlockModelDispatcher
			.getInstance()
			.getDispatch(doorBottom);

		AABB bottomBounds = AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
		Tessellator.instance.setNormal(0.0F, -1.0F, 0.0F);
		bottomModel.renderBottomFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomModel.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		bottomModel.renderNorthFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomModel.getBlockTextureFromSideAndMetadata(Side.NORTH, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		bottomModel.renderSouthFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomModel.getBlockTextureFromSideAndMetadata(Side.SOUTH, 0)
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		bottomModel.renderWestFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomModel.getBlockTextureFromSideAndMetadata(Side.WEST, 0)
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		bottomModel.renderEastFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomModel.getBlockTextureFromSideAndMetadata(Side.EAST, 0)
		);

		Tessellator.instance.draw();
		GL11.glEnable(GL_BLEND);
	}
}
