package com.github.akafasty.stackdrops;

import org.bukkit.Material;

import java.util.EnumSet;
import java.util.Set;

public interface StackdropsConstants {

    String META_DATA = "commons:drops";

    String DISPLAY = "§e%sx";

    Set<Material> BLACKLIST = EnumSet.of(
            
            Material.DIAMOND_SWORD, Material.DIAMOND_PICKAXE, Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_SPADE,
            Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS,

            Material.IRON_SWORD, Material.IRON_PICKAXE, Material.IRON_AXE, Material.IRON_HOE, Material.IRON_SPADE,
            Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS,

            Material.GOLD_SWORD, Material.GOLD_PICKAXE, Material.GOLD_AXE, Material.GOLD_HOE, Material.GOLD_SPADE,
            Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS,

            Material.STONE_SWORD, Material.STONE_PICKAXE, Material.STONE_AXE, Material.STONE_HOE, Material.STONE_SPADE,
            Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS,

            Material.WOOD_SWORD, Material.WOOD_PICKAXE, Material.WOOD_AXE,
            Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS

    );

}
