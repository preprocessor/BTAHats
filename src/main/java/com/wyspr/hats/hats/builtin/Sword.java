package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class Sword {
	public static
	void render(Player player, ItemStack itemstack, float partialTick) {
		GL11.glEnable(GL_CULL_FACE);
		float scale = 0.625F;
		GL11.glTranslatef(0.0F, -0.8F, -0.25F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 1.0F);
		GL11.glScalef(scale, scale, scale);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(itemstack)
			.renderItemInWorld(
				Tessellator.instance,
				player,
				itemstack,
				player.getBrightness(partialTick),
				1.0F,
				true
			);
		GL11.glDisable(GL_CULL_FACE);
	}
}
