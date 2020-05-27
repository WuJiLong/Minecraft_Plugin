package wuchilong.mc.plugin.item.itemlist.Excalibur;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemGilded_diamond extends CustomItem{
	
	public ItemGilded_diamond() {
		super(Material.GOLD_BLOCK,(short) 1,"gilded_diamond");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.GOLD + "鍍金鑽");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "製作斷鋼系列神器的複合材料")
		}));
		item.setLocalizedName("excalibur."+this.itemname);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("sharpness"), 10);//16
		
		isRecipe=true;
		hasSkill=false;
		isBlock=true;
	}
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		ItemStack I=itemList.get("excalibur_Strengthengold_block");
		recipe[0]= I;
		recipe[1]= I;
		recipe[2]= I;
		recipe[3]= I;
		recipe[4]= new ItemStack(Material.DIAMOND_BLOCK,(short) 1);
		recipe[5]= I;
		recipe[6]= I;
		recipe[7]= I;
		recipe[8]= I;
	}
	

}
