package wuchilong.mc.plugin.maze;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import wuchilong.mc.plugin.main;

public class MazeController implements CommandExecutor{
	String maze_name="Maze_world";
	MazeGenerator mazegenerator;
	public void onEnable() {
		
		main.PLUGIN.getLogger().info("Loading Maze");
		if(main.PLUGIN.getServer().getWorld(maze_name) == null){
			WorldCreator wc = new WorldCreator(maze_name);
			wc.seed(main.PLUGIN.getServer().getWorlds().get(0).getSeed());
			mazegenerator=new MazeGenerator(wc.seed());
			wc.generator(mazegenerator);
			wc.createWorld();
		}else {
			Long seed=main.PLUGIN.getServer().getWorld(maze_name).getSeed();
			//getLogger().info("(Seed: "+String.valueOf(seed)+")");//-8167734177475918459
			mazegenerator=new MazeGenerator(seed);
		}
		
		main.PLUGIN.getCommand("gotomaze").setExecutor(this);
		
	}
	public void onDisable() {
		
	}
	@Override
	public boolean onCommand(CommandSender sender , Command cmd , String lable , String[] args) {
		if(lable.equalsIgnoreCase("gotomaze")){
			if(sender instanceof Player){//如果命令發送者是玩家
				Player player = (Player) sender;//強制轉型成玩家
				if(player.hasPermission("Wu.maze.command.gotomaze")){//是否有權限
					Location loc=player.getLocation();
					loc.setWorld(main.PLUGIN.getServer().getWorld(maze_name));
					loc.setY(100);
					player.teleport(loc);
					return true;
				}else{
					player.sendMessage(ChatColor.RED + "[Maze]沒有權限(Wu.maze.command.gotomaze)");
				}
			}
		}
		return false;
	}
}
