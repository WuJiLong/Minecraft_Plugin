package wuchilong.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import wuchilong.mc.plugin.GUI.GUIController;
import wuchilong.mc.plugin.item.ItemController;

public class main extends JavaPlugin{
	public ItemController itemcontroller=new ItemController();
	OtherListener otherListener=new OtherListener();
	GUIController guicontroller=new GUIController();
	public static main PLUGIN;
	public void onEnable() {
		getLogger().info("Loading the plugin...");
		PLUGIN=this;
		itemcontroller.onEnable();
		guicontroller.onEnable();
		getServer().getPluginManager().registerEvents(otherListener, this);
	}
	public void onDisable() {
		getLogger().info("close server");
		guicontroller.onDisable();
		itemcontroller.onDisable();
	}
}
