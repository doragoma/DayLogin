package daylogin.daylogin.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class data implements Listener {
    public void setString(String s1, String s2) {
        File file = new File("plugins/DayLogin/config.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        data.set(s1,s2);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStringList(String s1, List<String> s2) {
        File file = new File("plugins/DayLogin/config.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        data.set(s1,s2);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(String s) {
        File file = new File("plugins/DayLogin/config.yml");
        if (!file.exists()) {
            return "エラー";
        }
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        if (data.getString(s) == null) {
            return "エラー";
        }
        return data.getString(s);
    }

    public List<String> getStringList(String s) {
        File file = new File("plugins/DayLogin/config.yml");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        return data.getStringList(s);
    }

    public String getColor(Player p) {
        File file = new File("plugins/DayLogin/players.yml");
        if (!file.exists()) {
            return "白色";
        }
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        if (!data.contains("players." + p.getUniqueId())) {
            return "白色";
        }
        return data.getString("players." + p.getUniqueId());
    }

    public void setColor(Player p, String s) {
        File file = new File("plugins/DayLogin/players.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        data.set("players."+p.getUniqueId(), s);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            data.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(Player p) {
        File file = new File("plugins/DayLogin/config.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        try {
            data.save(file);
            p.sendMessage("保存に成功しました！");
        } catch (IOException e) {
            e.printStackTrace();
            p.sendMessage("保存に失敗しました！ (エラー: #0001)");
        }
    }

    public void reloadFile(Player p) {
        File file = new File("plugins/DayLogin/config.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        try {
            data.load(file);
            p.sendMessage("リロードに成功しました！");
        } catch (IOException e) {
            e.printStackTrace();
            p.sendMessage("リロードに失敗しました！ (エラー: #0002)");
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
            p.sendMessage("リロードに失敗しました！ (エラー: #0003)");
        }
    }

    public void nonp_reloadFile() {
        File file = new File("plugins/DayLogin/config.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        try {
            data.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}