package com.wyspr.hats.mixins;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = EntityRenderer.class, remap = false)
public interface EntityRendererAccessor {
	@Accessor
	EntityRenderDispatcher getRenderDispatcher();
}
