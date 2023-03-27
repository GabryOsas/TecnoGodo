package me.tecnogodo.utils;

import me.tecnogodo.TecnoGodo;
import org.bukkit.ChatColor;

public class Config {
    public static int COOLDOWN_GODO =  TecnoGodo.plugin.getConfig().getInt("Settings.Cooldown");
    public static boolean CREDITS_GODO =  TecnoGodo.plugin.getConfig().getBoolean("Settings.Credits");
    public static String PREFIX_GODO = ChatColor.translateAlternateColorCodes('&', TecnoGodo.plugin.getConfig().getString("Settings.Prefix"));
    public static String WAIT_GODO = ChatColor.translateAlternateColorCodes('&', TecnoGodo.plugin.getConfig().getString("Messages.Wait").replace("%prefix%", PREFIX_GODO));
    public static String TITLE_GODO = ChatColor.translateAlternateColorCodes('&', TecnoGodo.plugin.getConfig().getString("Settings.Title").replace("%prefix%", PREFIX_GODO));
    public static String SUBTITLE_GODO = ChatColor.translateAlternateColorCodes('&', TecnoGodo.plugin.getConfig().getString("Settings.Subtitle").replace("%prefix%", PREFIX_GODO));
    public static String RELOAD_GODO = ChatColor.translateAlternateColorCodes('&', TecnoGodo.plugin.getConfig().getString("Messages.Reload").replace("%prefix%", PREFIX_GODO));
    public static String NOPERMS_GODO = ChatColor.translateAlternateColorCodes('&', TecnoGodo.plugin.getConfig().getString("Messages.NoPerms").replace("%prefix%", PREFIX_GODO));
}
