package com.lypaka.antiafkhandler.Listeners;

import com.lypaka.antiafkhandler.ConfigGetters;
import com.lypaka.antiafkhandler.TimerHandler;
import com.lypaka.lypakautils.MiscHandlers.PermissionHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LoginListener {

    @SubscribeEvent
    public void onJoin (PlayerEvent.PlayerLoggedInEvent event) {

        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        if (!PermissionHandler.hasPermission(player, ConfigGetters.bypassPermission)) {

            TimerHandler.afkMap.put(player.getUUID(), false);

        }

    }

}
