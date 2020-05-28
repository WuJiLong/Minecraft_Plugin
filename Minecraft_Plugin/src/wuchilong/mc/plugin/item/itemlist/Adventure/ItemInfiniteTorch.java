package wuchilong.mc.plugin.item.itemlist.Adventure;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemInfiniteTorch extends CustomItem{

	public ItemInfiniteTorch() {
		super(Material.TORCH,(short) 1,"infinitetorch");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.LIGHT_PURPLE +"充滿希望的聖火");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "源源不斷的光源"),
				(ChatColor.WHITE + "可以使世界充滿光明")
		}));
		//item.setUnbreakable(true);
		item.setLocalizedName("adventure."+this.itemname);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("infinity"), 10);//51
		hasSkill=true;
	}
	
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent  e) {
		Player player = e.getPlayer();
	    if(e.getItemInHand().getItemMeta().getLocalizedName().equals(this.getItemMeta().getLocalizedName())) {
	    	if(!player.getGameMode().equals(GameMode.CREATIVE)) {
	    		PlayerInventory inv=e.getPlayer().getInventory();
    			ItemStack ritem=inv.getItemInMainHand();
    			ItemStack litem=inv.getItemInOffHand();
	    		try {
	    			if(ritem.getItemMeta().getLocalizedName().equals(this.getItemMeta().getLocalizedName())){
	    				ItemStack item=ritem;
	    				int nur=item.getAmount();
	    				item.setAmount(nur);
	    				inv.setItemInMainHand(item);
	    				return;
	    			}
	    			if(litem.getItemMeta().getLocalizedName().equals(this.getItemMeta().getLocalizedName())){
	    				ItemStack item=litem;
	    				int nur=item.getAmount();
	    				item.setAmount(nur);
	    				inv.setItemInOffHand(item);
	    				return;
	    			}
	    		} catch (Exception ex) {
	    			if(litem.getItemMeta().getLocalizedName().equals(this.getItemMeta().getLocalizedName())){
	    				ItemStack item=litem;
	    				int nur=item.getAmount();
	    				item.setAmount(nur);
	    				inv.setItemInOffHand(item);
	    				return;
	    			}
	    		}
	    	}
	    }
	}
}