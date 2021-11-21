package daylogin.daylogin;

import daylogin.daylogin.files.data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getServer;

public class login implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        File a_file = new File("plugins/DayLogin/config.yml");
        if (!a_file.exists()) return;
        File file = new File("plugins/DayLogin/dates.yml");
        Boolean checker = false;
        if (!file.exists()) {
            checker = true;
        }
        if (checker == true) {
            if (new data().getString("settings.teleport").equalsIgnoreCase("none")) return;
            String name = p.getUniqueId() + "";
            if (new data().getString("settings.how_write_dates").equalsIgnoreCase("MCID")) {
                name = p.getName();
            }
            FileConfiguration data = YamlConfiguration.loadConfiguration(file);
            if (file.exists()) {
                if (data.contains(name)) {
                    return;
                }
            }
            String[] parts = new data().getString("settings.teleport").split("/");
            Location loc = new Location(Bukkit.getWorld(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3])
                    , (float) Double.parseDouble(parts[4]), (float) Double.parseDouble(parts[5]));
            p.teleport(loc);
            for (String s : new data().getStringList("settings.messages")) {
                p.sendMessage("" + s.replace("&", "§").replace("%player%", p.getName()));
            }
            for (String s : new data().getStringList("settings.commands")) {
                s = s.replace("%player%", p.getName());
                getServer().dispatchCommand(Bukkit.getConsoleSender(), s);
            }
            data.set(name, "JOINED");
            try {
                data.save(file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}