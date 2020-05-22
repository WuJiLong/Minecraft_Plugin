package wuchilong.mc.plugin.item.itemlist.Adventure;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemInfiniteFireworks extends CustomItem{

	public ItemInfiniteFireworks() {
		super(Material.FIREWORK_ROCKET,(short) 1,"infinitefireworks");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.LIGHT_PURPLE +"火箭推進器");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "這個世界中少數的高科技產品。"),
				(ChatColor.WHITE + "但這好像沒有燃料填充口。")
		}));
		//item.setUnbreakable(true);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("infinity"), 10);//51
		hasSkill=true;
	}
	
	
	@EventHandler
	public void fly(PlayerInteractEvent e){
		Player p=e.getPlayer();
		Block b=e.getClickedBlock();
		ItemStack usingitem=e.getItem();
		try {
			if(p.getGameMode().equals(GameMode.CREATIVE)) return;
			 if(usingitem.getItemMeta().equals(this.getItemMeta())){
					if(b!=null || !p.isGliding() || !e.getAction().equals(Action.RIGHT_CLICK_AIR)) { e.setCancelled(true); return;}
					ItemStack item=usingitem;
					int nur=item.getAmount()+1;
					usingitem.setAmount(nur);
					return;
			}
	    }catch(Exception ex){}
	}
}
