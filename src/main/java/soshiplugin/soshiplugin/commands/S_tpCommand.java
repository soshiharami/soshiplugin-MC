package soshiplugin.soshiplugin.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

import static org.bukkit.Bukkit.getPlayer;

public class S_tpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        // test command
        if(cmd_name.equalsIgnoreCase("stp")){
            Location tp_location = Objects.requireNonNull(getPlayer(args[0])).getLocation();
            Player player = getPlayer(sender.getName());
            Inventory player_Inventory = getItemStacks(player);
            if (isIron_hoe(player_Inventory)){
                remove_Iron_hoe(player_Inventory);
            }else{
                player.sendMessage("鉄のクワがないよ");
                return false;
            }
            player.teleport(tp_location);
        }
        // not found
        return false;
    }

    private Inventory getItemStacks(Player player) {
        return Objects.requireNonNull(player).getInventory();
    }

    private void remove_Iron_hoe(Inventory player_Inventory) {
        player_Inventory.remove(Objects.requireNonNull(Material.getMaterial("IRON_HOE")));
    }

    private boolean isIron_hoe(Inventory player_Inventory) {
        return player_Inventory.contains(Objects.requireNonNull(Material.getMaterial("IRON_HOE")));
    }
}

