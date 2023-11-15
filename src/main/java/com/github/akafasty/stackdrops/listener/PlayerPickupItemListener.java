package com.github.akafasty.stackdrops.listener;

import com.github.akafasty.stackdrops.StackdropsConstants;
import com.github.akafasty.stackdrops.misc.NumberFormatter;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class PlayerPickupItemListener implements Listener {

    private final Plugin plugin;

    public PlayerPickupItemListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    protected void playerPickupItemEventHandler(PlayerPickupItemEvent event) {

        if (!event.getItem().hasMetadata(StackdropsConstants.META_DATA))
            return;

        event.setCancelled(true);

        Player player = event.getPlayer();
        Item item = event.getItem();
        ItemStack drop = item.getItemStack();

        int stackAmount = event.getItem().getMetadata(StackdropsConstants.META_DATA).get(0).asInt();

        player.playSound(item.getLocation(), Sound.ITEM_PICKUP, 1f, 1f);

        while (stackAmount > 0) {

            if (player.getInventory().firstEmpty() == -1) {
                item.setCustomName(String.format(StackdropsConstants.DISPLAY, NumberFormatter.numberFormat(stackAmount), drop.getType().name()));
                item.setMetadata(StackdropsConstants.META_DATA, new FixedMetadataValue(plugin, stackAmount));
                return;
            }

            int value = Math.min(64, stackAmount);

            stackAmount -= value;

            drop.setAmount(value);

            player.getInventory().addItem(drop.clone());

        }

        item.remove();

    }
}
