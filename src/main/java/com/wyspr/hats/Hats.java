package com.wyspr.hats;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import java.util.HashMap;
import java.util.Map;

public class Hats implements ClientModInitializer, ClientStartEntrypoint {
	public static final String MOD_ID = "SillyLittleHats";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Map<Integer, ItemStack> HATS_MAP = new HashMap<>();

	@Override
	public void onInitializeClient() {
		LOGGER.info(MOD_ID + " initialized");
	}

	@Override
	public void beforeClientStart() {}

	@Override
	public void afterClientStart() {
		HATS_MAP.put(Items.FOOD_CAKE.id, Blocks.CAKE.getDefaultStack());
		HATS_MAP.put(Items.FOOD_PUMPKIN_PIE.id, Blocks.PUMPKIN_PIE.getDefaultStack());

		new HatSettings();
	}
}
