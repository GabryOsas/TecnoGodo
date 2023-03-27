package me.tecnogodo.command;

import me.tecnogodo.TecnoGodo;
import me.tecnogodo.utils.Config;
import org.apache.commons.io.FileUtils;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GodoCommand implements CommandExecutor {
    HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    List<String> particleList = TecnoGodo.plugin.getConfig().getStringList("Settings.Effect");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNon puoi eseguire un comando dalla console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            int cooldownTime = Config.COOLDOWN_GODO;
            if (!cooldowns.containsKey(sender.getName())) {
                cooldowns.put(player.getName(), System.currentTimeMillis());
                player.sendTitle(Config.TITLE_GODO, Config.SUBTITLE_GODO, 5, 20, 5);
                for (String particleName : particleList) {
                    Particle particle = Particle.valueOf(particleName);
                    Random random = new Random();
                    for (int i = 0; i < 100; i++) {
                        double x = player.getLocation().getX() + (random.nextDouble() - 0.5);
                        double y = player.getLocation().getY() + (random.nextDouble() - 0.5);
                        double z = player.getLocation().getZ() + (random.nextDouble() - 0.5);
                        player.getWorld().spawnParticle(particle, x, y, z, 0);
                    }
                    player.spawnParticle(particle, player.getLocation().add(0, 1, 0), 100, 1, 1, 1, 0);
                }
            } else {
                long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                if (secondsLeft > 1) {
                    player.sendMessage(Config.WAIT_GODO);
                } else {
                    cooldowns.remove(player.getName());
                    if (!cooldowns.containsKey(sender.getName())) {
                        cooldowns.put(player.getName(), System.currentTimeMillis());
                        player.sendTitle(Config.TITLE_GODO, Config.SUBTITLE_GODO, 5, 20, 5);
                        for (String particleName : particleList) {
                            Particle particle = Particle.valueOf(particleName);
                            Random random = new Random();
                            for (int i = 0; i < 100; i++) {
                                double x = player.getLocation().getX() + (random.nextDouble() - 0.5);
                                double y = player.getLocation().getY() + (random.nextDouble() - 0.5);
                                double z = player.getLocation().getZ() + (random.nextDouble() - 0.5);
                                player.getWorld().spawnParticle(particle, x, y, z, 0);
                            }
                            player.spawnParticle(particle, player.getLocation().add(0, 1, 0), 100, 1, 1, 1, 0);
                        }
                    }
                }
            }
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("godo.reload")) {
                    try {
                        File originalConfig = new File(TecnoGodo.plugin.getDataFolder(), "config.yml");
                        File backupConfig = new File(TecnoGodo.plugin.getDataFolder(), "config_backup.yml");
                        FileUtils.copyFile(originalConfig, backupConfig);
                        FileUtils.copyFile(backupConfig, originalConfig);
                        TecnoGodo.plugin.reloadConfig();
                        player.sendMessage(Config.RELOAD_GODO);
                    } catch (IOException e) {
                        Particle.
                        e.printStackTrace();
                    }
                } else {
                    player.sendMessage(Config.NOPERMS_GODO);
                }
            }
        }
        return true;
    }
}
