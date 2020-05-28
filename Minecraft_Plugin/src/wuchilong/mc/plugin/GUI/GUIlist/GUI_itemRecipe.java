package wuchilong.mc.plugin.GUI.GUIlist;

//import java.security.MessageDigest;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import wuchilong.mc.plugin.main;
import wuchilong.mc.plugin.GUI.GUIController;
import wuchilong.mc.plugin.item.CustomItem;


public class GUI_itemRecipe implements Listener {
	HashMap<String, Inventory> itemList=new HashMap<String, Inventory>();
	Inventory mainGUI;
	public void init() {
		ItemStack NULLitem=new ItemStack(Material.BLACK_STAINED_GLASS_PANE,(short) 1);
		ItemMeta it=NULLitem.getItemMeta();
		it.setDisplayName(" ");
		NULLitem.setItemMeta(it);
		ItemStack EXITitem=new ItemStack(Material.RED_STAINED_GLASS_PANE,(short) 1);
		ItemMeta exit=EXITitem.getItemMeta();
		exit.setDisplayName(ChatColor.BLUE + "返回道具列表");
		EXITitem.setItemMeta(exit);
		
		ItemStack Returnitem=new ItemStack(Material.RED_STAINED_GLASS_PANE,(short) 1);
		ItemMeta Return=EXITitem.getItemMeta();
		Return.setDisplayName(ChatColor.BLUE + "返回主畫面");
		Returnitem.setItemMeta(Return);
		for(CustomItem item:main.PLUGIN.itemcontroller.itemList.values()) {//登入有合成表的
			if(item.isRecipe) {
				Inventory inventory=Bukkit.createInventory(null , 54 , item.getItemMeta().getDisplayName()+ChatColor.BLUE+"的合成表");
				for(int i=0;i<9;i++) {
					inventory.setItem(i, NULLitem);
					inventory.setItem(36+i, NULLitem);
				}
				inventory.setItem(45, EXITitem);
				for(int i=1;i<9;i++) {
					inventory.setItem(45+i, NULLitem);
				}
				for(int i=0;i<3;i++) {
					inventory.setItem(9+9*i, NULLitem);
					inventory.setItem(13+9*i, NULLitem);
					inventory.setItem(14+9*i, NULLitem);
					inventory.setItem(16+9*i, NULLitem);
					inventory.setItem(17+9*i, NULLitem);
				}
				inventory.setItem(15, NULLitem);
				inventory.setItem(24, item);
				inventory.setItem(33, NULLitem);
				int index[]= {10,11,12,19,20,21,28,29,30};
				for(int i=0;i<9;i++) {
					if(item.recipe[i]!=null) {
						inventory.setItem(index[i], item.recipe[i]);
					}
				}
				itemList.put(item.getItemMeta().getLocalizedName()/*getHash(item.getItemMeta())*/,inventory);
			}
		}
		mainGUI=Bukkit.createInventory(null , 54 , ChatColor.BLUE+"自定義道具列表");
		
		
		mainGUI.setItem(0, main.PLUGIN.itemcontroller.itemList.get("excalibur_Strengthengold_ingot"));
		mainGUI.setItem(1, main.PLUGIN.itemcontroller.itemList.get("excalibur_Strengthengold_block"));
		mainGUI.setItem(2, main.PLUGIN.itemcontroller.itemList.get("excalibur_Gilded_diamond"));
		mainGUI.setItem(3, main.PLUGIN.itemcontroller.itemList.get("excalibur_Gildedgrip"));
		mainGUI.setItem(4, main.PLUGIN.itemcontroller.itemList.get("excalibur_Excalibur"));
		mainGUI.setItem(5, main.PLUGIN.itemcontroller.itemList.get("excalibur_God_of_pickaxe"));
		mainGUI.setItem(6, main.PLUGIN.itemcontroller.itemList.get("excalibur_God_of_axe"));
		
		mainGUI.setItem(9, main.PLUGIN.itemcontroller.itemList.get("adventure_Hardener"));
		mainGUI.setItem(10, main.PLUGIN.itemcontroller.itemList.get("adventure_Elytra"));
		mainGUI.setItem(11, main.PLUGIN.itemcontroller.itemList.get("adventure_InfiniteFireworks"));
		mainGUI.setItem(45,Returnitem);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			Player player = (Player) e.getWhoClicked();
			Inventory inventory = e.getInventory();
			boolean ismygui=inventory.equals(mainGUI);
			boolean ismain=inventory.equals(mainGUI);
			for(Inventory i:itemList.values()) {
				if(ismygui) break;
				ismygui=inventory.equals(i);
			}
			if(ismygui) {
				e.setCancelled(true);
				int click_nur=e.getRawSlot();
				if(click_nur==45) {
					if(!ismain) {
						player.closeInventory();
						player.openInventory(mainGUI);
					}else {
						GUIController.gui_main.opengui(player);
					}
				}
				try {
					String index=e.getCurrentItem().getItemMeta().getLocalizedName();//getHash(e.getCurrentItem().getItemMeta());
					if(itemList.get(index)!=null) {
						player.closeInventory();
						player.openInventory(itemList.get(index));
					}
				}catch(Exception ex){
					
			    }
				
			}
		}
		
	}
	
	
	
	
	public void opengui(Player player) {
		player.closeInventory();
		player.openInventory(mainGUI);
	}
	/*
	private String getHash(ItemMeta item) {
		byte[] bytes = item.toString().getBytes();
		byte[] digest;
		try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            digest = messageDigest.digest();

        } catch (Exception e) {
            e.printStackTrace();
            return item.toString();
        }
		StringBuffer sb = new StringBuffer();
		for (int n = 0; n < digest.length; n++) {
			String stmp = (Integer.toHexString(digest[n] & 0XFF));
            if (stmp.length() == 1) {
                sb.append("0").append(stmp);
            } else {
                sb.append(stmp);
            }
        }
		return sb.toString().toUpperCase();
	}*/
}
