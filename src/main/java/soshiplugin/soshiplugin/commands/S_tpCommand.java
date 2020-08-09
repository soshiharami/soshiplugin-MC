package soshiplugin.soshiplugin.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.Bukkit.getPlayer;

public class S_tpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        String cmd_name = cmd.getName();
        // test command
        if(cmd_name.equalsIgnoreCase("stp")){
            //tp先のLocationを取得
            Location tp_location = Objects.requireNonNull(getPlayer(args[0])).getLocation();
            //playerとplayerのinventoryを取得
            Player player = getPlayer(sender.getName());
            Inventory player_Inventory = getItemStacks(player);

            if (isIron_hoe(player_Inventory)){
                remove_Iron_hoe(player_Inventory);
            }else{
                Objects.requireNonNull(player).sendMessage("鉄のクワがないよ");
                return false;
            }
            Objects.requireNonNull(player).teleport(tp_location);
        }
        // not found
        return false;
    }

    //inventoryを取得
    private Inventory getItemStacks(Player player) {
        return Objects.requireNonNull(player).getInventory();
    }

    //鉄のクワがあるかを確認する
    private boolean isIron_hoe(Inventory player_Inventory) {
        return player_Inventory.contains(Objects.requireNonNull(Material.getMaterial("IRON_HOE")));
    }

    //鉄のクワを消費させる
    private static void remove_Iron_hoe(Inventory player_Inventory) {
        ItemStack Iron_Hoe = new ItemStack(Objects.requireNonNull(Material.getMaterial("IRON_HOE")));
        player_Inventory.removeItem(Iron_Hoe);
    }
}

