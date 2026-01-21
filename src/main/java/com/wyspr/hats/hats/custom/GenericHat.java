package com.wyspr.hats.hats.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.tessellator.Tessellator;
import org.lwjgl.opengl.GL11;
import org.useless.DragonFly;
import org.useless.dragonfly.models.entity.StaticEntityModel;

public class GenericHat {
	public static void render(String textureId, String modelId, double scale) {
		TextureManager t = Minecraft.getMinecraft().textureManager;
		t.bindTexture(t.loadTexture("/assets/sillylittlehats/models/" + textureId + ".png"));
		StaticEntityModel model = DragonFly.loadEntityModel("geometry.sillylittlehats." + modelId,  0);

		GL11.glTranslatef(0f, -0.5F, 0.0f);
		GL11.glScaled(scale, -scale, scale);

		model.render(Tessellator.instance);
	}
}
