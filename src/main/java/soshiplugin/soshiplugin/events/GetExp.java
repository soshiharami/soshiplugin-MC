package soshiplugin.soshiplugin.events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;



public class GetExp implements Listener {

    @EventHandler
    public void Break_Block(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (event.isDropItems()) { //アイテムをドロップしたら
            player.giveExp(1);
        }
    }

}
