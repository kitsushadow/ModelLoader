package com.nmd.forgecraft.renderers;

import com.nmd.forgecraft.tiles.TileEntTest;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class RendererRegistry {

	public static final void init() {
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntTest.class, new DamascusIngotRenderer());
	}
	
}
