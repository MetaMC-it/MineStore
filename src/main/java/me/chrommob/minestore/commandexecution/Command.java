package me.chrommob.minestore.commandexecution;

import me.chrommob.minestore.MineStore;
import me.chrommob.minestore.data.Config;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.HashMap;

public class Command {
    public static HashMap<String, ArrayList<String>> runLater;

    public static void online(String command) {
        if (Config.isDebug()) {
            MineStore.instance.getLogger().info("Command.java online " + command);
        }
        Bukkit.getScheduler().runTaskLater(MineStore.instance, () -> {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            Bukkit.getLogger().info("§c[MINESTORE LOG] Comando eseguito: §e" + command + " §a[ONLINE]");
        },100L);
    }

    public static synchronized void offline(String username, String command) {
        Manager.add(username.toLowerCase(), command);
        Bukkit.getLogger().info("§c[MINESTORE LOG] Comando salvato: §e" + command + " §7[OFFLINE]");
    }
}
