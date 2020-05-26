package wuchilong.mc.plugin.GUI.GUIlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

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
import org.bukkit.scheduler.BukkitTask;

import wuchilong.mc.plugin.main;
import wuchilong.mc.plugin.GUI.GUIController;

public class GUI_main implements Listener {
	HashMap<UUID, Inventory> GUI = new HashMap<UUID, Inventory>();
	HashMap<UUID, BukkitTask> TASK = new HashMap<UUID, BukkitTask>();
	
	HashMap<String, ItemStack> BUTTON = new HashMap<String, ItemStack>();
	public void init() {
		//通用按鈕
		ItemStack itemRecipe=new ItemStack(Material.CRAFTING_TABLE,(short) 1);
		ItemMeta iR=itemRecipe.getItemMeta();
		iR.setDisplayName(ChatColor.BLUE + "自定義道具列表");
		iR.setLore(Arrays.asList(new String[] {
				(ChatColor.WHITE + "伺服器的自定義道具全覽"),
				(ChatColor.WHITE + "如有合成方式，也可點擊物品做查詢")
		}));
		itemRecipe.setItemMeta(iR);
		BUTTON.put("itemRecipe", itemRecipe);
		
	}
	public void createGUI(Player player) {
		UUID uuid=player.getUniqueId();
		Inventory aGUI;
		if(GUI.get(uuid)!=null) {
			aGUI=GUI.get(uuid);
			aGUI.clear();
		}else {
			aGUI=Bukkit.createInventory(null , 54 , ChatColor.BLUE+"平板電腦");
		}
		//非通用按鈕
		//ItemStack Testitem=new ItemStack(Material.CRAFTING_TABLE,(short) 1);
		//ItemMeta Ti=Testitem.getItemMeta();
		//Ti.setDisplayName(ChatColor.BLUE + "Test");
		//Ti.setLore(Arrays.asList(new String[] {
		//		(ChatColor.WHITE + player.getName()),
		//		(ChatColor.WHITE + "")
		//}));
		//Testitem.setItemMeta(Ti);
		
		aGUI.setItem(0, BUTTON.get("itemRecipe"));
		//aGUI.setItem(8, Testitem);
		GUI.put(uuid, aGUI);
	}
	public void opengui(Player player) {
		player.closeInventory();
		UUID uuid=player.getUniqueId();
		if(TASK.get(uuid)!=null) {
			TASK.get(uuid).cancel();
		}
		createGUI(player);
		BukkitTask task=Bukkit.getScheduler().runTaskLater(main.PLUGIN, new Runnable(){
			@Override
			public void run()
			{
				GUI.remove(uuid);//5分鐘後釋放資源
				TASK.remove(uuid);
			}
		}, 6000);
		TASK.put(uuid, task);
		try {
			player.openInventory(GUI.get(player.getUniqueId()));
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			Player player = (Player) e.getWhoClicked();
			Inventory inventory = e.getInventory();
			UUID uuid=player.getUniqueId();
			if(inventory.equals(GUI.get(uuid))) {
				e.setCancelled(true);
				try {
				if(e.getCurrentItem().getItemMeta().equals(BUTTON.get("itemRecipe").getItemMeta()))
					GUIController.gui_itemRecipe.opengui(player);
				}catch (Exception ex) {
		           // e.printStackTrace();
		        }
			}
		}
	}
}
