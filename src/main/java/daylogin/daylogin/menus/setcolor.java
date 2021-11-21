package daylogin.daylogin.menus;

import daylogin.daylogin.api.Createitem;
import daylogin.daylogin.files.data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.w3c.dom.CDATASection;

import java.io.File;

public class setcolor implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Integer r = e.getRawSlot();
        if (e.getView().getTitle().equalsIgnoreCase("§e§lカラーメニュー §7(DayLogin)")) {
            e.setCancelled(true);
            if (r == 49) {
                new mainmenu().onMenu(p);
            }
            if (r == 10) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "黒色");
            }
            if (r == 11) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "灰色");
            }
            if (r == 12) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "薄灰色");
            }
            if (r == 13) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "白色");
            }
            if (r == 14) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "赤色");
            }
            if (r == 15) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "ピンク色");
            }
            if (r == 16) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "紫色");
            }
            if (r == 19) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "青色");
            }
            if (r == 20) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "明るい青色");
            }
            if (r == 21) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "金色");
            }
            if (r == 22) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "黄色");
            }
            if (r == 23) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "明るい緑色");
            }
            if (r == 24) {
                new mainmenu().onMenu(p);
                new data().setColor(p, "緑色");
            }
        }
    }

    public void onMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§e§lカラーメニュー §7(DayLogin)");
        //  0  1  2  3  4  5  6  7  8
        //  9 10 11 12 13 14 15 16 17
        // 18 19 20 21 22 23 24 25 26
        // 27 28 29 30 31 32 33 34 35
        // 36 37 38 39 40 41 42 43 44
        // 45 46 47 48 49 50 51 52 53
        inv.setItem(10, new Createitem().createItem(Material.BLACK_DYE, 1, "&0黒&f色にする", null, false));
        inv.setItem(11, new Createitem().createItem(Material.GRAY_DYE, 1, "&8灰&f色にする", null, false));
        inv.setItem(12, new Createitem().createItem(Material.LIGHT_GRAY_DYE, 1, "&7薄灰&f色にする", null, false));
        inv.setItem(13, new Createitem().createItem(Material.WHITE_DYE, 1, "&f白&f色にする", null, false));
        inv.setItem(14, new Createitem().createItem(Material.RED_DYE, 1, "&c赤&f色にする", null, false));
        inv.setItem(15, new Createitem().createItem(Material.PINK_DYE, 1, "&dピンク&f色にする", null, false));
        inv.setItem(16, new Createitem().createItem(Material.PURPLE_DYE, 1, "&5紫&f色にする", null, false));
        inv.setItem(19, new Createitem().createItem(Material.BLUE_DYE, 1, "&9青&f色にする", null, false));
        inv.setItem(20, new Createitem().createItem(Material.LIGHT_BLUE_DYE, 1, "&a明るい青&f色にする", null, false));
        inv.setItem(21, new Createitem().createItem(Material.ORANGE_DYE, 1, "&6金&f色にする", null, false));
        inv.setItem(22, new Createitem().createItem(Material.YELLOW_DYE, 1, "&e黄&f色にする", null, false));
        inv.setItem(23, new Createitem().createItem(Material.LIME_DYE, 1, "&a明るい緑&f色にする", null, false));
        inv.setItem(24, new Createitem().createItem(Material.GREEN_DYE, 1, "&2緑&f色にする", null, false));

        inv.setItem(49, new Createitem().createItem(Material.ARROW, 1, "&c前に戻る", null, false));

        inv.setItem(25, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(43, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(38, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(42, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(37, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(0, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(1, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(2, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(3, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(4, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(5, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(6, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(7, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(8, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(9, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(17, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(18, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(26, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(27, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(28, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(29, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(30, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(31, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(32, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(33, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(34, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(35, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(36, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(39, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(40, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(41, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(44, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(45, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(46, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(47, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(48, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(50, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(51, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(52, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(53, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        p.openInventory(inv);
    }
}



















