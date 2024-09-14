package com.lypaka.antiafkhandler.Commands;

import com.lypaka.antiafkhandler.AntiAFKHandler;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = AntiAFKHandler.MOD_ID)
public class AntiAFKHandlerCommand {

    public static final List<String> ALIASES = Arrays.asList("antiafk", "antiafkhandler", "aah");

    @SubscribeEvent
    public static void onCommandRegistration (RegisterCommandsEvent event) {

        new ReloadCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

    }

}
