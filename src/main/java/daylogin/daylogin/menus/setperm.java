package daylogin.daylogin.menus;

import daylogin.daylogin.files.data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.HashMap;

public class setperm implements Listener {
    public static HashMap<Player, String> perm = new HashMap<>();
    public void setPerm(Player p) {
        p.sendMessage("");
        p.sendMessage("§aチャットにて権限を発言してください");
        p.sendMessage("§a間違ってしまった場合は §ccancel §aでキャンセルできます");
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
            } else {
                perm.remove(p);
                new data().setString("settings.permission", e.getMessage());
                new mainmenu().onMenu(p);
            }
        }
    }
}