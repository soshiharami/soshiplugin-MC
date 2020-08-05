package soshiplugin.soshiplugin.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static org.bukkit.Bukkit.getPlayer;

public class S_tpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        // test command
        if(cmd_name.equalsIgnoreCase("stp")){
            Location tp_location = getPlayer(args[0]).getLocation();
            Player player = getPlayer(sender.getName());
            Inventory player_Inventory =  player.getInventory();
            if (player_Inventory.contains(Material.getMaterial("IRON_HOE"))){
                player_Inventory.remove(Material.getMaterial("IRON_HOE"));
            }else{
                player.sendMessage("鉄のクワがないよ");
                return false;
            }
            player.teleport(tp_location);
        }
        // not found
        return false;
    }
}

