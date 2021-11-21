package daylogin.daylogin.api;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Createitem {
    public ItemStack createItem(Material Type, Integer Amount, String DisplayName, List<String> Lore, Boolean Glow) {
        ItemStack is = null;
        is = new ItemStack(Type, Amount);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(DisplayName.replace("&", "§"));
        if (Lore != null) {
            List<String> sl = new ArrayList<>();
            for (String s : Lore) {
                sl.add(s.replace("&", "§"));
            }
            im.setLore(Lore);
        }
        if (Glow == true) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        im.addItemFlags(ItemFlag.HIDE_DESTROYS);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is.setItemMeta(im);
        return is;
    }
}
