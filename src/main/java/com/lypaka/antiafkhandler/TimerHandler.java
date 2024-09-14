package com.lypaka.antiafkhandler;

import com.lypaka.lypakautils.FancyText;
import com.lypaka.lypakautils.Listeners.JoinListener;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.ModList;

import java.util.*;

public class TimerHandler {

    public static Map<UUID, Boolean> afkMap = new HashMap<>();
    public static Timer kickTimer;

    public static void startTimer() {

        if (kickTimer == null) {

            kickTimer = new Timer();

        }

        long kickInterval = ConfigGetters.kickTimer * 1000L;
        kickTimer.schedule(new TimerTask() {

            @Override
            public void run() {

                afkMap.entrySet().removeIf(e -> {

                    UUID uuid = e.getKey();
                    if (e.getValue()) {

                        ServerPlayerEntity player = JoinListener.playerMap.get(uuid);
                        if (ModList.get().isLoaded("pixelmon")) {

                            if (BattleRegistry.getBattle(player) == null) {

                                player.connection.disconnect(FancyText.getFormattedText("Anti-AFK system activated! You've been kicked for being AFK for too long."));
                                return true;

                            } else {

                                return false;

                            }

                        } else {

                            player.connection.disconnect(FancyText.getFormattedText("Anti-AFK system activated! You've been kicked for being AFK for too long."));
                            return true;

                        }

                    }

                    return false;

                });
                for (Map.Entry<UUID, Boolean> entry : afkMap.entrySet()) {

                    entry.setValue(true);

                }

            }

        }, 0, kickInterval);

    }

}
