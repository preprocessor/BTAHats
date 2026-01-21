package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.player.Player;
import org.lwjgl.opengl.GL11;

public class Fire {
	public static void render(Player player, float partialTick) {
		float headEdge = 0.46875F;
		float teenth   = 0.03125F;
		float scale    = 0.5F;
		GL11.glScalef(scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, 1.5F, headEdge);
		float brightness = player.getBrightness(partialTick);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.5F, 0.5F, teenth);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(teenth - headEdge, 0.5F, 0.5F + headEdge);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.5F, 0.5F, teenth);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(0.9F, 0.9F, 0.9F);
		GL11.glTranslatef(0.55F, 0.5F, teenth);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(30.0F, 0.0F, 0.0F, -1.0F);
		GL11.glTranslatef(-0.425F, 0.5F, 0.25F);
		GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(30.0F, 0.0F, 0.0F, -1.0F);
		GL11.glTranslatef(-0.425F, 0.5F, 0.25F);
		GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(30.0F, 0.0F, 0.0F, -1.0F);
		GL11.glTranslatef(-0.425F, 0.5F, 0.25F);
		GL11.glRotatef(30.0F, 1.0F, 0.0F, 0.0F);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.FIRE.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.FIRE.getDefaultStack(),
				brightness,
				1.0F,
				true
			);
	}
}
