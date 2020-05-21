package wuchilong.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import wuchilong.mc.plugin.item.ItemController;
import wuchilong.mc.plugin.OtherListener;

public class main extends JavaPlugin{
	ItemController itemcontroller=new ItemController(this);
	OtherListener otherListener=new OtherListener(this);
	public static main PLUGIN;
	public void onEnable() {
		getLogger().info("Loading the plugin...");
		PLUGIN=this;
		itemcontroller.onEnable();
		
		getServer().getPluginManager().registerEvents(otherListener, this);
	}
	public void onDisable() {
		getLogger().info("close server");
		itemcontroller.onDisable();
	}
}
