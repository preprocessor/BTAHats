package com.wyspr.hats.hats.builtin;

import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class Arrow {
	public static void render(Player player, ItemStack itemstack, float partialTick) {
		float scale = 0.625F;
		float y = 0.5F;
		float x = 0.3F;
		GL11.glScalef(scale, -scale, scale);
		GL11.glTranslatef(x, y, 0.0F);
		GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
		ItemModelDispatcher
			.getInstance().getDispatch(itemstack).renderItemInWorld(Tessellator.instance, player, itemstack, player.getBrightness(partialTick), 1.0F, true);
		GL11.glRotatef(45.0F, 0.0F, 0.0F, -1.0F);
		GL11.glTranslatef(-(2.25F * x), 0.7F, 0);
		GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
		ItemModelDispatcher.getInstance().getDispatch(itemstack).renderItemInWorld(Tessellator.instance, player, itemstack, player.getBrightness(partialTick), 1.0F, true);
	}
}
