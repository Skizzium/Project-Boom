package com.skizzium.projectboom.init;

import com.skizzium.projectboom.entity.PB_PrimedTNT;
import com.skizzium.projectboom.entity.renderer.PB_TNTRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

import static com.skizzium.projectboom.ProjectBoom.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PB_Entities {
    public static final EntityType<PB_PrimedTNT> BASIC_TNT = register("basic_tnt", EntityType.Builder.<PB_PrimedTNT>of(PB_PrimedTNT::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10));

    private static final EntityType register(String name, EntityType.Builder builder) {
        ResourceLocation location = new ResourceLocation(MOD_ID, name);
        return (EntityType) builder.build(name).setRegistryName(location);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PB_Entities.BASIC_TNT, PB_TNTRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        try {
            for (Field field : PB_Entities.class.getDeclaredFields()) {
                Object object = field.get(null);
                if (object instanceof EntityType) {
                    event.getRegistry().register((EntityType) object);
                }
                else if (object instanceof EntityType[]) {
                    for (EntityType type : (EntityType[]) object) {
                        event.getRegistry().register(type);
                    }
                }
            }
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void register() {}
}
