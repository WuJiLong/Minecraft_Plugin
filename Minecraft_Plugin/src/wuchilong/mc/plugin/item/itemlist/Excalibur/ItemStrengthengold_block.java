package wuchilong.mc.plugin.item.itemlist.Excalibur;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wuchilong.mc.plugin.item.CustomItem;

public class ItemStrengthengold_block extends CustomItem{
	
	public ItemStrengthengold_block() {
		super(Material.GOLD_BLOCK,(short) 1,"strengthengold_block");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.GOLD + "強化金磚");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "製作斷鋼系列神器的材料")
		}));
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("sharpness"), 5);//16
		
		isRecipe=true;
		hasSkill=false;
		isBlock=true;
	}
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		ItemStack I=itemList.get("excalibur_Strengthengold_ingot");
		recipe[0]= I;
		recipe[1]= I;
		recipe[2]= I;
		recipe[3]= I;
		recipe[4]= new ItemStack(Material.IRON_BLOCK,(short) 1);
		recipe[5]= I;
		recipe[6]= I;
		recipe[7]= I;
		recipe[8]= I;
	}
	
	

}