package com.skizzium.projectboom.entity;

import com.skizzium.projectboom.block.PB_TNTBlock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class PB_PrimedTNT extends PrimedTnt {
    private PB_TNTBlock TNTBlock;
    private float explosionLevel;

    public PB_PrimedTNT(EntityType<PB_PrimedTNT> entity, Level level) {
        super(entity, level);
    }

    public PB_PrimedTNT(EntityType<? extends PB_PrimedTNT> entity, PB_TNTBlock block, Level world, float level, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(entity, world);
        this.setPos(x, y, z);
        double random = world.random.nextDouble() * (double)((float)Math.PI * 2F);
        this.setDeltaMovement(-Math.sin(random) * 0.02D, 0.2F, -Math.cos(random) * 0.02D);

        this.explosionLevel = level;
        this.setFuse(80);

        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.owner = igniter;

        this.TNTBlock = block;
    }

    public PB_TNTBlock getTNTBlock() {
        return TNTBlock;
    }

    @Override
    protected void explode() {
        this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), explosionLevel, Explosion.BlockInteraction.BREAK);
    }
}
