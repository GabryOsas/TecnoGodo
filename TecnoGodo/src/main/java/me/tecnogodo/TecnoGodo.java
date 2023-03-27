package me.tecnogodo;

import me.tecnogodo.command.GodoCommand;
import me.tecnogodo.listener.OnJoinCredits;
import me.tecnogodo.utils.TabCompleter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class TecnoGodo extends JavaPlugin {
    public static TecnoGodo plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "╔════╗╔═══╗╔═══╗╔═╗ ╔╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "║╔╗╔╗║║╔══╝║╔═╗║║║╚╗║║║╔═╗║║╔═╗║║╔═╗║╚╗╔╗║║╔═╗║");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "╚╝║║╚╝║╚══╗║║ ╚╝║╔╗╚╝║║║ ║║║║ ╚╝║║ ║║ ║║║║║║ ║║");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  ║║  ║╔══╝║║ ╔╗║║╚╗║║║║ ║║║║╔═╗║║ ║║ ║║║║║║ ║║");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + " ╔╝╚╗ ║╚══╗║╚═╝║║║ ║║║║╚═╝║║╚╩═║║╚═╝║╔╝╚╝║║╚═╝║");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + " ╚══╝ ╚═══╝╚═══╝╚╝ ╚═╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝ By @GabryOsas");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin abilitato con successo!");
        onRegisterCommand();
        onRegisterListener();
        onRegisterTabCompleter();
        saveDefaultConfig();
    }
    public void onRegisterCommand(){
        this.getCommand("godo").setExecutor(new GodoCommand());
    }
    public void onRegisterTabCompleter(){
        this.getCommand("godo").setTabCompleter(new TabCompleter());
    }
    public void onRegisterListener(){
        getServer().getPluginManager().registerEvents(new OnJoinCredits(), this);
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "╔════╗╔═══╗╔═══╗╔═╗ ╔╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "║╔╗╔╗║║╔══╝║╔═╗║║║╚╗║║║╔═╗║║╔═╗║║╔═╗║╚╗╔╗║║╔═╗║");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "╚╝║║╚╝║╚══╗║║ ╚╝║╔╗╚╝║║║ ║║║║ ╚╝║║ ║║ ║║║║║║ ║║");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "  ║║  ║╔══╝║║ ╔╗║║╚╗║║║║ ║║║║╔═╗║║ ║║ ║║║║║║ ║║");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + " ╔╝╚╗ ║╚══╗║╚═╝║║║ ║║║║╚═╝║║╚╩═║║╚═╝║╔╝╚╝║║╚═╝║");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + " ╚══╝ ╚═══╝╚═══╝╚╝ ╚═╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝ By @GabryOsas");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin disabilitato con successo!");
    }
}
