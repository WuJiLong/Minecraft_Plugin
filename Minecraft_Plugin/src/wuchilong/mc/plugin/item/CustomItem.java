package wuchilong.mc.plugin.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import wuchilong.mc.plugin.main;

public class CustomItem extends ItemStack{
	//public boolean isRecipe;是否有合成表
	public boolean hasSkill;
	
	public CustomItem(Material type, int amount,boolean hasSkill) {
		super(type,(short) amount);
		this.hasSkill=hasSkill;
	}
	
	public void insterRecipe(main plugin) {//加入自定義合成表
		
	}
	
	public boolean ckMetaData(ItemStack a) {
		return (this.getItemMeta().equals(a.getItemMeta()));
	}
	
}
