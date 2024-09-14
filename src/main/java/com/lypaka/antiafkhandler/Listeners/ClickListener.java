package com.lypaka.antiafkhandler.Listeners;

import com.lypaka.antiafkhandler.ConfigGetters;
import com.lypaka.antiafkhandler.TimerHandler;
import com.lypaka.lypakautils.MiscHandlers.PermissionHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

public class ClickListener {

    @SubscribeEvent
    public void onClick (PlayerInteractEvent event) {

        if (event.getSide() == LogicalSide.CLIENT) return;
        if (event.getHand() == Hand.OFF_HAND) return;

        if (ConfigGetters.actionMode.contains("click") || ConfigGetters.actionMode.contains("both")) {

            ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
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
