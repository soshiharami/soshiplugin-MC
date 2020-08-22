package soshiplugin.soshiplugin.commands;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
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

    private static Inventory trade_item_inv_open = null;
    private static Player trade_partner = null;
    private static Player trade_player = null;
    private static float trade_xp = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if (args[0].equals("open")){
            trade_partner.openInventory(trade_item_inv_open);
        }
        String cmd_name = cmd.getName();
        Player player = getPlayer(sender.getName());
        trade_player = player;
        trade_partner = getPlayer(args[0]);
        trade_xp = Float.parseFloat(args[1]);
        if (trade_partner.getExp() <= trade_xp){
            assert player != null;
            player.sendMessage("This player don't have " + args[1] + " xps");
            return false;
        }
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