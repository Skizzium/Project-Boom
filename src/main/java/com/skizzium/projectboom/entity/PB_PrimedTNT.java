package com.skizzium.projectboom.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class PB_PrimedTNT extends PrimedTnt {
    public PB_PrimedTNT(EntityType<PB_PrimedTNT> TNT, Level level) {
        super(TNT, level);
    }

    public PB_PrimedTNT(EntityType<? extends PB_PrimedTNT> TNT, Level world, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(TNT, world);
        this.setPos(x, y, z);
        double random = world.random.nextDouble() * (double)((float)Math.PI * 2F);
        this.setDeltaMovement(-Math.sin(random) * 0.02D, (double)0.2F, -Math.cos(random) * 0.02D);
        this.setFuse(80);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.owner = igniter;
    }
}
