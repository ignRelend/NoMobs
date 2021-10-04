package me.relend.nomobs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnListener implements Listener
{

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event)
    {
        if(!NoMobs.getPlugin(NoMobs.class).getConfig().getList("disabled-worlds").contains(event.getLocation().getWorld().getName()))
        {
            if(NoMobs.getPlugin(NoMobs.class).getConfig().getBoolean("use-disabled-spawn-reasons"))
            {
                if(NoMobs.getPlugin(NoMobs.class).getConfig().getList("disabled-spawn-reasons").contains(event.getSpawnReason().toString()))
                {
                    event.setCancelled(true);
                    if (NoMobs.getPlugin(NoMobs.class).getConfig().getBoolean("log-removals"))
                    {
                        System.out.println("Removed a " + event.getEntity().getName() + " at " + event.getLocation().getBlockX() + "/" + event.getLocation().getBlockY() + "/" + event.getLocation().getBlockZ() + ".");
                    }
                }
            } else
            {
                if(event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.COMMAND || event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.CUSTOM)
                {
                    event.setCancelled(true);
                    if (NoMobs.getPlugin(NoMobs.class).getConfig().getBoolean("log-removals"))
                    {
                        System.out.println("Removed a " + event.getEntity().getName() + " at " + event.getLocation().getBlockX() + "/" + event.getLocation().getBlockY() + "/" + event.getLocation().getBlockZ() + ".");
                    }
                }
            }
        }

    }

}
