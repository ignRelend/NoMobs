package me.relend.nomobs;

import org.bukkit.plugin.java.JavaPlugin;

public class NoMobs extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new SpawnListener(), this);
    }

}
