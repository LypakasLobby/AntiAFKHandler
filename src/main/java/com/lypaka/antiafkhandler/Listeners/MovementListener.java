package com.lypaka.antiafkhandler.Listeners;

import com.lypaka.antiafkhandler.ConfigGetters;
import com.lypaka.antiafkhandler.TimerHandler;
import com.lypaka.lypakautils.API.PlayerMovementEvent;
import com.lypaka.lypakautils.MiscHandlers.PermissionHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MovementListener {

    @SubscribeEvent
    public void onWalk (PlayerMovementEvent.Land event) {

        if (ConfigGetters.actionMode.contains("movement") || ConfigGetters.actionMode.contains("both")) {

            ServerPlayerEntity player = event.getPlayer();
            if (!TimerHandler.afkMap.containsKey(player.getUUID())) {

                if (!PermissionHandler.hasPermission(player, ConfigGetters.bypassPermission)) {

                    TimerHandler.afkMap.put(player.getUUID(), false);

                }

            } else {

                if (TimerHandler.afkMap.get(player.getUUID())) {

                    TimerHandler.afkMap.put(player.getUUID(), false);

                }

            }

        }

    }

    @SubscribeEvent
    public void onSwim (PlayerMovementEvent.Swim event) {

        if (ConfigGetters.actionMode.contains("movement") || ConfigGetters.actionMode.contains("both")) {

            ServerPlayerEntity player = event.getPlayer();
            if (!TimerHandler.afkMap.containsKey(player.getUUID())) {

                if (!PermissionHandler.hasPermission(player, ConfigGetters.bypassPermission)) {

                    TimerHandler.afkMap.put(player.getUUID(), false);

                }

            } else {

                if (TimerHandler.afkMap.get(player.getUUID())) {

                    TimerHandler.afkMap.put(player.getUUID(), false);

                }

            }

        }

    }

}
