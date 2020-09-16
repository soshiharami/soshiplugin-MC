package soshiplugin.soshiplugin;

import org.bukkit.plugin.java.JavaPlugin;
import soshiplugin.soshiplugin.commands.stpCommand;
import soshiplugin.soshiplugin.commands.TestCommand;
import soshiplugin.soshiplugin.commands.xptrade;
import soshiplugin.soshiplugin.events.Bed;
import soshiplugin.soshiplugin.events.GetExp;
import soshiplugin.soshiplugin.events.Login;

import java.util.Objects;

public class SoshiPlugin extends JavaPlugin  {
    @Override
    public void onEnable() {
        getLogger().info("Plugin activation");
        getServer().getPluginManager().registerEvents(new Bed(), this);
        getServer().getPluginManager().registerEvents(new Login(), this);
        getServer().getPluginManager().registerEvents(new GetExp(), this);
        getServer().getPluginManager().registerEvents(new xptrade(), this);
        Objects.requireNonNull(getCommand("test")).setExecutor(new TestCommand());
        Objects.requireNonNull(getCommand("xptrade")).setExecutor(new xptrade());
        Objects.requireNonNull(getCommand("stp")).setExecutor(new stpCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin shutdown");
    }
}
