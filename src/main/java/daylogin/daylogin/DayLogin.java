package daylogin.daylogin;

import daylogin.daylogin.files.data;
import daylogin.daylogin.menus.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class DayLogin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveResource("config.yml", false);
        getServer().getPluginManager().registerEvents(new login(), this);
        getServer().getPluginManager().registerEvents(new data(), this);
        getServer().getPluginManager().registerEvents(new anycmds(), this);
        getServer().getPluginManager().registerEvents(new anymsgs(), this);
        getServer().getPluginManager().registerEvents(new mainmenu(), this);
        getServer().getPluginManager().registerEvents(new saveid(), this);
        getServer().getPluginManager().registerEvents(new saveusers(), this);
        getServer().getPluginManager().registerEvents(new setcolor(), this);
        getServer().getPluginManager().registerEvents(new setperm(), this);
        getServer().getPluginManager().registerEvents(new settp(), this);
        getCommand("daylogin").setExecutor(new commands());
        new data().nonp_reloadFile();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void resetData() {
        saveResource("config.yml", false);
    }
}
