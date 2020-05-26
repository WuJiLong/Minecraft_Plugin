package wuchilong.mc.plugin.item.itemlist;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.GUI.GUIController;
import wuchilong.mc.plugin.item.CustomItem;

public class ItemIPad extends CustomItem{

	public ItemIPad() {
		super(Material.ITEM_FRAME,(short) 1,"ipad");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.LIGHT_PURPLE +"平板電腦");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "這個世界中少數的電子產品。"),
				(ChatColor.WHITE + "但這好像沒有充電孔和電量顯示。"),
				(ChatColor.MAGIC + "Hello, World!")
		}));
		item.setUnbreakable(true);
		this.setItemMeta(item);
		
		hasSkill=true;
	}
	
	@EventHandler
	public void fly(PlayerInteractEvent e){
		Player player=e.getPlayer();
		ItemStack usingitem=e.getItem();
		try {
			if(usingitem.getItemMeta().equals(this.getItemMeta())){
				e.setCancelled(true);
				GUIController.gui_main.opengui(player);
			}
	    }catch(Exception ex){}
	}
}
