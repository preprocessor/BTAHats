package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.player.Player;
import org.lwjgl.opengl.GL11;

public class Cobweb {
	public static void render(Player player, float partialTick) {
		float scale = 0.5F;
		GL11.glTranslatef(0.0F, -0.25F, -0.266F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(scale, scale, scale);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Blocks.COBWEB.getDefaultStack())
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Blocks.COBWEB.getDefaultStack(),
				player.getBrightness(partialTick),
				1.0F,
				true
			);
	}
}
