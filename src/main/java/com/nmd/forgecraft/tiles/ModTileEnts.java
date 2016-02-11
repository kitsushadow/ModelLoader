package com.nmd.forgecraft.tiles;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModTileEnts {
	
	public static void init() {
		GameRegistry.registerTileEntity(TileEntTest.class, "tutorial_tile_entity");
	}

}
