package wuchilong.mc.plugin.item.itemlist.Excalibur;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemGildedgrip extends CustomItem{
	
	public ItemGildedgrip() {
		super(Material.BLAZE_ROD,(short) 1,"gildedgrip");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.GOLD + "神器握把");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "製作斷鋼系列神器的握把材料")
		}));
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("sharpness"), 5);//16
		
		isRecipe=true;
		hasSkill=false;
		isBlock=false;
	}
	
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		ItemStack I=itemList.get("Strengthengold_block");
		recipe[0]= I;
		recipe[1]= I;
		recipe[2]= I;
		recipe[3]= I;
		recipe[4]= new ItemStack(Material.BLAZE_ROD,(short) 1);
		recipe[5]= I;
		recipe[6]= I;
		recipe[7]= new ItemStack(Material.NETHER_STAR,(short) 1);
		recipe[8]= I;
	}
	

}
