package soshiplugin.soshiplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Login implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer(); // Joinしたプレイヤー
        player.sendMessage(ChatColor.GOLD + "よく来たな!このとんでもない成金め!!");
        Location loc = event.getPlayer().getLocation();
        loc.getWorld().playSound(loc, Sound.UI_TOAST_CHALLENGE_COMPLETE,1f,-0.1f);
    }
}
