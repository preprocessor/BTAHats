package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Items;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class Stick {
	public static void render(Player player, float partialTick) {
		GL11.glEnable(GL_CULL_FACE);
		float scale = 0.625F;
		GL11.glTranslatef(-0.027F, -0.15F, -0.45F);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(scale, scale, scale);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(Items.STICK)
			.renderItemInWorld(
				Tessellator.instance,
				player,
				Items.STICK.getDefaultStack(),
				player.getBrightness(partialTick),
				1.0F,
				true
			);
		GL11.glDisable(GL_CULL_FACE);
	}
}
