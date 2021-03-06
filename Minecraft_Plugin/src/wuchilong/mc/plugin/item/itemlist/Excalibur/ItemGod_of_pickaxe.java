package wuchilong.mc.plugin.item.itemlist.Excalibur;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.main;
import wuchilong.mc.plugin.item.CustomItem;

public class ItemGod_of_pickaxe extends CustomItem{
	ItemMeta Mod1_ItemMeta;
	ItemMeta Mod2_ItemMeta;
	ItemMeta Mod3_ItemMeta;
	public HashMap<Player, BlockFace> blockface=new HashMap<Player, BlockFace>();
	public ItemGod_of_pickaxe() {
		super(Material.GOLDEN_PICKAXE,(short) 1,"god_of_pickaxe");
		Mod1_ItemMeta = this.getItemMeta();
		Mod1_ItemMeta.setDisplayName(ChatColor.GOLD + "斷鋼神稿");
		Mod1_ItemMeta.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "非常OP的稿"),
				(ChatColor.WHITE + "功能調節:主手拿著按下右鍵"),
				(ChatColor.GREEN + "1.選擇性破壞(全)"),
				(ChatColor.GRAY + "2.選擇性破壞(礦物)"),
				(ChatColor.GRAY + "3.全數破壞")
		}));
		Mod1_ItemMeta.setUnbreakable(true);
		
		Mod2_ItemMeta = this.getItemMeta();
		Mod2_ItemMeta.setDisplayName(ChatColor.GOLD + "斷鋼神稿");
		Mod2_ItemMeta.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "非常OP的稿"),
				(ChatColor.WHITE + "功能調節:主手拿著按下右鍵"),
				(ChatColor.GRAY + "1.選擇性破壞(全)"),
				(ChatColor.GREEN+ "2.選擇性破壞(礦物)"),
				(ChatColor.GRAY + "3.全數破壞")
		}));
		Mod2_ItemMeta.setUnbreakable(true);
		
		Mod3_ItemMeta = this.getItemMeta();
		Mod3_ItemMeta.setDisplayName(ChatColor.GOLD + "斷鋼神稿");
		Mod3_ItemMeta.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "非常OP的稿"),
				(ChatColor.WHITE + "功能調節:主手拿著按下右鍵"),
				(ChatColor.GRAY + "1.選擇性破壞(全)"),
				(ChatColor.GRAY + "2.選擇性破壞(礦物)"),
				(ChatColor.GREEN + "3.全數破壞")
		}));
		Mod3_ItemMeta.setUnbreakable(true);
		Mod1_ItemMeta.setLocalizedName("excalibur."+this.itemname+"1");
		Mod2_ItemMeta.setLocalizedName("excalibur."+this.itemname+"2");
		Mod3_ItemMeta.setLocalizedName("excalibur."+this.itemname+"3");
		this.setItemMeta(Mod1_ItemMeta);
		this.addUnsafeEnchantment(new EnchantmentWrapper("efficiency"), 10000);//32
		isRecipe=true;
		hasSkill=true;
	}
	@Override
	public void loadRecipe(HashMap<String, CustomItem> itemList) {
		recipe[0]= itemList.get("excalibur_Gilded_diamond");
		recipe[1]= itemList.get("excalibur_Gilded_diamond");
		recipe[2]= itemList.get("excalibur_Gilded_diamond");
		recipe[4]= itemList.get("excalibur_Gildedgrip");
		recipe[7]= itemList.get("excalibur_Gildedgrip");
	}
	
	private int getMod(ItemStack item) {
		try {
			String Lname=item.getItemMeta().getLocalizedName();
			if(Lname.contentEquals(Mod1_ItemMeta.getLocalizedName())) {
				return 1;
			}
			if(Lname.contentEquals(Mod2_ItemMeta.getLocalizedName())) {
				return 2;
			}
			if(Lname.contentEquals(Mod3_ItemMeta.getLocalizedName())) {
				return 3;
			}
		}catch(Exception ex){
	    }
		return 0;
	}
	
	@EventHandler
	public void Switch_working_mode(PlayerInteractEvent e) {
	    Player player = e.getPlayer();
	    if(e.getHand()!=null)
	    	if(e.getHand().equals(EquipmentSlot.OFF_HAND)) return;
	    if(e.getAction() != Action.RIGHT_CLICK_BLOCK && e.getAction() != Action.RIGHT_CLICK_AIR) return;
	    int mod=getMod(player.getInventory().getItemInMainHand());
	    if(mod!=0) {
	    	Map<Enchantment,Integer> enchantmen=player.getInventory().getItemInMainHand().getEnchantments();
	    	String name=player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
	    	if(mod==1) {
	    		Mod2_ItemMeta.setDisplayName(name);
	    		player.getInventory().getItemInMainHand().setItemMeta(Mod2_ItemMeta);
	    		player.sendMessage(ChatColor.BLUE + "[斷鋼神稿]切換至功能:選擇性破壞(礦物)");
	    	}else if(mod==2) {
	    		Mod3_ItemMeta.setDisplayName(name);
	    		player.getInventory().getItemInMainHand().setItemMeta(Mod3_ItemMeta);
	    		player.sendMessage(ChatColor.BLUE + "[斷鋼神稿]切換至功能:全數破壞");
	    	}else { 
	    		Mod1_ItemMeta.setDisplayName(name);
	    		player.getInventory().getItemInMainHand().setItemMeta(Mod1_ItemMeta);
	    		player.sendMessage(ChatColor.BLUE + "[斷鋼神稿]切換至功能:選擇性破壞(全)");
	    	} 
	    	player.getInventory().getItemInMainHand().addUnsafeEnchantments(enchantmen);//32
	    	e.setCancelled(true);
	    }
	}
	@EventHandler
	public void onBlockBreakEvent (BlockBreakEvent  e) {
		Player player = e.getPlayer();
		int mod=getMod(player.getInventory().getItemInMainHand());
	    
	    if(mod!=0) {
	    	ItemStack tol=new ItemStack(Material.DIAMOND_PICKAXE);
	    	tol.addUnsafeEnchantments(player.getInventory().getItemInMainHand().getEnchantments());//.addEnchantments(player.getInventory().getItemInMainHand().getEnchantments());
	    	e.setCancelled(true);
	    	//tol.addUnsafeEnchantment(new EnchantmentWrapper("silk_touch"), 5);
	    	Block b=e.getBlock();
	    	int x=(int) b.getLocation().getX();
	    	int y=(int) b.getLocation().getY();
	    	int z=(int) b.getLocation().getZ();
	    	Material UnDig[]= {
					Material.BARRIER,
					Material.BEDROCK,
					Material.NETHER_PORTAL,
					Material.END_PORTAL,
					Material.END_PORTAL_FRAME,
					Material.DRAGON_EGG,
					Material.CHAIN_COMMAND_BLOCK,
					Material.COMMAND_BLOCK,
					Material.REPEATING_COMMAND_BLOCK,
					Material.END_GATEWAY,
					Material.STRUCTURE_VOID,
					Material.STRUCTURE_BLOCK};
	    	Material dirbolck=b.getState().getType();
	    	
	    	int dirsize=main.PLUGIN.getConfig().getInt("customitem.excalibur.god_of_pickaxe.destroy_range", 3);//size
	    	
	    	for(int i=0;i<dirsize;i++) {
    			for(int j=0;j<dirsize;j++) {
    				for(int k=0;k<dirsize;k++){
    					int ax,ay,az;
    					switch(blockface.get(player)){
    			    	case DOWN:
    			    		ax=x-(dirsize/2)+i;ay=y+j;az=z-(dirsize/2)+k;break;
    			    	case UP:
    			    		ax=x-(dirsize/2)+i;ay=y-(dirsize-1)+j;az=z-(dirsize/2)+k;break;
    			    	case EAST:
    			    		ax=x-(dirsize-1)+i;ay=y-(dirsize/2)+j;az=z-(dirsize/2)+k;break;
    			    	case WEST:
    			    		ax=x+i;ay=y-(dirsize/2)+j;az=z-(dirsize/2)+k;break;
    			    	case NORTH:
    			    		ax=x-(dirsize/2)+i;ay=y-(dirsize/2)+j;az=z+k;break;
    			    	case SOUTH:
    			    		ax=x-(dirsize/2)+i;ay=y-(dirsize/2)+j;az=z-(dirsize-1)+k;break;
    					default:
    						ax=x;ay=y;az=z;break;
    					}
    					Block bb=player.getWorld().getBlockAt(ax, ay, az);
    					
    					//maby create a "ClaimedResidence" in here
    					
						boolean candir=true;
						for(Material mate:UnDig) {
							if(bb.getState().getType().equals(mate)) candir=false;
						}
						if(!candir) continue;
						if(mod==1) {
							if(bb.getState().getType().equals(dirbolck))
	    						bb.breakNaturally(tol);
						}else if(mod==2) {
							Material ORE[]= {
									Material.COAL_ORE,
									Material.IRON_ORE,
									Material.GOLD_ORE,
									Material.LAPIS_ORE,
									Material.DIAMOND_ORE,
									Material.REDSTONE_ORE,
									Material.EMERALD_ORE,
									Material.NETHER_QUARTZ_ORE};
							boolean a=false,a1=false;
							for(Material mate:ORE) {
								if(bb.getState().getType().equals(mate))
									a1=true;
								
								if(dirbolck.equals(mate))
									a=true;
							}
							if(a && a1){//如果初始礦物 且破壞方塊也是
								if(dirbolck.equals(bb.getState().getType()))
									bb.breakNaturally(tol);
							}else if(!a && !a1){
								bb.breakNaturally(tol);
							}
						}else {
							bb.breakNaturally(tol);
						}
    				}
    			}
    		}//for i
	   
	    }
		
	}
	
	@EventHandler
	public void dig_block(PlayerInteractEvent e) {
		Player player = e.getPlayer();
	    if(e.getHand()!=null)
	    	if(e.getHand().equals(EquipmentSlot.OFF_HAND)) return;
	    if(e.getAction() != Action.LEFT_CLICK_BLOCK) return;
	    if(getMod(player.getInventory().getItemInMainHand())!=0) {
	    	blockface.put(player, e.getBlockFace());
	    }
	}

}
