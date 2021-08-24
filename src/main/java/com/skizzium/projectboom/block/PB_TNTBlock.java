package com.skizzium.projectboom.block;

import com.skizzium.projectboom.entity.PB_PrimedTNT;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public class PB_TNTBlock extends TntBlock {
    private EntityType<? extends PB_PrimedTNT> TNTEntity;
    private float explosionLevel;

    public PB_TNTBlock(float level, EntityType<? extends PB_PrimedTNT> TNTType, Properties properties) {
        super(properties);
        this.TNTEntity = TNTType;
        this.explosionLevel = level;
    }

    @Override
    public void catchFire(BlockState state, Level world, BlockPos pos, @Nullable net.minecraft.core.Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos, igniter);
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion explosion) {
        if (!world.isClientSide) {
            PB_PrimedTNT TNT = new PB_PrimedTNT(TNTEntity, this, world, explosionLevel, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, explosion.getSourceMob());

            int fuse = TNT.getFuse();
            TNT.setFuse((short)(world.random.nextInt(fuse / 4) + fuse / 8));

            world.addFreshEntity(TNT);
        }
    }

    private void explode(Level world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (!world.isClientSide) {
            PB_PrimedTNT TNT = new PB_PrimedTNT(TNTEntity, this, world, explosionLevel, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, igniter);

            world.addFreshEntity(TNT);
            world.playSound(null, TNT.getX(), TNT.getY(), TNT.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.gameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }
}
