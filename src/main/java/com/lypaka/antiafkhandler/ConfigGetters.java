package com.lypaka.antiafkhandler;

public class ConfigGetters {

    public static String actionMode;
    public static int kickTimer;
    public static String bypassPermission;

    public static void load() {

        actionMode = AntiAFKHandler.configManager.getConfigNode(0, "Action").getString();
        if (actionMode.contains("movement") || actionMode.contains("both")) {

            if (!com.lypaka.lypakautils.ConfigGetters.tickListenerEnabled) {

                AntiAFKHandler.logger.warn("Detected movement and/or both action mode but the tick listener in LypakaUtils is not enabled! Please enable this configuration node and restart the server!");

            }

        }
        kickTimer = AntiAFKHandler.configManager.getConfigNode(0, "Kick-Timer").getInt();
        bypassPermission = AntiAFKHandler.configManager.getConfigNode(0, "Permission").getString();

    }

}
