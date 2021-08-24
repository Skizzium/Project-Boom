package com.skizzium.projectboom.entity.renderer;

import com.skizzium.projectboom.block.PB_TNTBlock;
import com.skizzium.projectboom.entity.PB_PrimedTNT;
import com.skizzium.projectboom.init.PB_Blocks;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.item.PrimedTnt;

public class BasicTNTRenderer extends PB_AbstractTNTRenderer<PB_PrimedTNT> {
    public BasicTNTRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public PB_TNTBlock getBlock() {
        return PB_Blocks.BASIC_TNT.get();
    }
}
