package me.tecnogodo.listener;

import me.tecnogodo.utils.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinCredits implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (Config.CREDITS_GODO){
            player.sendMessage("§9§lGMDIDEV §7Plugin creato da §e@GabryOsas / @GMDIdevelopment / @FiftyRP");
        }
    }
}
