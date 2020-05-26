package wuchilong.mc.plugin.GUI;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import wuchilong.mc.plugin.main;
import wuchilong.mc.plugin.GUI.GUIlist.*;


public class GUIController implements CommandExecutor{
	public static GUI_itemRecipe gui_itemRecipe=new GUI_itemRecipe();
	public static GUI_main gui_main=new GUI_main();
	public void onEnable() {
		gui_itemRecipe.init();
		main.PLUGIN.getServer().getPluginManager().registerEvents(gui_itemRecipe, main.PLUGIN);
		gui_main.init();
		main.PLUGIN.getServer().getPluginManager().registerEvents(gui_main, main.PLUGIN);
		
		main.PLUGIN.getCommand("openGUI").setExecutor(this);
		main.PLUGIN.getCommand("itemlist").setExecutor(this);
	}
	public void onDisable() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender , Command cmd , String lable , String[] args) {
		if(lable.equalsIgnoreCase("openGUI")){
			if(sender instanceof Player){//如果命令發送者是玩家
				Player p = (Player) sender;//強制轉型成玩家
				if(p.hasPermission("Wu.GUI.command.openGUI")){//是否有權限
					gui_main.opengui(p);
				}else{
					p.sendMessage(ChatColor.RED + "[GUI]沒有權限(Wu.GUI.command.openGUI)");
				}
				return true;
			
			}
		}else if(lable.equalsIgnoreCase("itemlist")){
			if(sender instanceof Player){//如果命令發送者是玩家
				Player p = (Player) sender;//強制轉型成玩家
				if(p.hasPermission("Wu.GUI.command.itemlist")){//是否有權限
					gui_itemRecipe.opengui(p);
				}else{
					p.sendMessage(ChatColor.RED + "[GUI]沒有權限(Wu.GUI.command.itemlist)");
				}
				return true;
			
			}
		}
		return false;
	}
}
