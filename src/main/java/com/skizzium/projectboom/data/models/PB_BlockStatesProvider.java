package com.skizzium.projectboom.data.models;

import com.skizzium.projectboom.ProjectBoom;
import com.skizzium.projectboom.init.PB_Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PB_BlockStatesProvider extends BlockStateProvider {
    public PB_BlockStatesProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, ProjectBoom.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        sideBottomTopBlock(PB_Blocks.BASIC_TNT.get());
        sideBottomTopBlock(PB_Blocks.TNT_X5.get());
        sideBottomTopBlock(PB_Blocks.TNT_X20.get());
        sideBottomTopBlock(PB_Blocks.TNT_X100.get());
        sideBottomTopBlock(PB_Blocks.TNT_X500.get());
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    private ResourceLocation extend(ResourceLocation location, String suffix) {
        return new ResourceLocation(location.getNamespace(), location.getPath() + suffix);
    }

    public void sideBottomTopBlock(Block block) {
        simpleBlock(block, models().cubeBottomTop(name(block), extend(blockTexture(block), "_side"), extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top")));
    }
}
