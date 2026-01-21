package com.wyspr.hats;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.options.components.BooleanOptionComponent;
import net.minecraft.client.gui.options.components.OptionsCategory;
import net.minecraft.client.gui.options.data.OptionsPage;
import net.minecraft.client.gui.options.data.OptionsPages;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.OptionBoolean;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;

public class HatSettings {
	private static final Minecraft    minecraft    = Minecraft.getMinecraft();
	private static final GameSettings gameSettings = minecraft.gameSettings;

	public static OptionBoolean renderSaddle         = new OptionBoolean(gameSettings, "hats.renderSaddle", true);
	public static OptionBoolean renderLayers         = new OptionBoolean(gameSettings, "hats.renderLayers", true);
	public static OptionBoolean renderPressurePlates = new OptionBoolean(gameSettings, "hats.renderPressurePlates", true);
	public static OptionBoolean renderSlabs          = new OptionBoolean(gameSettings, "hats.renderSlabs", true);
	public static OptionBoolean renderStairs         = new OptionBoolean(gameSettings, "hats.renderStairs", true);
	public static OptionBoolean renderSeat           = new OptionBoolean(gameSettings, "hats.renderSeat", true);
	public static OptionBoolean renderBasket         = new OptionBoolean(gameSettings, "hats.renderBasket", true);
	public static OptionBoolean renderCakeAndPumpkin = new OptionBoolean(gameSettings, "hats.renderCakeAndPumpkin", true);
	public static OptionBoolean renderButtons        = new OptionBoolean(gameSettings, "hats.renderButtons", true);
	public static OptionBoolean renderSwordUnicorn   = new OptionBoolean(gameSettings, "hats.renderSwordUnicorn", true);
	public static OptionBoolean renderStick			 = new OptionBoolean(gameSettings, "hats.renderStick", true);
	public static OptionBoolean renderCobweb 		 = new OptionBoolean(gameSettings, "hats.renderCobweb", true);
	public static OptionBoolean renderRepeater 		 = new OptionBoolean(gameSettings, "hats.renderRepeater", true);
	public static OptionBoolean renderArrows         = new OptionBoolean(gameSettings, "hats.renderArrow", true);
	public static OptionBoolean renderFire			 = new OptionBoolean(gameSettings, "hats.renderFire", true);
	public static OptionBoolean renderFlintSteel	 = new OptionBoolean(gameSettings, "hats.renderFlintSteel", true);
	public static OptionBoolean renderTrapdoors      = new OptionBoolean(gameSettings, "hats.renderTrapdoors", true);
	public static OptionBoolean renderDoors  	     = new OptionBoolean(gameSettings, "hats.renderDoors", true);
	public static OptionBoolean renderOlivine		 = new OptionBoolean(gameSettings, "hats.renderOlivine", true);
	public static OptionBoolean renderJars			 = new OptionBoolean(gameSettings, "hats.renderJars", true);

	public HatSettings() {
		OptionsPages.register(
			new OptionsPage("gui.hats.options.page.title", new ItemStack(Items.FOOD_CAKE))
				.withComponent(new OptionsCategory("gui.hats.options.category.title")
					.withComponent(new BooleanOptionComponent(renderSaddle))
					.withComponent(new BooleanOptionComponent(renderLayers))
					.withComponent(new BooleanOptionComponent(renderPressurePlates))
					.withComponent(new BooleanOptionComponent(renderSlabs))
					.withComponent(new BooleanOptionComponent(renderStairs))
					.withComponent(new BooleanOptionComponent(renderSeat))
					.withComponent(new BooleanOptionComponent(renderBasket))
					.withComponent(new BooleanOptionComponent(renderCakeAndPumpkin))
					.withComponent(new BooleanOptionComponent(renderButtons))
					.withComponent(new BooleanOptionComponent(renderSwordUnicorn))
					.withComponent(new BooleanOptionComponent(renderStick))
					.withComponent(new BooleanOptionComponent(renderCobweb))
					.withComponent(new BooleanOptionComponent(renderRepeater))
					.withComponent(new BooleanOptionComponent(renderArrows))
					.withComponent(new BooleanOptionComponent(renderFire))
					.withComponent(new BooleanOptionComponent(renderFlintSteel))
					.withComponent(new BooleanOptionComponent(renderTrapdoors))
					.withComponent(new BooleanOptionComponent(renderDoors))
					.withComponent(new BooleanOptionComponent(renderOlivine))
//					.withComponent(new BooleanOptionComponent(renderJars))
				)
		);
	}
}
