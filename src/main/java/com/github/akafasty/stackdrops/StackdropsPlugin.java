package com.github.akafasty.stackdrops;

import com.github.akafasty.stackdrops.listener.EntitySpawnListener;
import com.github.akafasty.stackdrops.listener.PlayerPickupItemListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class StackdropsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPickupItemListener(this), this);

        getLogger().info("Stack system is up!");

    }

}
