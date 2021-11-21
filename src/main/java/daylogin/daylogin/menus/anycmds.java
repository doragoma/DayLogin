package daylogin.daylogin.menus;

import daylogin.daylogin.api.Createitem;
import daylogin.daylogin.files.data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anycmds implements Listener {
    public static HashMap<Player, String> any = new HashMap<>();

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (any.containsKey(p)) {
            e.setCancelled(true);
            if (e.getMessage().equalsIgnoreCase("cancel")) {
                any.remove(p);
                onMenu(p);
            } else {
                List<String> cmds = new ArrayList<>();
                cmds.add(e.getMessage());
                if (new data().getStringList("settings.commands").size() != 0) {
                    for (String cmd : new data().getStringList("settings.commands")) {
                        cmds.add(cmd);
                    }
                }
                new data().setStringList("settings.commands", cmds);
                onMenu(p);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Integer r = e.getRawSlot();
        if (e.getView().getTitle().equalsIgnoreCase("§e§lコマンドメニュー §7(DayLogin)")) {
            e.setCancelled(true);
            if (r == 37) {
                p.sendMessage(" ");
                p.sendMessage("§fチャットにてコマンドを§b/§fなしで発言してください");
                p.sendMessage("§fキャンセルする場合は§bcancel§fでキャンセルできます");
                p.sendMessage("§a%player% -> MCID §fに自動的に変わります");
                p.sendMessage(" ");
                any.put(p, "");
                p.closeInventory();
            }
            if (r == 43) {
                new data().setStringList("settings.commands", new ArrayList<>());
                p.closeInventory();
                p.sendMessage("全削除が成功しました。");
            }
            if (r == 49) {
                new mainmenu().onMenu(p);
            }
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType() != null) {
                    if (e.getCurrentItem().getType().equals(Material.COMMAND_BLOCK)) {
                        if (r != 40) {
                            List<String> sl = new ArrayList<>();
                            String cmd = null;
                            if (e.getCurrentItem() != null) {
                                if (e.getCurrentItem().hasItemMeta()) {
                                    if (e.getCurrentItem().getItemMeta().hasLore()) {
                                        cmd = e.getCurrentItem().getItemMeta().getLore().get(1);
                                    }
                                }
                            }
                            if (cmd == null) return;
                            cmd = ChatColor.stripColor(cmd);
                            for (String s : new data().getStringList("settings.commands")) {
                                if (!cmd.equalsIgnoreCase("/" + s)) {
                                    sl.add(s);
                                }
                            }
                            new data().setStringList("settings.commands", sl);
                            p.closeInventory();
                            p.sendMessage("§a削除に成功しました！");
                        }
                    }
                }
            }
        }
    }

    public void onMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§e§lコマンドメニュー §7(DayLogin)");
        //  0  1  2  3  4  5  6  7  8
        //  9 10 11 12 13 14 15 16 17
        // 18 19 20 21 22 23 24 25 26
        // 27 28 29 30 31 32 33 34 35
        // 36 37 38 39 40 41 42 43 44
        // 45 46 47 48 49 50 51 52 53

        List<String> sl1 = new ArrayList<>();
        sl1.add(" ");
        sl1.add("§aコマンド一覧: §r");

        if (new data().getStringList("settings.commands").size() != 0) {
            Integer n = 1;
            Integer row = 10;
            for (String cmd : new data().getStringList("settings.commands")) {
                sl1.add("§f" + n + ". §a/" + cmd);
                List<String> sl = new ArrayList<>();
                sl.add("§f");
                sl.add("§f/" + cmd);
                sl.add("§f");
                sl.add("§b右クリック§aで§c削除");
                sl.add("§f");
                inv.setItem(row, new Createitem().createItem(Material.COMMAND_BLOCK, 1, "§fNo." + n + " §fコマンド", sl, false));
                n++;
                row++;
            }
            sl1.add(" ");
        } else {
            sl1.add("§cなし");
            sl1.add(" ");
        }
        inv.setItem(40, new Createitem().createItem(Material.COMMAND_BLOCK, 1, "§aコマンド一覧", sl1, false));

        inv.setItem(37, new Createitem().createItem(Material.GREEN_DYE, 1, "§a新規追加", null, false));
        inv.setItem(43, new Createitem().createItem(Material.RED_DYE, 1, "§4全部削除", null, false));

        inv.setItem(38, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(42, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(28, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(29, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(30, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(31, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(32, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(33, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(34, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(39, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(41, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));

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
        inv.setItem(35, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(36, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(44, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(45, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(46, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(47, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(48, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(49, new Createitem().createItem(Material.ARROW, 1, "&c戻る", null, false));
        inv.setItem(50, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(51, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(52, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(53, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        p.openInventory(inv);
    }
}