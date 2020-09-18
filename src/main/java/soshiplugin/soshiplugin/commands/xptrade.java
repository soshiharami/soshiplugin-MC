package soshiplugin.soshiplugin.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.Bukkit.getPlayer;

public class xptrade implements CommandExecutor, Listener {

    public static boolean is_second = true;
    private static Inventory trade_item_inv_open = null;
    private static Player trade_partner = null;
    private static Player trade_player = null;
    private static int trade_xp = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (args[0].equals("open")) {
            trade_partner.openInventory(trade_item_inv_open);
            trade_partner.giveExp(trade_xp * -1);
            trade_player.giveExp(trade_xp);
            return false;
        }
        is_second = false;
        String cmd_name = cmd.getName();
        Player player = getPlayer(sender.getName());
        trade_player = player;
        trade_partner = getPlayer(args[0]);
        trade_xp = Integer.parseInt(args[1]);
        if (trade_partner.getTotalExperience() < trade_xp) {
            Objects.requireNonNull(player).sendMessage("This player don't have " + args[1] + " xps");
            return false;
        }
        // test command
        if (cmd_name.equalsIgnoreCase("xptrade")) {
            Inventory trade_item_inv = Bukkit.createInventory(null, 9, "trade item inv");
            trade_item_inv_open = trade_item_inv;
            Objects.requireNonNull(player).openInventory(trade_item_inv);
        }
        // not found
        return false;
    }

    @EventHandler
    public void close_inv(InventoryCloseEvent event) {
        if (trade_item_inv_open != event.getInventory() | is_second) return;
        trade_partner.sendMessage(trade_player.getName() + "から" + trade_xp + "のトレードが来ています");
        StringBuilder Item = new StringBuilder();
        for (ItemStack item : trade_item_inv_open.getContents()) {
            if (item == null) continue;
            Item.append(Objects.requireNonNull(item.getItemMeta()).getDisplayName()).append("  × ").append(item.getAmount()).append("\n");
            //APIのバグで名前が出ません
        }
        trade_partner.sendMessage(Item.toString());
        TextComponent message = new TextComponent("Click me");
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/xptrade open 0"));
        is_second = true;
        trade_partner.spigot().sendMessage(message);
    }
}