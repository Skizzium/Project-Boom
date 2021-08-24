package com.skizzium.projectboom.data;

import com.skizzium.projectboom.ProjectBoom;
import com.skizzium.projectboom.data.models.PB_BlockStatesProvider;
import com.skizzium.projectboom.data.models.PB_ItemModelsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ProjectBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(new PB_BlockStatesProvider(generator, helper));
        generator.addProvider(new PB_ItemModelsProvider(generator, helper));
    }
}
