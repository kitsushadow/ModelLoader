package com.nmd.forgecraft.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block modBlockTileEntity;

	public static final void createBlocks() {
		GameRegistry.registerBlock(modBlockTileEntity = new ModBlockTileEntity("tile_entity"), "tile_entity");
	}
}