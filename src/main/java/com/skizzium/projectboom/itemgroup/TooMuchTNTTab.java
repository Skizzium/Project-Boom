package com.skizzium.projectboom.itemgroup;

import com.skizzium.projectboom.init.PB_Blocks;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TooMuchTNTTab extends CreativeModeTab {
    public TooMuchTNTTab(String label) {
        super(label);
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        PB_Blocks.TNT_X5.get().fillItemCategory(this, items);
        PB_Blocks.TNT_X20.get().fillItemCategory(this, items);
        PB_Blocks.TNT_X100.get().fillItemCategory(this, items);
        PB_Blocks.TNT_X500.get().fillItemCategory(this, items);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(PB_Blocks.TNT_X5.get());
    }
}
