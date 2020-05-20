package wuchilong.mc.plugin.item;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
//import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
//import org.bukkit.NamespacedKey;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
//import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import wuchilong.mc.plugin.main;

public class CustomItem extends ItemStack implements Listener{
	protected boolean isRecipe;//是否有合成表
	//protected boolean customItemRecipe;//是否使用自定義道具合成
	protected boolean hasSkill;//是否有技能
	protected boolean isBlock;
	protected ItemStack[] recipe= {null,null,null,null,null,null,null,null,null};//
	public String itemname;
	public CustomItem(Material type, int amount,String name) {
		super(type,(short) amount);
		this.itemname=name;
	}
	
	public void insterRecipe(main plugin,HashMap<String, CustomItem> itemList) {//加入自定義合成表
		if(!isRecipe) return;
		loadRecipe(itemList);
		char [] index= {'!','@','*','#','$','%','^','&','~'};
		ShapedRecipe make = new ShapedRecipe(new  NamespacedKey(plugin,itemname) ,this).shape("!@*","#$%","^&~");
		for(int i=0;i<9;i++) {
			if(recipe[i]!=null) {
				if(recipe[i].hasItemMeta()) {
					@SuppressWarnings("deprecation")
					RecipeChoice custom1Choice = new RecipeChoice.ExactChoice(recipe[i]); //custom ingredient
					make=make.setIngredient(index[i],custom1Choice);
				}else{
					make=make.setIngredient(index[i],recipe[i].getData());
				}
			}
		}
		plugin.getServer().addRecipe(make);
	}
	
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		
		
	}
	
	public boolean ckMetaData(ItemStack a) {
		return (this.getItemMeta().equals(a.getItemMeta()));
	}
	
	public boolean needListen() {
		return (isBlock || hasSkill);
	}
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent  e) {
		if(!isBlock) return;
		Player p = e.getPlayer();
	    if(e.getItemInHand().getItemMeta().equals(this.getItemMeta())) {
	    	if(!p.getGameMode().equals(GameMode.CREATIVE)) {
	    		if(p.getLocale().contentEquals("zh_tw"))
	    			p.sendMessage(ChatColor.RED + "這個方塊不能放在地上！");
	    		else
	    			p.sendMessage(ChatColor.RED + "This block cannot be placed on the ground！");
	    		e.setCancelled(true);
	    	}
	    }
	}
	/*
	@EventHandler
	public void maketheitem(CraftItemEvent a){
		if(!customItemRecipe) return;
		ItemStack item = a.getRecipe().getResult();
		if(((ItemStack) this).equals(item)){
			Player p = (Player) a.getView().getPlayer();
			ItemStack[] usitem=a.getInventory().getMatrix();//取得合成台物品內容
			for(int j=0;j<9;j++){
				if(usitem[j]!=null)
					if(!(usitem[j].getItemMeta().equals(recipe[j].getItemMeta()))){
						p.sendMessage(ChatColor.RED + "材料標籤異常，請使用正確材料合成或是向伺服器管理員提出問題。");
						a.setCancelled(true);
						break;
					}
			}
		}
	}*/
	
}
