package soshiplugin.soshiplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SoshiPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin activation");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin shutdown");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        // test command
        String cmd_name = cmd.getName();
        if(cmd_name.equalsIgnoreCase("test")){
            getLogger().info("test command");
            sender.sendMessage("TEST " + "hello " + sender.getName());
        }
        // not found
        return false;
    }

}
