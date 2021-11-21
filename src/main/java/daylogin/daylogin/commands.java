package daylogin.daylogin;

import daylogin.daylogin.files.data;
import daylogin.daylogin.menus.mainmenu;
import daylogin.daylogin.menus.setperm;
import daylogin.daylogin.menus.settp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class commands implements CommandExecutor {
    public static HashMap<Player, String> confirm = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)) {
            return true;
        }
        Player p = (Player) s;
        if (cmd.getName().equalsIgnoreCase("daylogin")) {
            if (!p.isOp()) return true;
            if (args.length == 0) {
                p.sendMessage(" ");
                p.sendMessage("§e/dl help §7- §fヘルプが見れます");
                p.sendMessage("§e/dl edit §7- §f設定の変更が可能です");
                p.sendMessage("§e/dl reload §7- §fリロードできます。");
                p.sendMessage(" ");
                p.sendMessage("§e/dl cf show §7- §f設定を一覧で見れます");
                p.sendMessage("§e/dl cf h-s <yml/plugin> §7- §fプラグイン内で保存するか、ymlファイルで保存するか選べます");
                p.sendMessage("§e/dl cf h-w <uuid/mcid> §7- §fuuidでの保存か、mcidでの保存を選べます");
                p.sendMessage("§e/dl cf tp §7- §fテレポート先を設定できます");
                p.sendMessage("§e/dl cf color <プレイや> <色> §7- §fプレイヤーの色を変更できます");
                p.sendMessage("§e/dl cf cmds §7- §f発動コマンドを 追加/削除 できます");
                p.sendMessage("§e/dl cf msgs §7- §f送信内容を 追加/削除 できます");
                p.sendMessage("§e/dl cf perm §7- §f権限を設定します");
                p.sendMessage(" ");
                p.sendMessage("§e/dl api undl§7- §fplaceholderAPIとの連携を削除します");
                p.sendMessage("§e/dl api redl §7- §fplaceholderAPIとの連携を再度ダウンロードします。");
                p.sendMessage("§e/dl api dl §7- §fplaceholderAPI連携のダウンロードをします");
                p.sendMessage("§e/dl api list §7- §fplaceholderAPI連携の使用可能コードを確認します");
                p.sendMessage(" ");
            } else {
                if (args[0].equalsIgnoreCase("confirm")) {
                    if (confirm.containsKey(p)) {
                        if (args.length == 1) {
                            p.sendMessage("§cパスワードを入力してください");
                        } else {
                            if (confirm.get(p).equalsIgnoreCase(args[1])) {
                                p.sendMessage("§a成功しました。");
                                new DayLogin().resetData();
                                new data().reloadFile(p);
                            } else {
                                p.sendMessage("§cパスワードが違います！");
                            }
                        }
                    } else {
                        p.sendMessage("§c使用できません！");
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    new data().reloadFile(p);
                }
                if (args[0].equalsIgnoreCase("edit")) {
                    new mainmenu().onMenu(p);
                }
                if (args[0].equalsIgnoreCase("help")) {
                    p.performCommand("daylogin");
                }
                if (args[0].equalsIgnoreCase("cf")) {
                    if (args.length == 1) {
                        p.sendMessage(" ");
                        p.sendMessage("§e/dl cf show §7- §f設定を一覧で見れます");
                        p.sendMessage("§e/dl cf h-s <yml/plugin> §7- §fプラグイン内で保存するか、ymlファイルで保存するか選べます");
                        p.sendMessage("§e/dl cf h-w <uuid/mcid> §7- §fuuidでの保存か、mcidでの保存を選べます");
                        p.sendMessage("§e/dl cf tp §7- §fテレポート先を設定できます");
                        p.sendMessage("§e/dl cf color <プレイヤー> <色> §7- §fプレイヤーの色を変更できます");
                        p.sendMessage("§e/dl cf cmds §7- §f発動コマンドを 追加/削除 できます");
                        p.sendMessage("§e/dl cf msgs §7- §f送信内容を 追加/削除 できます");
                        p.sendMessage("§e/dl cf perm §7- §f権限を設定します");
                        p.sendMessage(" ");
                    } else {
                        if (args[1].equalsIgnoreCase("show")) {
                            p.sendMessage(" ");
                            p.sendMessage("§f保存方法: §a" + new data().getStringList("settings.how_save_dates"));
                            p.sendMessage("§f記入方法: §a" + new data().getStringList("settings.how_write_dates"));
                            p.sendMessage("§f権限: §a" + new data().getStringList("settings.permission"));
                            p.sendMessage("§fテレポート先: §a" + new data().getStringList("settings.teleport"));
                            p.sendMessage(" ");
                        }
                        if (args[1].equalsIgnoreCase("h-s")) {
                            if (args.length == 2) {
                                p.sendMessage(" ");
                                p.sendMessage("§e/dl cf h-s <yml/plugin> §7- §fプラグイン内で保存するか、ymlファイルで保存するか選べます");
                                p.sendMessage(" ");
                            } else {
                                if (args[2].equalsIgnoreCase("yml")) {
                                    p.sendMessage(" ");
                                    p.sendMessage("§aymlファイル§fに保存方法を設定しました。");
                                    p.sendMessage(" ");
                                    new data().setString("settings.how_save_dates", "yml-file");
                                } else if (args[2].equalsIgnoreCase("plugin")) {
                                    p.sendMessage(" ");
                                    p.sendMessage("§aplugin内§fの保存方法に設定しました。");
                                    p.sendMessage(" ");
                                    new data().setString("settings.how_save_dates", "plugin");
                                } else {
                                    p.sendMessage(" ");
                                    p.sendMessage("§aplugin§fもしくは§ayml§fと入力してください。");
                                    p.sendMessage(" ");
                                }
                            }
                        }
                        if (args[1].equalsIgnoreCase("h-w")) {
                            if (args.length == 2) {
                                p.sendMessage(" ");
                                p.sendMessage("§e/dl cf h-w <uuid/mcid> §7- §fuuidでの保存か、mcidでの保存を選べます");
                                p.sendMessage(" ");
                            } else {
                                if (args[2].equalsIgnoreCase("uuid")) {
                                    p.sendMessage(" ");
                                    p.sendMessage("§aUUID§fに記入方法を設定しました。");
                                    p.sendMessage(" ");
                                    new data().setString("settings.how_write_dates", "UUID");
                                } else if (args[2].equalsIgnoreCase("mcid")) {
                                    p.sendMessage(" ");
                                    p.sendMessage("§aMCID§fの記入方法に設定しました。");
                                    p.sendMessage(" ");
                                    new data().setString("settings.how_write_dates", "MCID");
                                } else {
                                    p.sendMessage(" ");
                                    p.sendMessage("§auuid§fもしくは§amcid§fと入力してください。");
                                    p.sendMessage(" ");
                                }
                            }
                        }
                        if (args[1].equalsIgnoreCase("tp")) {
                            new settp().setTeleport(p);
                        }
                        if (args[1].equalsIgnoreCase("perms")) {
                            new setperm().setPerm(p);
                        }
                    }
                }
                if (args[0].equalsIgnoreCase("api")) {
                    Plugin pl = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
                    if (pl == null || !pl.isEnabled()) {
                        p.sendMessage(" ");
                        p.sendMessage("§aPlaceholderAPIがダウンロードされていません！");
                        p.sendMessage("§fDOWNLOAD URL §7->§e https://www.spigotmc.org/resources/placeholderapi.6245/");
                        p.sendMessage(" ");
                    } else {
                        if (args.length == 1) {
                            p.sendMessage(" ");
                            p.sendMessage("§e/dl api undl§7- §fplaceholderAPIとの連携を削除します");
                            p.sendMessage("§e/dl api redl §7- §fplaceholderAPIとの連携を再度ダウンロードします。");
                            p.sendMessage("§e/dl api dl §7- §fplaceholderAPI連携のダウンロードをします");
                            p.sendMessage("§e/dl api list §7- §fplaceholderAPI連携の使用可能コードを確認します");
                            p.sendMessage(" ");
                        } else {
                            if (args[1].equalsIgnoreCase("dl")) {
                                //連携コマンド
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}