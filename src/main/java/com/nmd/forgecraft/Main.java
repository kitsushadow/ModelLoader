package com.nmd.forgecraft;

import com.nmd.forgecraft.blocks.ModBlocks;
import com.nmd.forgecraft.client.render.blocks.BlockRenderRegister;
import com.nmd.forgecraft.renderers.RendererRegistry;
import com.nmd.forgecraft.tiles.ModTileEnts;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "forgecraft";
    public static final String VERSION = "1.0";
    
	@Instance
	public static Main instance = new Main();

	//@SidedProxy(clientSide="com.bedrockminer.tutorial.ClientProxy", serverSide="com.bedrockminer.tutorial.ServerProxy")
	//public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		//proxy.preInit(e);
		ModBlocks.createBlocks();
		ModTileEnts.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		//proxy.init(e);
		BlockRenderRegister.registerBlockRenderer();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		//proxy.postInit(e);
		RendererRegistry.init();
	}
}
