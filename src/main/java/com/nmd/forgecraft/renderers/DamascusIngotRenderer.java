package com.nmd.forgecraft.renderers;

import org.lwjgl.opengl.GL11;

import com.nmd.forgecraft.blocks.ModBlocks;
import com.nmd.forgecraft.model.AdvancedModelLoader;
import com.nmd.forgecraft.model.IModelCustom;
import com.nmd.forgecraft.tiles.TileEntTest;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class DamascusIngotRenderer extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("forgecraft:models/DamascusIngot.png");
	private static final ResourceLocation TEXTURE1 = new ResourceLocation("forgecraft:models/HotDamascusIngot.png");
	private static final ResourceLocation MODEL_BASE = new ResourceLocation("forgecraft:models/IronIngotBlock.obj");

	private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_BASE);

	//@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale, int destroyStage) {
		
		GL11.glPushMatrix();
		// This will move our renderer so that it will be on proper place in the
		// world
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glScalef(0.3F, 0.3F, 0.3F);
		GL11.glTranslatef(1.65F, 0.175F, 1.75F);
		GL11.glRotatef(15F, 0F, 1F, 0F);
		TileEntTest tile = (TileEntTest) tileEnt;
		//renderBlock(tile, tileEnt.getWorldObj(), tileEnt.xCoord,tileEnt.yCoord, tileEnt.zCoord, ModBlocks.damascus);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE1);
		renderBlock(tile, tileEnt.getWorld(), tileEnt.getPos().getX(), tileEnt.getPos().getY(), tileEnt.getPos().getZ(), ModBlocks.modBlockTileEntity);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({ "cast"})
	public void renderBlock(TileEntTest tl, World world, int i, int j,int k, Block block) {

		GL11.glPushMatrix();
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE1);
		this.model.renderAll();
		GL11.glPopMatrix();
	}

	/*@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		// TODO Auto-generated method stub
		
	}*/
		

}
