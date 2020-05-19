package wuchilong.mc.plugin.item;

import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

import wuchilong.mc.plugin.main;
import wuchilong.mc.plugin.item.itemlist.*;

public class ItemController implements CommandExecutor, TabCompleter{
	main plugin;
	public HashMap<String, CustomItem> itemList=new HashMap<String, CustomItem>();
	
	public ItemController(main plugin) {
		this.plugin=plugin;
	}
	
	public void onEnable() {
		plugin.getLogger().info("Loading itemList");
		//add command
		plugin.getCommand("getitem").setExecutor(this);
		
		//addItemlist
		itemList.put("Excalibur", new ItemExcalibur());
		
		
	}
	public void onDisable() {
		
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender , Command cmd , String lable , String[] args) {
		// TODO Auto-generated method stub
		if(lable.equalsIgnoreCase("getitem")){
			if(sender instanceof Player){//如果命令發送者是玩家
				Player p = (Player) sender;//強制轉型成玩家
				List<String> endlist= Lists.newArrayList();
				if(p.hasPermission("Wu.item.cmmand.getitem")){//是否有權限
					List<String> list= Lists.newArrayList();
					list.addAll(itemList.keySet());
					if(args.length==1){
						for(String s:list){
							if(s.toLowerCase().startsWith(args[0].toLowerCase())) endlist.add(s);
						}
					}
				}else {
					
				}
				return endlist; 
			}
		}
		return null;
	}
	@Override
	public boolean onCommand(CommandSender sender , Command cmd , String lable , String[] args) {
		if(lable.equalsIgnoreCase("getitem")){
			if(sender instanceof Player){//如果命令發送者是玩家
				Player p = (Player) sender;//強制轉型成玩家
				if(p.hasPermission("Wu.item.cmmand.getitem")){//是否有權限
					if(args.length==1){
						if(itemList.get(args[0])!=null){
							ItemStack i=itemList.get(args[0]);
							p.getInventory().addItem(i);
						}else{
							p.sendMessage(ChatColor.RED + "[Item]找不到道具");
						}
					}
				}else{
					p.sendMessage(ChatColor.RED + "[Item]沒有權限(Wu.item.cmmand.getitem)");
				}
				return true;
			
			}
		}
		return false;
	}
}
