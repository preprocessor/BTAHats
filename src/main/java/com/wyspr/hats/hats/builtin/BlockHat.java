package com.wyspr.hats.hats.builtin;

import com.wyspr.hats.mixins.EntityRendererAccessor;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class BlockHat {
	public static void render(MobRenderer<Player> renderer, Player player, ItemStack itemstack, float x, float y, float z) {
		render(renderer, player, itemstack, x, y, z, 0.625F);
	}

	public static void render(MobRenderer<Player> renderer, Player player, ItemStack itemstack) {
		render(renderer, player, itemstack, 0.0F, -0.8F, 0.0F);
	}

	public static void render(MobRenderer<Player> renderer, Player player, ItemStack itemstack, float x, float y, float z, float scale) {
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(scale, -scale, scale);
		ItemModelDispatcher
			.getInstance()
			.getDispatch(itemstack)
			.renderItem(Tessellator.instance, ((EntityRendererAccessor)renderer).getRenderDispatcher().itemRenderer, player, itemstack);
	}
}
