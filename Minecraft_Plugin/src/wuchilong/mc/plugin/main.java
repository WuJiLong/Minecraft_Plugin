package wuchilong.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import wuchilong.mc.plugin.item.ItemController;

public class main extends JavaPlugin{
	ItemController itemcontroller=new ItemController(this);
	
	public void onEnable() {
		getLogger().info("Loading the plugin...");
		itemcontroller.onEnable();
		
	}
	public void onDisable() {
		getLogger().info("close server");

	}
}
