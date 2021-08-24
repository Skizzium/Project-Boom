package com.skizzium.projectboom.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.skizzium.projectboom.init.PB_Blocks;
import com.skizzium.projectboom.init.PB_Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PB_LootTablesProvider extends LootTableProvider {
    public PB_LootTablesProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
                Pair.of(PB_BlockLootTables::new, LootContextParamSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTables.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    public static class PB_BlockLootTables extends BlockLoot {
        @Override
        protected void addTables() {
            dropSelf(PB_Blocks.TNT_X5.get());
            dropSelf(PB_Blocks.TNT_X20.get());
            dropSelf(PB_Blocks.TNT_X100.get());
            dropSelf(PB_Blocks.TNT_X500.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return PB_Registry.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}
