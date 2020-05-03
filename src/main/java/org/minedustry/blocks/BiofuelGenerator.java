package org.minedustry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BiofuelGenerator extends Block {
    public BiofuelGenerator() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(14)
        );
    }
}
