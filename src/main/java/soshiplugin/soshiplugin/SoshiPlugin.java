package soshiplugin.soshiplugin;

import org.bukkit.plugin.java.JavaPlugin;
import soshiplugin.soshiplugin.commands.S_tpCommand;
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
        getCommand("stp").setExecutor(new S_tpCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin shutdown");
    }

}
