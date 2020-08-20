package soshiplugin.soshiplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

import static org.bukkit.Bukkit.getPlayer;

public class xptrade implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        Player player = getPlayer(sender.getName());
        // test command
        if(cmd_name.equalsIgnoreCase("xptrade")){
            Inventory trade_item_inv = Bukkit.createInventory(null, 9, "trade item inv");
            assert player != null;
            player.openInventory(trade_item_inv);
            player.sendMessage(Objects.requireNonNull(Objects.requireNonNull(trade_item_inv.getItem(0)).getItemMeta()).getDisplayName());
        }
        // not found
        return false;
    }
}
