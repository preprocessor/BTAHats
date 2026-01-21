package com.wyspr.hats.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemDoor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = ItemDoor.class, remap = false)
public interface ItemDoorAccessor {
	@Accessor
	Block<?> getDoorBlockTop();

	@Accessor
	Block<?> getDoorBlockBottom();
}
