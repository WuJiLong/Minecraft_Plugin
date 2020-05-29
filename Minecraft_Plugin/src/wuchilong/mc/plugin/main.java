package wuchilong.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import wuchilong.mc.plugin.GUI.GUIController;
import wuchilong.mc.plugin.item.ItemController;
import wuchilong.mc.plugin.maze.MazeController;

public class main extends JavaPlugin{
	public ItemController itemcontroller=new ItemController();
	OtherListener otherListener=new OtherListener();
	GUIController guicontroller=new GUIController();
	MazeController mazevontroller=new MazeController();
	public static main PLUGIN;
	public void onEnable() {
		PLUGIN=this;
		getLogger().info("Loading the plugin...");
		getConfig().options().copyDefaults(true);
		saveConfig();
	    reloadConfig();
		itemcontroller.onEnable();
		guicontroller.onEnable();
		mazevontroller.onEnable();
		
		getServer().getPluginManager().registerEvents(otherListener, this);
	}
	public void onDisable() {

		mazevontroller.onDisable();
		guicontroller.onDisable();
		itemcontroller.onDisable();
		getLogger().info("close server");
	}
	
}
