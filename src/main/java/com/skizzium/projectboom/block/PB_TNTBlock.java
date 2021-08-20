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
    private static EntityType<? extends PB_PrimedTNT> TNTType;

    public PB_TNTBlock(EntityType<? extends PB_PrimedTNT> TNT, Properties properties) {
        super(properties);
        TNTType = TNT;
    }

    @Override
    public void catchFire(BlockState state, Level world, BlockPos pos, @Nullable net.minecraft.core.Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos, igniter);
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion explosion) {
        if (!world.isClientSide) {
            PB_PrimedTNT tnt = new PB_PrimedTNT(TNTType, world, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, explosion.getSourceMob());

            int fuse = tnt.getFuse();
            tnt.setFuse((short)(world.random.nextInt(fuse / 4) + fuse / 8));

            world.addFreshEntity(tnt);
        }
    }

    private static void explode(Level world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (!world.isClientSide) {
            PB_PrimedTNT tnt = new PB_PrimedTNT(TNTType, world, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, igniter);

            world.addFreshEntity(tnt);
            world.playSound(null, tnt.getX(), tnt.getY(), tnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.gameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }
}
