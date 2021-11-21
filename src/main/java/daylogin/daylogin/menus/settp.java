package daylogin.daylogin.menus;

import daylogin.daylogin.files.data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.HashMap;

public class settp implements Listener {
    public static HashMap<Player, String> perm = new HashMap<>();

    public void setTeleport(Player p) {
        p.sendMessage("");
        p.sendMessage("§aチャットにて §fset §aと発言してください");
        p.sendMessage("§a発言された場所がテレポート先として設定されます");
        p.sendMessage("§fcancel§aでキャンセルできます");
        p.sendMessage("");
        perm.put(p, "daylogin.user");
    }

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (perm.containsKey(p)) {
            e.setCancelled(true);
            if (e.getMessage().equalsIgnoreCase("cancel")) {
                perm.remove(p);
                new mainmenu().onMenu(p);
            } else if (e.getMessage().equalsIgnoreCase("set")) {
                perm.remove(p);
                String world = p.getWorld().getName();
                Double x = p.getLocation().getX() * 100;
                Double y = p.getLocation().getY() * 100;
                Double z = p.getLocation().getZ() * 100;
                float yaw = p.getLocation().getYaw() * 100;
                float pitch = p.getLocation().getPitch() * 100;
                x = Math.floor(x);
                y = Math.floor(y);
                z = Math.floor(z);
                yaw = (float) Math.floor(yaw);
                pitch = (float) Math.floor(pitch);
                x = x / 100;
                y = y / 100;
                z = z / 100;
                yaw = yaw / 100;
                pitch = pitch / 100;
                new data().setString("settings.teleport", world + "/" + x + "/" + y + "/" + z + "/" + yaw + "/" + pitch);
                new mainmenu().onMenu(p);
            }
        }
    }
}