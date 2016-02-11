package com.nmd.forgecraft.blocks;

import com.nmd.forgecraft.tiles.TileEntTest;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockTileEntity extends BlockContainer {

	protected ModBlockTileEntity(String unlocalizedName) {
		super(Material.iron);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(2.0f);
		this.setResistance(6.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntTest();
	}

	@Override
	public int getRenderType() {
		return 2;
	}
}