package wuchilong.mc.plugin.item.itemlist.Excalibur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.item.CustomItem;

public class ItemGod_of_axe extends CustomItem{
	
	public HashMap<Player, BlockFace> blockface=new HashMap<Player, BlockFace>();
	public ItemGod_of_axe() {
		super(Material.GOLDEN_AXE,(short) 1,"god_of_axe");
		ItemMeta item = this.getItemMeta();
		item.setDisplayName(ChatColor.GOLD + "斷鋼神斧");
		item.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "非常OP的斧"),
				(ChatColor.WHITE + "使用時請往樹根砍")
		}));
		item.setUnbreakable(true);
		item.setLocalizedName("excalibur."+this.itemname);
		this.setItemMeta(item);
		this.addUnsafeEnchantment(new EnchantmentWrapper("efficiency"), 1);//32
		this.addUnsafeEnchantment(new EnchantmentWrapper("sharpness"), 500);//16
		this.addUnsafeEnchantment(new EnchantmentWrapper("looting"), 3);//21
		isRecipe=true;
		hasSkill=true;
	}
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		recipe[0]= itemList.get("excalibur_Gilded_diamond");
		recipe[1]= itemList.get("excalibur_Gilded_diamond");
		recipe[3]= itemList.get("excalibur_Gilded_diamond");
		recipe[4]= itemList.get("excalibur_Gildedgrip");
		recipe[7]= itemList.get("excalibur_Gildedgrip");
	}
	
	
	@EventHandler
	public void onBlockBreakEvent (BlockBreakEvent  e) {
		Player player = e.getPlayer();
	    boolean hold=false;
	    try {
	    	hold=player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals(this.getItemMeta().getLocalizedName());
	    }catch(Exception ex){
	    	hold=false;
	    }
	    if(hold) {
	    	e.setCancelled(true);
	    	ItemStack tol=player.getInventory().getItemInMainHand();
	    	//tol.addUnsafeEnchantment(new EnchantmentWrapper("silk_touch"), 5);
	    	Block b=e.getBlock();
	    	//int x=(int) b.getLocation().getX();
	    	//int y=(int) b.getLocation().getY();
	    	//int z=(int) b.getLocation().getZ();
	    	Material GrassList[]= {
					Material.GRASS_BLOCK,
					Material.DIRT,
					Material.COARSE_DIRT,
					Material.PODZOL,
					Material.MYCELIUM
					};
	    	Material LogList[]= {
					Material.ACACIA_LOG,
					Material.BIRCH_LOG,
					Material.DARK_OAK_LOG,
					Material.JUNGLE_LOG,
					Material.OAK_LOG,
					Material.SPRUCE_LOG
					};
	    	Material LeavesList[]= {
					Material.ACACIA_LEAVES,
					Material.BIRCH_LEAVES,
					Material.DARK_OAK_LEAVES,
					Material.JUNGLE_LEAVES,
					Material.OAK_LEAVES,
					Material.SPRUCE_LEAVES
					};
	    	Material dirbolck=b.getState().getType();
	    	Material grass=b.getRelative(BlockFace.DOWN).getState().getType();
	    	
	    	boolean canwork1=false;
	    	for(Material i:GrassList) {
	    		if(i.equals(grass)) {canwork1=true;break;}
	    	}
	    	if(!canwork1) {e.setCancelled(false);return;}
	    	
	    	boolean canwork2=false;
	    	Material leave=null;
	    	for(int i=0;i<LogList.length;i++) {
	    		if(LogList[i].equals(dirbolck)) {
	    			canwork2=true;
	    			leave=LeavesList[i];
	    			break;
	    			}
	    	} 
	    	if(!canwork2) {e.setCancelled(false);return;}
	    	
	    	//bb.breakNaturally(tol);
	    	int maxwidth=6;
	    	Location rootLoc=b.getLocation();
	    	
	    	List<Location> round1=new ArrayList<Location>();
	    	//List<Location> alldir=new ArrayList<Location>();
	    	//alldir.add(b.getLocation());
	    	round1.add(rootLoc);
	    	List<Location> next_round=new ArrayList<Location>();
	    	while(!round1.isEmpty()){
	    		next_round.clear();
	    		for(Location loc:round1) {
	    			for(int i=0;i<18;i++) {
	    				Location n=loc.clone().add(i%3-1,(i/9),(i%9)/3-1);
	    				if(java.lang.Math.abs(rootLoc.getBlockX()-n.getBlockX())<=maxwidth && java.lang.Math.abs(rootLoc.getBlockZ()-n.getBlockZ())<=maxwidth) {
		    				if(/*alldir.indexOf(n)==-1 &&*/ next_round.indexOf(n)==-1 && round1.indexOf(n)==-1) {
		    					if(n.getBlock().getState().getType().equals(dirbolck)) {
		    						next_round.add(n);
		    					}
		    					if(n.getBlock().getState().getType().equals(leave)) {
		    						Block block=n.getBlock();
		    			    		block.breakNaturally(tol);
		    					}
		    				}
		    			}
	    			}
	    		}
	    		//p.sendMessage("X1 "+String.valueOf(round1.size()));
	    		for(Location loc:round1) {
	    			Block block=loc.getBlock();
		    		block.breakNaturally(tol);
	    			//alldir.add(loc);
	    		}
	    		List<Location> tmp=round1;
	    		round1=next_round;
	    		//p.sendMessage("X2 "+String.valueOf(round1.size()));
	    		next_round=tmp;
	    	}

	    	
	    }
		
	}
	

}
