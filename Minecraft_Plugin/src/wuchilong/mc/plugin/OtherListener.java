package wuchilong.mc.plugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OtherListener implements Listener{
	
	@EventHandler
	public void EntityDamageByEntityEvent(org.bukkit.event.entity.EntityDamageByEntityEvent e) {
		Entity p = e.getDamager();
		Entity p2 = e.getEntity();
		
		if (p2 instanceof Player) {
			if(e.getDamage()>30){
					e.setDamage(30);
					main.PLUGIN.getLogger().info(p.getName()+"攻擊"+p2.getName()+"的傷害已抵銷!");
			}
	    }
      
	}
}
