package daylogin.daylogin.menus;

import daylogin.daylogin.DayLogin;
import daylogin.daylogin.api.Createitem;
import daylogin.daylogin.commands;
import daylogin.daylogin.files.data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mainmenu implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Integer r = e.getRawSlot();
        if (e.getView().getTitle().equalsIgnoreCase("§e§lメインメニュー §7(DayLogin)")) {
            e.setCancelled(true);
            if (r == 10) {
                new saveusers().onMenu(p);
            }
            if (r == 11) {
                new saveid().onMenu(p);
            }
            if (r == 12) {
                p.closeInventory();
                new setperm().setPerm(p);
            }
            if (r == 19) {
                new anycmds().onMenu(p);
            }
            if (r == 20) {
                new anymsgs().onMenu(p);
            }
            if (r == 21) {
                new settp().setTeleport(p);
                p.closeInventory();
            }
            if (r == 38 || r == 43) {
                String pass = "" + genPassword(p);
                p.closeInventory();
                p.sendMessage(" ");
                p.sendMessage("§4※本当に全てのデータをリセットしますか？");
                p.sendMessage("§e/dl confirm " + pass + " §fで削除が可能です。");
                p.sendMessage("§b20秒以内§fにコマンドの使用で、削除が可能です。");
                p.sendMessage(" ");
                commands.confirm.put(p, pass);
                BukkitRunnable task = new BukkitRunnable() {
                    int i = 20;

                    public void run() {
                        if (i == 0) {
                            if (commands.confirm.containsKey(p)) {
                                commands.confirm.remove(p);
                                p.sendMessage("§a20秒過ぎました。");
                            }
                            cancel();
                        }
                        i--;
                    }
                };
                task.runTaskTimer(DayLogin.getPlugin(DayLogin.class), 0L, 20L);
            }
            if (r == 14) {
                new setcolor().onMenu(p);
                new data().reloadFile(p);
            }
            if (r == 23) {
                p.closeInventory();
                p.performCommand("daylogin help");
            }
            if (r == 32) {
                p.closeInventory();
                p.sendMessage("§aplugins/DayLogin/config.yml §fにてファイルの変更が可能です！");
            }
            if (r == 16) {
                p.closeInventory();
                new data().saveFile(p);
            }
            if (r == 25) {
                p.closeInventory();
                new data().reloadFile(p);
            }
            if (r == 49) {
                p.closeInventory();
            }
        }
    }

    public void onMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§e§lメインメニュー §7(DayLogin)");
        //  0  1  2  3  4  5  6  7  8
        //  9 10 11 12 13 14 15 16 17
        // 18 19 20 21 22 23 24 25 26
        // 27 28 29 30 31 32 33 34 35
        // 36 37 38 39 40 41 42 43 44
        // 45 46 47 48 49 50 51 52 53
        List<String> sl1 = new ArrayList<>();
        sl1.add(" ");
        sl1.add("§7デフォルトは§fymlファイル§7です");
        sl1.add("§7プラグイン内の場合は/reloadコマンドでリセットされてしまいます");
        sl1.add(" ");
        if (new data().getString("settings.how_save_dates").equalsIgnoreCase("yml-file")) {
            sl1.add("§f現在の設定: §aymlファイル");
        } else {
            sl1.add("§f現在の設定: §aプラグイン内");
        }
        sl1.add(" ");
        sl1.add("§aクリックして変更");
        sl1.add(" ");
        List<String> sl2 = new ArrayList<>();
        sl2.add(" ");
        sl2.add("§7デフォルトは§fUUID§7です");
        sl2.add("§7MCIDの場合、変更の際その日だけバグってしまいます");
        sl2.add(" ");
        if (new data().getString("settings.how_write_dates").equalsIgnoreCase("UUID")) {
            sl2.add("§f現在の設定: §aUUID");
        } else {
            sl2.add("§f現在の設定: §aMCID");
        }
        sl2.add(" ");
        sl2.add("§aクリックして変更");
        sl2.add(" ");
        List<String> sl3 = new ArrayList<>();
        sl3.add(" ");
        sl3.add("§7デフォルトは§fdaylogin.user§7です");
        sl3.add("§7入力として§fop§7と入力することでopに設定できます");
        sl3.add(" ");
        sl3.add("§f現在の設定: §a"+new data().getString("settings.permission"));
        sl3.add(" ");
        sl3.add("§aクリックして設定");
        sl3.add(" ");
        List<String> sl4 = new ArrayList<>();
        sl4.add(" ");
        sl4.add("§f現在のコマンド:");
        if (new data().getStringList("settings.commands").size() != 0) {
            for (String s : new data().getStringList("settings.commands")) {
                sl4.add("§7 - §a"+s);
            }
        } else {
            sl4.add("§7 - §aなし");
        }
        sl4.add(" ");
        sl4.add("§aクリックして追加/削除");
        sl4.add(" ");
        List<String> sl5 = new ArrayList<>();
        sl5.add(" ");
        sl5.add("§f現在のメッセージ: ");
        if (new data().getStringList("settings.messages").size() != 0) {
            for (String s : new data().getStringList("settings.messages")) {
                sl5.add("§7 - §a"+s);
            }
        } else {
            sl5.add("§7 - §aなし");
        }
        sl5.add(" ");
        sl5.add("§aクリックして追加/削除");
        sl5.add(" ");
        List<String> sl6 = new ArrayList<>();
        sl6.add(" ");
        sl6.add("§c※小数点が3位まである場合、切り捨ててあります。");
        if (new data().getString("settings.teleport").equalsIgnoreCase("none")) {
            sl6.add("§f設定座標: §a✖/✖/✖/✖/✖/✖ §7(未設定)");
        } else {
            sl6.add("§f設定座標: §a" + new data().getString("settings.teleport"));
        }
        sl6.add("§f表示: §7world/x/y/z/yaw/pitch");
        sl6.add(" ");
        sl6.add("§aクリックして変更");
        sl6.add(" ");
        List<String> sl7 = new ArrayList<>();
        sl7.add(" ");
        sl7.add("§c§l===== §4§lWARNING §c§l=====");
        sl7.add(" ");
        sl7.add("§4※一度行った場合戻すことはできません。");
        sl7.add(" ");
        sl7.add("§c§l===== §4§lWARNING §c§l=====");
        sl7.add(" ");
        sl7.add("§aクリックで設定をリセット");
        sl7.add(" ");
        List<String> sl8 = new ArrayList<>();
        sl8.add(" ");
        sl8.add("§7デフォルトは§f白色§7です");
        sl8.add("§7個人の設定ですので、ご自由に！");
        sl8.add(" ");
        sl8.add("§fあなたの設定色: §a"+new data().getColor(p));
        sl8.add(" ");
        sl8.add("§aクリックして変更");
        sl8.add(" ");
        List<String> sl9 = new ArrayList<>();
        sl9.add(" ");
        sl9.add("§aクリックして表示");
        sl9.add(" ");
        List<String> sl10 = new ArrayList<>();
        sl10.add(" ");
        sl10.add("§aクリックして変更");
        sl10.add(" ");
        List<String> sl11 = new ArrayList<>();
        sl11.add(" ");
        sl11.add("§aクリックして保存");
        sl11.add(" ");
        List<String> sl12 = new ArrayList<>();
        sl12.add(" ");
        sl12.add("§aクリックしてリロード");
        sl12.add(" ");
        List<String> sl13 = new ArrayList<>();
        sl13.add(" ");
        sl13.add("§c§l===== §4§lWARNING §c§l=====");
        sl13.add(" ");
        sl13.add("§4※一度リセットしてしまうと、再度復元は不可能です");
        sl13.add(" ");
        sl13.add("§c§l===== §4§lWARNING §c§l=====");
        sl13.add(" ");
        sl13.add("§aクリックしてリロード");
        sl13.add(" ");
        //  0  1  2  3  4  5  6  7  8
        //  9 10 11 12 13 14 15 16 17
        // 18 19 20 21 22 23 24 25 26
        // 27 28 29 30 31 32 33 34 35
        // 36 37 38 39 40 41 42 43 44
        // 45 46 47 48 49 50 51 52 53
        inv.setItem(10, new Createitem().createItem(Material.ENDER_CHEST, 1, "&f保存方法 &7(&aプラグイン内 &e/ &aymlファイル&7)", sl1, false));
        inv.setItem(11, new Createitem().createItem(Material.SCUTE, 1, "&f保存方法 &7(&aUUID &e/ &aMCID&7)", sl2, false));
        inv.setItem(12, new Createitem().createItem(Material.GOLD_INGOT, 1, "&f権限設定", sl3, false));
        inv.setItem(19, new Createitem().createItem(Material.COMMAND_BLOCK, 1, "&f発動コマンド", sl4, false));
        inv.setItem(20, new Createitem().createItem(Material.PAPER, 1, "&f送信メッセージ", sl5, false));
        inv.setItem(21, new Createitem().createItem(Material.ENDER_PEARL, 1, "&fテレポート先", sl6, false));

        inv.setItem(38, new Createitem().createItem(Material.RED_STAINED_GLASS_PANE, 1, "&c設定をリセット", sl7, false));

        inv.setItem(14, new Createitem().createItem(Material.BONE_MEAL, 1, "&f色設定", sl8, false));
        inv.setItem(23, new Createitem().createItem(Material.OAK_LOG, 1, "&fヘルプを表示", sl9, false));
        inv.setItem(32, new Createitem().createItem(Material.BOOK, 1, "&fconfigを設定", sl10, false));

        inv.setItem(16, new Createitem().createItem(Material.EMERALD_BLOCK, 1, "&fファイルをセーブ", sl11, false));
        inv.setItem(25, new Createitem().createItem(Material.REDSTONE_BLOCK, 1, "&fファイルをリロード", sl12, false));

        inv.setItem(43, new Createitem().createItem(Material.LAVA_BUCKET, 1, "&f全データをリセット", sl13, false));

        inv.setItem(13, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(15, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(22, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(24, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(28, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(29, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(30, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(31, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(33, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(34, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(37, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(39, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(40, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(41, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(42, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
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
        inv.setItem(49, new Createitem().createItem(Material.BARRIER, 1, "&c閉じる", null, false));
        inv.setItem(50, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(51, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(52, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        inv.setItem(53, new Createitem().createItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ", null, false));
        p.openInventory(inv);
    }


    public StringBuilder genPassword(Player p) {

        //パスワード桁数
        int length = 5;
        //記号使用有無
        boolean useSign = true;
        //アルファベット大文字小文字のスタイル(normal/lowerCase/upperCase)
        String style = "normal";

        //生成処理
        StringBuilder result = new StringBuilder();
        //パスワードに使用する文字を格納
        StringBuilder source = new StringBuilder();
        //数字
        for (int i = 0x30; i < 0x3A; i++) {
            source.append((char) i);
        }
        //記号
        if (useSign) {
            for (int i = 0x21; i < 0x30; i++) {
                source.append((char) i);
            }
        }
        //アルファベット小文字
        switch (style) {
            case "lowerCase":
                break;
            default:
                for (int i = 0x41; i < 0x5b; i++) {
                    source.append((char) i);
                }
                break;
        }
        //アルファベット大文字
        switch (style) {
            case "upperCase":
                break;
            default:
                for (int i = 0x61; i < 0x7b; i++) {
                    source.append((char) i);
                }
                break;
        }

        int sourceLength = source.length();
        Random random = new Random();
        while (result.length() < length) {
            result.append(source.charAt(Math.abs(random.nextInt()) % sourceLength));
        }
        return result;
    }
}