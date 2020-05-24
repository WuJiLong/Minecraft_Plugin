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
import wuchilong.mc.plugin.item.itemlist.ItemIPad;
import wuchilong.mc.plugin.item.itemlist.Adventure.*;
import wuchilong.mc.plugin.item.itemlist.Excalibur.*;//斷鋼聖劍系列


public class ItemController implements CommandExecutor, TabCompleter{
	public HashMap<String, CustomItem> itemList=new HashMap<String, CustomItem>();
	
	
	public void onEnable() {
		main.PLUGIN.getLogger().info("Loading itemList");
		//add command
		main.PLUGIN.getCommand("getitem").setExecutor(this);
		
		//addItemlist
		itemList.put("other-I_pad", new ItemIPad());//I pad
		
		itemList.put("adventure_InfiniteFireworks", new ItemInfiniteFireworks());//
		itemList.put("adventure_Hardener", new ItemHardener());//
		itemList.put("adventure_Elytra", new ItemElytra());//
		
		itemList.put("excalibur_Excalibur", new ItemExcalibur());//斷鋼聖劍
		itemList.put("excalibur_Strengthengold_ingot", new ItemStrengthengold_ingot());//強化金錠
		itemList.put("excalibur_Strengthengold_block", new ItemStrengthengold_block());//強化金磚
		itemList.put("excalibur_Gilded_diamond", new ItemGilded_diamond());//鍍金鑽
		itemList.put("excalibur_Gildedgrip", new ItemGildedgrip());//鍍金握把
		itemList.put("excalibur_God_of_pickaxe", new ItemGod_of_pickaxe());//斷剛神稿
		itemList.put("excalibur_God_of_axe", new ItemGod_of_axe());//斷剛神斧
		
	
		
		//登入合成表
		for(CustomItem i:itemList.values()) {
			i.insterRecipe(itemList);
			if(i.needListen()) main.PLUGIN.getServer().getPluginManager().registerEvents(i, main.PLUGIN);//事件
		}
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
				if(p.hasPermission("Wu.item.command.getitem")){//是否有權限
					List<String> list= Lists.newArrayList();
					list.addAll(itemList.keySet());
					if(args.length==1){
						for(String s:list){
							if(s.toLowerCase().startsWith(args[0].toLowerCase())) endlist.add(s);
						}
					}
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
				if(p.hasPermission("Wu.item.command.getitem")){//是否有權限
					if(args.length==1){
						if(itemList.get(args[0])!=null){
							ItemStack i=itemList.get(args[0]);
							p.getInventory().addItem(i);
						}else{
							p.sendMessage(ChatColor.RED + "[Item]找不到道具");
						}
					}
				}else{
					p.sendMessage(ChatColor.RED + "[Item]沒有權限(Wu.item.command.getitem)");
				}
				return true;
			
			}
		}
		return false;
	}
}
