package com.nmd.forgecraft.model.obj;

import com.nmd.forgecraft.model.IModelCustom;
import com.nmd.forgecraft.model.IModelCustomLoader;
import com.nmd.forgecraft.model.ModelFormatException;

import net.minecraft.util.ResourceLocation;

public class ObjModelLoader implements IModelCustomLoader
{

    @Override
    public String getType()
    {
        return "OBJ model";
    }

    private static final String[] types = { "obj" };
    @Override
    public String[] getSuffixes()
    {
        return types;
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
    {
        return new WavefrontObject(resource);
    }
}