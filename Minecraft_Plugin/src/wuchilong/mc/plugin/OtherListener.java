package wuchilong.mc.plugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OtherListener implements Listener{
	main plugin;
	public OtherListener(main plugin) {
		this.plugin=plugin;
	}
	@EventHandler
	public void EntityDamageByEntityEvent(org.bukkit.event.entity.EntityDamageByEntityEvent e) {
		Entity p = e.getDamager();
		Entity p2 = e.getEntity();
		if (p instanceof Player) {
			if (p2 instanceof Player) {
				if(e.getDamage()>=20){
						e.setDamage(20);
						plugin.getLogger().info(p.getName()+"攻擊"+p2.getName()+"的傷害已抵銷!");
				}
		    }
        }
	}
}
