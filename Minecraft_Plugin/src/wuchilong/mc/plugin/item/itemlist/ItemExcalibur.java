package wuchilong.mc.plugin.item.itemlist;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemExcalibur extends CustomItem implements Listener{

	public ItemExcalibur() {
		super(Material.GOLDEN_SWORD,(short) 1, true);
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.GOLD + "斷鋼聖劍(Excalibur)");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "非常鋒利的劍"),(ChatColor.WHITE + "可以輕鬆切開任何肉體")
		}));
		item.setUnbreakable(true);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("sharpness"), 1000);//16
		this.addUnsafeEnchantment(new EnchantmentWrapper("smite"), 1000);//17
		this.addUnsafeEnchantment(new EnchantmentWrapper("bane_of_arthropods"), 1000);//18
		this.addUnsafeEnchantment(new EnchantmentWrapper("looting"), 5);//21
	}
}
