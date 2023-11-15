package com.github.akafasty.stackdrops.listener;

import com.github.akafasty.stackdrops.StackdropsConstants;
import com.github.akafasty.stackdrops.misc.NumberFormatter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class EntitySpawnListener implements Listener {

    private final Plugin plugin;

    public EntitySpawnListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    protected void entitySpawnEventHandler(EntitySpawnEvent event) {

        if (event.getEntityType() != EntityType.DROPPED_ITEM)
            return;

        Item item = (Item) event.getEntity();

        if (StackdropsConstants.BLACKLIST.contains(item.getItemStack().getType()))
            return;

        int stackAmount = item.getItemStack().getAmount();

        Item entity = event.getEntity().getNearbyEntities(8, 8, 8)
                .stream()
                .filter(context -> context.getType() == event.getEntityType())
                .filter(context -> context.hasMetadata(StackdropsConstants.META_DATA))
                .map(Item.class::cast)
                .filter(context -> context.getItemStack().isSimilar(item.getItemStack()))
                .findFirst().orElse(null);

        if (entity != null) {

            event.setCancelled(true);

            item.remove();
            stackAmount += entity.getMetadata(StackdropsConstants.META_DATA).get(0).asInt();

        }

        else entity = item;

        entity.setCustomNameVisible(true);
        entity.setCustomName(String.format(StackdropsConstants.DISPLAY, NumberFormatter.numberFormat(stackAmount)));
        entity.setMetadata(StackdropsConstants.META_DATA, new FixedMetadataValue(plugin, stackAmount));

    }

}
