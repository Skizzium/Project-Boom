package com.skizzium.projectboom;

import com.skizzium.projectboom.init.PB_Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ProjectBoom.MOD_ID)
public class ProjectBoom {
    public static final String MOD_ID = "toomuchtnt";
    private static final Logger LOGGER = LogManager.getLogger();

    public ProjectBoom() {
        PB_Registry.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
