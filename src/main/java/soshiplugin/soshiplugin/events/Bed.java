package soshiplugin.soshiplugin.events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;


public class Bed implements Listener {
    //quickly bed
    @EventHandler
    public void onBed(PlayerBedEnterEvent event) {
        Player p = event.getPlayer();
        World w = p.getWorld();
        w.setTime(0);
    }
}
