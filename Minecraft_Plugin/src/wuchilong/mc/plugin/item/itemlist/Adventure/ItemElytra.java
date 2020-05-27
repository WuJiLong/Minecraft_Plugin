package wuchilong.mc.plugin.item.itemlist.Adventure;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import wuchilong.mc.plugin.item.CustomItem;

public class ItemElytra extends CustomItem{

	public ItemElytra() {
		super(Material.ELYTRA,(short) 1,"elytra_X");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.LIGHT_PURPLE +"強化鞘翅");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "經過固化劑強化過的鞘翅"),
				(ChatColor.WHITE + "基本上用不壞")
		}));
		item.setUnbreakable(true);
		item.setLocalizedName("adventure."+this.itemname);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("unbreaking"), 9487);//
		
		isRecipe=true;
		//islessRecipe=true;
	}
	
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		recipe[3]= itemList.get("adventure_Hardener");
		recipe[4]= new ItemStack(Material.ELYTRA,(short) 1);
		recipe[5]= itemList.get("adventure_Hardener");
	}
	
	
	
}
