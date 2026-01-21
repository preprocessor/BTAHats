package com.wyspr.hats.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.wyspr.hats.HatSettings;
import com.wyspr.hats.hats.builtin.*;
import com.wyspr.hats.hats.custom.*;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.entity.MobRendererPlayer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.model.ModelBiped;
import net.minecraft.core.block.*;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.tool.ItemToolSword;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.wyspr.hats.Hats.HATS_MAP;

@Mixin(value = MobRendererPlayer.class, remap = false)
public abstract class MobRendererPlayerMixin extends MobRenderer<Player> {
	@Unique
	private boolean    result = false;
	@Shadow
	@Final
	private ModelBiped modelArmorChestplate;

	public MobRendererPlayerMixin(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}

	/// Renders custom hat models
	@Inject(
		method = "prepareArmor(Lnet/minecraft/core/entity/player/Player;IF)Z", at = @At("TAIL"),
		cancellable = true
	)
	public void renderCustomArmorHats(
		Player entity,
		int layer,
		float partialTick,
		CallbackInfoReturnable<Boolean> cir
	)
	{
		ItemStack itemStack = entity.inventory.armorItemInSlot(3 - layer);

		if (itemStack != null) {
			if (itemStack.itemID == Items.SADDLE.id) {
				this.bindTexture("/assets/sillylittlehats/textures/armor/saddle_armor.png");
				ModelBiped modelBiped = this.modelArmorChestplate;
				modelBiped.hair.visible = true;
				modelBiped.head.visible = true;
				this.setArmorModel(modelBiped);
				cir.setReturnValue(true);
			}
		}
	}

		@WrapOperation(
		method = "prepareArmor(Lnet/minecraft/core/entity/player/Player;IF)Z",
		at = @At(
			value = "INVOKE",
			ordinal = 0,
			target = "Lnet/minecraft/core/item/IArmorItem;getArmorMaterial()Lnet/minecraft/core/item/material/ArmorMaterial;"
		)
	)
	public ArmorMaterial test(IArmorItem instance, Operation<ArmorMaterial> original) {
		if (this.result) return null;
		return original.call(instance);
	}

	@Inject(
		method = "renderSpecials(Lnet/minecraft/core/entity/player/Player;F)V", at = @At(
		value = "INVOKE", target = "Lnet/minecraft/client/render/model/Cube;translateTo(F)V",
		ordinal = 0,
		shift = At.Shift.AFTER
	)
	)
	public void injectHatRender(
		Player player,
		float partialTick,
		CallbackInfo ci,
		@Local(name = "itemstack") ItemStack itemstack
	)
	{
		this.result = renderHats(this, player, itemstack, partialTick);
	}

