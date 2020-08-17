package soshiplugin.soshiplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class xptrade implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        // test command
        if(cmd_name.equalsIgnoreCase("xptrade")){
        }
        // not found
        return false;
    }
}
