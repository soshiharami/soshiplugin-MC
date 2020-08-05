package soshiplugin.soshiplugin;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class SoshiPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Plugin activation");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin shutdown");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        // test command
        if(cmd_name.equalsIgnoreCase("test")){
            getLogger().info("test command");
            sender.sendMessage("TEST " + "hello " + sender.getName());
        }
        // not found
        return false;
    }

    //quickly bed
    @EventHandler
    public void onBed(PlayerBedEnterEvent event){
        getLogger().info("sleeeeeeeeeeeeeeep");
        Player p = event.getPlayer();
        World w = p.getWorld();
        w.setTime(0);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer(); // Joinしたプレイヤー
        player.sendMessage(ChatColor.GOLD + "よく来たな!このとんでもない成金め!!");
        Location loc = event.getPlayer().getLocation();
        loc.getWorld().playSound(loc, Sound.UI_TOAST_CHALLENGE_COMPLETE,1f,-0.1f);
    }
}
