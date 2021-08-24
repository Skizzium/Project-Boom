package com.skizzium.projectboom.entity.renderer;

import com.skizzium.projectboom.block.PB_TNTBlock;
import com.skizzium.projectboom.entity.PB_PrimedTNT;
import com.skizzium.projectboom.init.PB_Blocks;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TNTx100Renderer extends PB_AbstractTNTRenderer<PB_PrimedTNT> {
    public TNTx100Renderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public PB_TNTBlock getBlock() {
        return PB_Blocks.TNT_X100.get();
    }
}
