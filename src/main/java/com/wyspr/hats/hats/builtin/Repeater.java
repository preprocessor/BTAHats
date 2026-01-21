package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class Repeater {
	public static void render() {
		float scale = 0.5625F;
		GL11.glTranslatef(0.275F, -0.5F, -0.275F);
		GL11.glScalef(scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

		GL11.glEnable(GL_BLEND);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		TextureRegistry.blockAtlas.bind();

		BlockModel<?> repeaterModel = BlockModelDispatcher
			.getInstance()
			.getDispatch(Blocks.REPEATER_ACTIVE);

		AABB repeaterBounds = repeaterModel.getBlockBoundsForItemRender();

		Tessellator.instance.startDrawingQuads();
		Tessellator.instance.setNormal(0.0F, -1.0F, 0.0F);
		repeaterModel.renderBottomFace(
			Tessellator.instance, repeaterBounds, 0.0F, 0.0F,
			0.0F, repeaterModel.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0)
		);
		Tessellator.instance.setNormal(0.0F, 1.0F, 0.0F);
		repeaterModel.renderTopFace(
			Tessellator.instance, repeaterBounds, 0.0F, 0.0F,
			0.0F, repeaterModel.getBlockTextureFromSideAndMetadata(Side.TOP, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		repeaterModel.renderNorthFace(
			Tessellator.instance, repeaterBounds, 0.0F, 0.0F,
			0.0F, repeaterModel.getBlockTextureFromSideAndMetadata(Side.NORTH, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		repeaterModel.renderSouthFace(
			Tessellator.instance, repeaterBounds, 0.0F, 0.0F,
			0.0F, repeaterModel.getBlockTextureFromSideAndMetadata(Side.SOUTH, 0)
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		repeaterModel.renderWestFace(
			Tessellator.instance, repeaterBounds, 0.0F, 0.0F,
			0.0F, repeaterModel.getBlockTextureFromSideAndMetadata(Side.WEST, 0)
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		repeaterModel.renderEastFace(
			Tessellator.instance, repeaterBounds, 0.0F, 0.0F,
			0.0F, repeaterModel.getBlockTextureFromSideAndMetadata(Side.EAST, 0)
		);

		BlockModel<?> redstoneTorchModel = BlockModelDispatcher
			.getInstance()
			.getDispatch(Blocks.TORCH_REDSTONE_ACTIVE);

		AABB torchBounds = redstoneTorchModel.getBlockBoundsForItemRender();

		double torchY = -0.1875;
		double z1 = -0.25;
		GL11.glEnable(GL_CULL_FACE);

		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		redstoneTorchModel.renderNorthFace(
			Tessellator.instance,
			torchBounds,
			0.0F,
			torchY,
			z1 + 0.375F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.NORTH, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		redstoneTorchModel.renderSouthFace(
			Tessellator.instance,
			torchBounds,
			0.0F,
			torchY,
			z1 - 0.5F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.SOUTH, 0)
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		redstoneTorchModel.renderWestFace(
			Tessellator.instance,
			torchBounds,
			0.4375F,
			torchY,
			z1 - 0.0625F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.WEST, 0)
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		redstoneTorchModel.renderEastFace(
			Tessellator.instance,
			torchBounds,
			-0.4375F,
			torchY,
			z1 - 0.0625F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.EAST, 0)
		);

		double z2 = 0.375;

		Tessellator.instance.setNormal(0.0F, 0.0F, -1.0F);
		redstoneTorchModel.renderNorthFace(
			Tessellator.instance,
			torchBounds,
			0.0F,
			torchY,
			z2 + 0.375F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.NORTH, 0)
		);
		Tessellator.instance.setNormal(0.0F, 0.0F, 1.0F);
		redstoneTorchModel.renderSouthFace(
			Tessellator.instance,
			torchBounds,
			0.0F,
			torchY,
			z2 - 0.5F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.SOUTH, 0)
		);
		Tessellator.instance.setNormal(-1.0F, 0.0F, 0.0F);
		redstoneTorchModel.renderWestFace(
			Tessellator.instance,
			torchBounds,
			0.4375F,
			torchY,
			z2 - 0.0625F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.WEST, 0)
		);
		Tessellator.instance.setNormal(1.0F, 0.0F, 0.0F);
		redstoneTorchModel.renderEastFace(
			Tessellator.instance,
			torchBounds,
			-0.4375F,
			torchY,
			z2 - 0.0625F,
			redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.EAST, 0)
		);

		IconCoordinate texture = redstoneTorchModel.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);

		double zt1 = 0.1875;
		double d13 = 0.0625F;
		double topMinU = texture.getSubIconU(0.4375F);
		double topMinV = texture.getSubIconV(0.375F);
		double topMaxU = texture.getSubIconU(0.5625F);
		double topMaxV = texture.getSubIconV(0.5F);
		Tessellator.instance.addVertexWithUV( 0.5 - d13, 0.4375, zt1 - d13, topMinU, topMinV);
		Tessellator.instance.addVertexWithUV( 0.5 - d13, 0.4375, zt1 + d13, topMinU, topMaxV);
		Tessellator.instance.addVertexWithUV( 0.5 + d13, 0.4375, zt1 + d13, topMaxU, topMaxV);
		Tessellator.instance.addVertexWithUV( 0.5 + d13, 0.4375, zt1 - d13, topMaxU, topMinV);

		double zt2 = 0.8125;
		Tessellator.instance.addVertexWithUV( 0.5 - d13, 0.4375, zt2 - d13, topMinU, topMinV);
		Tessellator.instance.addVertexWithUV( 0.5 - d13, 0.4375, zt2 + d13, topMinU, topMaxV);
		Tessellator.instance.addVertexWithUV( 0.5 + d13, 0.4375, zt2 + d13, topMaxU, topMaxV);
		Tessellator.instance.addVertexWithUV( 0.5 + d13, 0.4375, zt2 - d13, topMaxU, topMinV);

		GL11.glEnable(GL_CULL_FACE);

		Tessellator.instance.draw();

		GL11.glEnable(GL_BLEND);
	}
}
