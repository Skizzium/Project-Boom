package com.skizzium.projectboom.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.skizzium.projectboom.init.PB_Blocks;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.TntMinecartRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PB_TNTRenderer extends EntityRenderer<PrimedTnt> {
    public PB_TNTRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
    }

    public void render(PrimedTnt tnt, float p_116178_, float p_116179_, PoseStack stack, MultiBufferSource buffer, int p_116182_) {
        stack.pushPose();
        stack.translate(0.0D, 0.5D, 0.0D);
        int i = tnt.getFuse();
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
        TntMinecartRenderer.renderWhiteSolidBlock(PB_Blocks.BASIC_TNT.get().defaultBlockState(), stack, buffer, p_116182_, i / 5 % 2 == 0);
        stack.popPose();
        super.render(tnt, p_116178_, p_116179_, stack, buffer, p_116182_);
    }

    public ResourceLocation getTextureLocation(PrimedTnt TNT) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
