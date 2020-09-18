package soshiplugin.soshiplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getLogger;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        String cmd_name = cmd.getName();
        // test command
        if (cmd_name.equalsIgnoreCase("test")) {
            getLogger().info("test command");
            sender.sendMessage("TEST " + "hello " + sender.getName());
        }
        // not found
        return false;
    }
}