	@Unique
	boolean renderHats(
		MobRendererPlayerMixin renderer,
		Player player, ItemStack itemstack, float partialTick
	)
	{

		if (itemstack.hasCustomName()) {
			String itemName = itemstack
				.getCustomName()
				.toLowerCase();


			if (itemName.contains("box")) {
				GenericHat.render("box_hat", "box", 0.0625);
				return true;
			}

			if (itemName.contains("cheese")) {
				GenericHat.render("cheese_hat", "cheese1", 0.0625);
				return true;
			}

			if (itemName.contains("mouse")) {
				GenericHat.render("cheese_hat", "cheese2", 0.0625);
				return true;
			}

			if (itemName.contains("chef")) {
				GenericHat.render("chef_hat", "chefhat", 0.0625);
				return true;
			}

			if (
				itemName.contains("construction")
			 || itemName.contains("builder")
			) {
				GenericHat.render("construction_hat", "constructionhat", 0.0625);
				return true;
			}

			if (
				itemName.contains("magician")
			 || itemName.contains("mage")
			) {
				GenericHat.render("mage_hat", "magehat", 0.0625);
				return true;
			}

			if (
				itemName.contains("sim")
			 || itemName.contains("plumbob")
			) {
				PlumBob.render();
				return true;
			}

			if (
				itemName.contains("pokemon")
  			 || itemName.contains("ash")
			 || itemName.contains("ketchum")
			) {
				GenericHat.render("pokemon_hat1", "pokemonhat1", 0.0625);
				return true;
			}

			if (itemName.contains("top hat")) {
				GenericHat.render("top_hat", "tophat", 0.0625);
				return true;
			}

			if (itemName.contains("witch8")) {
				GenericHat.render("witch_hat8", "witchhat8", 0.0625);
				return true;
			}

			if (itemName.contains("witch7")) {
				GenericHat.render("witch_hat7", "witchhat7", 0.0625);
				return true;
			}

			if (itemName.contains("witch6")) {
				GenericHat.render("witch_hat6", "witchhat6", 0.0625);
				return true;
			}

			if (itemName.contains("witch5")) {
				GenericHat.render("witch_hat5", "witchhat5", 0.0625);
				return true;
			}

			if (itemName.contains("witch4")) {
				GenericHat.render("witch_hat4", "witchhat4", 0.0625);
				return true;
			}

			if (itemName.contains("witch3")) {
				GenericHat.render("witch_hat3", "witchhat3", 0.0625);
				return true;
			}

			if (itemName.contains("witch2")) {
				GenericHat.render("witch_hat2", "witchhat2", 0.0625);
				return true;
			}

			if (
				itemName.contains("witch1")
			 || itemName.contains("witch")
			) {
				GenericHat.render("witch_hat1", "witchhat1", 0.0625);
				return true;
			}

		} else if (HatSettings.renderCakeAndPumpkin.value
			&& (itemstack.itemID == Items.FOOD_CAKE.id
			|| itemstack.itemID == Items.FOOD_PUMPKIN_PIE.id)) {
			ItemStack replacedItem = HATS_MAP.get(itemstack.itemID);
			BlockHat.render(renderer, player, replacedItem);
			return true;

		} else if (HatSettings.renderLayers.value
			&& (itemstack.itemID == Blocks.LAYER_SLATE.id()
			|| itemstack.itemID == Blocks.LAYER_LEAVES_OAK.id()
			|| itemstack.itemID == Blocks.LAYER_SNOW.id())) {
			BlockHat.render(renderer, player, itemstack, 0.0F, -0.625F, 0.0F);
			return true;

		} else if (HatSettings.renderArrows.value
			&& (itemstack.itemID == Items.AMMO_ARROW.id
			|| itemstack.itemID == Items.AMMO_ARROW_GOLD.id
			|| itemstack.itemID == Items.AMMO_ARROW_PURPLE.id
		)) {
			Arrow.render(player, itemstack, partialTick);
			return true;

		} else if (HatSettings.renderOlivine.value
			&& itemstack.itemID == Items.OLIVINE.id) {
			PlumBob.render();
			return true;

		} else if (itemstack.itemID == Blocks.FIRE.id()) {
			Fire.render(player, partialTick);
			return true;

		} else if (HatSettings.renderFlintSteel.value
			&& (itemstack.itemID == Items.TOOL_FIRESTRIKER_IRON.id
			|| itemstack.itemID == Items.TOOL_FIRESTRIKER_STEEL.id)) {
			Fire.render(player, partialTick);
			return true;

		} else if (HatSettings.renderStick.value
			&& itemstack.itemID == Items.STICK.id) {
			Stick.render(player, partialTick);
			return true;

		} else if (HatSettings.renderCobweb.value
			&& itemstack.itemID == Blocks.COBWEB.id()) {
			Cobweb.render(player, partialTick);
			return true;

		} else if (HatSettings.renderRepeater.value
			&& itemstack.itemID == Items.REPEATER.id) {
			Repeater.render();
			return true;

		} else if (HatSettings.renderBasket.value
			&& itemstack.itemID == Items.BASKET.id) {
			Basket.render();
			return true;

		} else if (HatSettings.renderButtons.value
			&& (itemstack.itemID == Blocks.BUTTON_PLANKS.id()
			|| itemstack.itemID == Blocks.BUTTON_PLANKS_PAINTED.id()
			|| itemstack.itemID == Blocks.BUTTON_STONE.id())) {
			BlockHat.render(renderer, player, itemstack, 0.0F, -0.15F, -0.25F, 0.325F);
			return true;

//		} else if (HatSettings.renderJars.value
//			&& (itemstack.itemID == Items.JAR.id
//			|| itemstack.itemID == Items.LANTERN_FIREFLY_RED.id
//			|| itemstack.itemID == Items.LANTERN_FIREFLY_GREEN.id
//			|| itemstack.itemID == Items.LANTERN_FIREFLY_BLUE.id
//			|| itemstack.itemID == Items.LANTERN_FIREFLY_ORANGE.id
//		)) {
//			ItemStack replacedItem = HATS_MAP.get(itemstack.itemID);
//			Jar.render();
//			return true;

		} else if (HatSettings.renderSeat.value
			&& itemstack.itemID == Items.SEAT.id) {
			Seat.render();
			return true;

		} else if (HatSettings.renderSwordUnicorn.value
			&& itemstack.getItem() instanceof ItemToolSword) {
			Sword.render(player, itemstack, partialTick);
			return true;

		} else if (HatSettings.renderDoors.value
			&& itemstack.getItem() instanceof ItemDoor) {
			Block<?> doorBottom = ((ItemDoorAccessor) itemstack.getItem()).getDoorBlockBottom();
			Block<?> doorTop    = ((ItemDoorAccessor) itemstack.getItem()).getDoorBlockTop();
			if (itemstack.getItem() instanceof ItemDoorPainted) {
				PaintedDoor.render(doorBottom, doorTop, itemstack);
			} else {
				Door.render(doorBottom, doorTop);
			}
			return true;

		} else if (itemstack.itemID == Items.SADDLE.id) {
			// Return true for saddle, which is rendered as an armor
			return true;
		} else {
			if (itemstack.itemID < Blocks.blocksList.length) {
				Block<?>   block      = Blocks.blocksList[itemstack.itemID];
				if (block == null) return false;
				BlockLogic blockLogic = block.getLogic();

				if (HatSettings.renderSlabs.value &&
					(blockLogic instanceof BlockLogicSlab
				  || blockLogic instanceof BlockLogicSlabPainted
				  || blockLogic instanceof BlockLogicSlabPaintable)) {
					BlockHat.render(renderer, player, itemstack);
					return true;
				}

				if (HatSettings.renderStairs.value &&
					(blockLogic instanceof BlockLogicStairs
				  || blockLogic instanceof BlockLogicStairsPainted
				  || blockLogic instanceof BlockLogicStairsPaintable)) {
					BlockHat.render(renderer, player, itemstack);
					return true;
				}

				if (HatSettings.renderTrapdoors.value &&
					(blockLogic instanceof BlockLogicTrapDoor
				  || blockLogic instanceof BlockLogicTrapDoorPainted)) {
					BlockHat.render(renderer, player, itemstack, 0.0F, -0.65F, 0.0F);
					return true;
				}
			}
		}
		return false;
	}

	@WrapOperation(
		method = "renderSpecials(Lnet/minecraft/core/entity/player/Player;F)V", at = @At(
		value = "INVOKE", target = "Lnet/minecraft/client/render/block/model/BlockModel;shouldItemRender3d()Z"
	)
	)
	public boolean overrideShouldRender3D(BlockModel<?> instance, Operation<Boolean> original) {
		if (this.result) return false;
		return original.call(instance);
	}

	@WrapOperation(
		method = "renderSpecials(Lnet/minecraft/core/entity/player/Player;F)V", at = @At(
		value = "INVOKE",
		target = "Lnet/minecraft/core/item/ItemStack;getItem()Lnet/minecraft/core/item/Item;"
	)
	)
	public Item overrideGetArmorPiece(ItemStack instance, Operation<Item> original) {
		return result
			? Items.ARMOR_HELMET_LEATHER
			: original.call(instance);
	}

	@Inject(method = "prepareArmor(Lnet/minecraft/core/entity/player/Player;IF)Z", at = @At("TAIL"))
	public void resetResult(
		Player entity,
		int layer,
		float partialTick,
		CallbackInfoReturnable<Boolean> cir
	)
	{
		this.result = false;
	}
}
