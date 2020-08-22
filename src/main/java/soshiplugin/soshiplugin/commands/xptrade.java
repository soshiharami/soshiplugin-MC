package soshiplugin.soshiplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

import static org.bukkit.Bukkit.getPlayer;

public class xptrade implements CommandExecutor, Listener {

    public static Inventory trade_item_inv_open = null;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        Player player = getPlayer(sender.getName());
        // test command
        if(cmd_name.equalsIgnoreCase("xptrade")){
            Inventory trade_item_inv = Bukkit.createInventory(null, 9, "trade item inv");
            trade_item_inv_open = trade_item_inv;
            assert player != null;
            player.openInventory(trade_item_inv);
        }
        // not found
        return false;
    }

    @EventHandler
    public void close_inv(InventoryCloseEvent event){
        if(trade_item_inv_open != event.getInventory()) return;
        String item = Objects.requireNonNull(event.getInventory().getItem(0)).toString();
        event.getPlayer().sendMessage(item);
    }

    public static void sendClickText(Player p,String text,String command){
        ClickEvent clickEvent = null;
        if(command != null){
            clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND,command);
        }
        BaseComponent[] message = new ComponentBuilder(text).event(clickEvent). create();
        p.spigot().sendMessage(message);
    }
}