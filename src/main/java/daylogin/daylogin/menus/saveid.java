package daylogin.daylogin.menus;

import daylogin.daylogin.api.Createitem;
import daylogin.daylogin.files.data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class saveid implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Integer r = e.getRawSlot();
        if (e.getView().getTitle().equalsIgnoreCase("§e§l選択メニュー §7(UUID - MCID)")) {
            e.setCancelled(true);
            if (r == 11) {
                new data().setString("settings.how_write_dates", "UUID");
                new mainmenu().onMenu(p);
            }
            if (r == 15) {
                new data().setString("settings.how_write_dates", "MCID");
                new mainmenu().onMenu(p);
            }
            if (r == 22) {
                new mainmenu().onMenu(p);
            }
        }
    }

    public void onMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "§e§l選択メニュー §7(UUID - MCID)");
        //  0  1  2  3  4  5  6  7  8
        //  9 10 11 12 13 14 15 16 17
        // 18 19 20 21 22 23 24 25 26
        List<String> sl1 = new ArrayList<>();
        sl1.add(" ");
        sl1.add("§aクリックして設定");
        sl1.add(" ");
        List<String> sl2 = new ArrayList<>();
        sl2.add(" ");
        sl2.add("§aクリックして設定");
        sl2.add(" ");
        inv.setItem(11, new Createitem().createItem(Material.ENDER_CHEST, 1, "&fUUID保存にする", sl1, false));
        inv.setItem(15, new Createitem().createItem(Material.SCUTE, 1, "&fMCID保存にする", sl2, false));

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
        inv.setItem(10, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(12, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(13, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(14, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(16, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(17, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(18, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(19, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(20, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(21, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(22, new Createitem().createItem(Material.ARROW, 1, "&c前に戻る", null, false));
        inv.setItem(23, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(24, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(25, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(26, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        p.openInventory(inv);
    }
}