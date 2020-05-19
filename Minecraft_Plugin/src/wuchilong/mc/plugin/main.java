package wuchilong.mc.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	public void onEnable() {
		getLogger().info("Loading the plugin...");
		
	}
	public void onDisable() {
		getLogger().info("close server");

	}
}
