package wuchilong.mc.plugin.item.itemlist.Excalibur;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemExcalibur extends CustomItem{

	public ItemExcalibur() {
		super(Material.GOLDEN_SWORD,(short) 1,"excalibur");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.GOLD + "斷鋼聖劍");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "非常鋒利的劍"),(ChatColor.WHITE + "可以輕鬆切開任何肉體")
		}));
		item.setUnbreakable(true);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("sharpness"), 1000);//16
		this.addUnsafeEnchantment(new EnchantmentWrapper("smite"), 1000);//17
		this.addUnsafeEnchantment(new EnchantmentWrapper("bane_of_arthropods"), 1000);//18
		this.addUnsafeEnchantment(new EnchantmentWrapper("looting"), 5);//21
		
		isRecipe=true;
		hasSkill=false;
		isBlock=false;
	}
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		recipe[1]= itemList.get("Gilded_diamond");
		recipe[4]= itemList.get("Gilded_diamond");
		recipe[7]= itemList.get("Gildedgrip");
	}
	/*
	@EventHandler
	public void maketheitem(PlayerInteractEvent e){
		 Player p = e.getPlayer();
		 if(e.getHand()!=null)
		    	if(e.getHand().equals(EquipmentSlot.OFF_HAND)) return;
		 if(p.getInventory().getItemInMainHand()!=null)
		 if(e.getAction() == Action.LEFT_CLICK_BLOCK && p.getInventory().getItemInMainHand().getItemMeta().getLore().equals(this.getItemMeta().getLore())) {
	    	p.sendMessage(ChatColor.RED + "敲敲敲");
	    }
	}*/
}
