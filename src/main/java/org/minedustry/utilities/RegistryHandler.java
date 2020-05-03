package org.minedustry.utilities;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.blocks.BlockBase;
import org.minedustry.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, References.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, References.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, References.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //List of mod items
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", ItemBase::new);
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", ItemBase::new);
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", ItemBase::new);

    //List of mod blocks
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", BlockBase::new);
    public static final RegistryObject<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("platinum_block", () -> new BlockItem(PLATINUM_BLOCK.get(), new Item.Properties().group(MinedustryMain.TAB)));
    public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block", BlockBase::new);
    public static final RegistryObject<Item> COBALT_BLOCK_ITEM = ITEMS.register("cobalt_block", () -> new BlockItem(COBALT_BLOCK.get(), new Item.Properties().group(MinedustryMain.TAB)));
    public static final RegistryObject<Block> THORIUM_BLOCK = BLOCKS.register("thorium_block", BlockBase::new);
    public static final RegistryObject<Item> THORIUM_BLOCK_ITEM = ITEMS.register("thorium_block", () -> new BlockItem(THORIUM_BLOCK.get(), new Item.Properties().group(MinedustryMain.TAB)));
}