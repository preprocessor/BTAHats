package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.phys.AABB;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_BLEND;

public class PaintedDoor {
	public static void render(Block<?> doorBottom, Block<?> doorTop, ItemStack itemStack) {
		float scale  = 0.625F;
		GL11.glTranslatef(-0.3125F, -0.5625F, -0.9375F);
		GL11.glScalef(scale, -scale, scale);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);

		GL11.glEnable(GL_BLEND);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		TextureRegistry.blockAtlas.bind();


		BlockModel<?> topModel = BlockModelDispatcher
			.getInstance()
			.getDispatch(doorTop);

		float sideLength = 0.1875F;
		AABB  topBounds  = AABB.getTemporaryBB(0.0F, 1.0F, 0.0F, 1.0F, 2.0F, sideLength);
		String color =
			DyeColor.colorFromBlockMeta(15 - itemStack.getMetadata()).colorID;
		IconCoordinate topTexture = TextureRegistry.getTexture("minecraft:block/door/planks_" + color + "/top");

		Tessellator.instance.startDrawingQuads();
		Tessellator.instance.setNormal(0.0F, 1.0F, 0.0F);
		topModel.renderTopFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, TextureRegistry.getTexture("minecraft:block/door/planks_" + color + "/frame_top")
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		topModel.renderNorthFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topTexture
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		topModel.renderSouthFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topTexture
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		topModel.renderWestFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topTexture
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		topModel.renderEastFace(
			Tessellator.instance, topBounds, 0.0F, 0.0F,
			0.0F, topTexture
		);

		AABB  bottomBounds = AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, sideLength);
		IconCoordinate bottomTexture = TextureRegistry.getTexture("minecraft:block/door/planks_" + color + "/bottom");
		BlockModel<?> bottomModel = BlockModelDispatcher
			.getInstance()
			.getDispatch(doorBottom);

		Tessellator.instance.setNormal(0.0F, -1.0F, 0.0F);
		topModel.renderBottomFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomTexture
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		bottomModel.renderNorthFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomTexture
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		bottomModel.renderSouthFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomTexture
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		bottomModel.renderWestFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomTexture
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		bottomModel.renderEastFace(
			Tessellator.instance, bottomBounds, 0.0F, 0.0F,
			0.0F, bottomTexture
		);

		Tessellator.instance.draw();
		GL11.glEnable(GL_BLEND);
	}
}
