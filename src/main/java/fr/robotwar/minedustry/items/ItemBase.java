package fr.robotwar.minedustry.items;

import fr.robotwar.minedustry.MinedustryMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(MinedustryMain.TAB));
    }
}