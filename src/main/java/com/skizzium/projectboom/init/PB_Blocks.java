package com.skizzium.projectboom.init;

import com.skizzium.projectboom.block.PB_TNTBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.function.Supplier;

public class PB_Blocks {
    public static final RegistryObject<Block> BASIC_TNT = registerNoItem("basic_tnt", () -> new PB_TNTBlock(PB_Entities.BASIC_TNT, BlockBehaviour.Properties.of(Material.EXPLOSIVE).instabreak().sound(SoundType.GRASS)));

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block){
        return PB_Registry.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, CreativeModeTab group, Rarity rarity, boolean isItemFireResistent){
        RegistryObject<T> object = registerNoItem(name, block);
        if(isItemFireResistent) {
            PB_Registry.ITEMS.register(name, () -> new BlockItem(object.get(), new Item.Properties().tab(group).rarity(rarity).fireResistant()));
        }
        else {
            PB_Registry.ITEMS.register(name, () -> new BlockItem(object.get(), new Item.Properties().tab(group).rarity(rarity)));
        }
        return object;
    }

    public static void register() {}
}
