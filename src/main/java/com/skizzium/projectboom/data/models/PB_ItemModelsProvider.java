package com.skizzium.projectboom.data.models;

import com.skizzium.projectboom.ProjectBoom;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PB_ItemModelsProvider extends ItemModelProvider {
    public PB_ItemModelsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, ProjectBoom.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("basic_tnt", modLoc("block/basic_tnt"));
        withExistingParent("tnt_x5", modLoc("block/tnt_x5"));
        withExistingParent("tnt_x20", modLoc("block/tnt_x20"));
        withExistingParent("tnt_x100", modLoc("block/tnt_x100"));
        withExistingParent("tnt_x500", modLoc("block/tnt_x500"));
    }
}
