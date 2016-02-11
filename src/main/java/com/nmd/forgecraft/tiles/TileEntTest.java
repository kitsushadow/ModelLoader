package com.nmd.forgecraft.tiles;

import net.minecraft.tileentity.TileEntity;

public class TileEntTest extends TileEntity{

	@Override
    public void onLoad()
    {
    	System.out.println("Hello, I'm a Tile Entity!");
    }
		

}
