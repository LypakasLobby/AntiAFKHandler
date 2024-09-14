package com.lypaka.antiafkhandler.Listeners;

import com.lypaka.antiafkhandler.AntiAFKHandler;
import com.lypaka.antiafkhandler.TimerHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

@Mod.EventBusSubscriber(modid = AntiAFKHandler.MOD_ID)
public class ServerStartedListener {

    @SubscribeEvent
    public static void onServerStarted (FMLServerStartedEvent event) {

        MinecraftForge.EVENT_BUS.register(new ClickListener());
        MinecraftForge.EVENT_BUS.register(new LoginListener());
        MinecraftForge.EVENT_BUS.register(new MovementListener());

        TimerHandler.startTimer();

    }

}
