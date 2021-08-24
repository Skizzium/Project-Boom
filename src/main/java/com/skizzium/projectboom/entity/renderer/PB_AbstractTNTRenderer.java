package com.skizzium.projectboom.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.skizzium.projectboom.block.PB_TNTBlock;
import com.skizzium.projectboom.entity.PB_PrimedTNT;
import com.skizzium.projectboom.init.PB_Blocks;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.TntMinecartRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class PB_AbstractTNTRenderer<T extends PB_PrimedTNT> extends EntityRenderer<T> {
    public PB_AbstractTNTRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
    }

    public void render(T entity, float p_116178_, float p_116179_, PoseStack stack, MultiBufferSource buffer, int p_116182_) {
        stack.pushPose();
        stack.translate(0.0D, 0.5D, 0.0D);
        int i = entity.getFuse();
        if ((float)i - p_116179_ + 1.0F < 10.0F) {
            float f = 1.0F - ((float)i - p_116179_ + 1.0F) / 10.0F;
            f = Mth.clamp(f, 0.0F, 1.0F);
            f = f * f;
            f = f * f;
            float f1 = 1.0F + f * 0.3F;
            stack.scale(f1, f1, f1);
        }

        stack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
        stack.translate(-0.5D, -0.5D, 0.5D);
        stack.mulPose(Vector3f.YP.rotationDegrees(90.0F));

        TntMinecartRenderer.renderWhiteSolidBlock(this.getBlock().defaultBlockState(), stack, buffer, p_116182_, i / 5 % 2 == 0);
        stack.popPose();

        super.render(entity, p_116178_, p_116179_, stack, buffer, p_116182_);
    }

    public abstract PB_TNTBlock getBlock();

    public ResourceLocation getTextureLocation(T TNT) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
