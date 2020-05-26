package wuchilong.mc.plugin.item.itemlist.Adventure;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemHardener extends CustomItem{

	public ItemHardener() {
		super(Material.HONEY_BOTTLE,(short) 1,"hardener");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.LIGHT_PURPLE +"固化劑");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "黏黏稠稠的可怕物體"),
				(ChatColor.WHITE + "可以使\"鞘翅\"變得更加堅硬"),
				(ChatColor.RED + "警告：不可食用！"),
		}));
		//item.setUnbreakable(true);
		this.setItemMeta(item);
		//this.addUnsafeEnchantment(new EnchantmentWrapper("infinity"), 10);//51
		hasSkill=true;
	}
	
	
	
	@EventHandler
	public void drink(PlayerItemConsumeEvent e){
		Player player=e.getPlayer();
		ItemStack item=e.getItem();
		if(item.getItemMeta().equals(this.getItemMeta())) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 10));
			
		}
	}
}
