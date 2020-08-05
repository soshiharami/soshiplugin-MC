package soshiplugin.soshiplugin;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import soshiplugin.soshiplugin.commands.TestCommand;
import soshiplugin.soshiplugin.events.Bed;
import soshiplugin.soshiplugin.events.Login;

public class SoshiPlugin extends JavaPlugin  {

    private TestCommand CommandManager;

    @Override
    public void onEnable() {
        getLogger().info("Plugin activation");
        getServer().getPluginManager().registerEvents(new Bed(), this);
        getServer().getPluginManager().registerEvents(new Login(), this);
        getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin shutdown");
    }


}
