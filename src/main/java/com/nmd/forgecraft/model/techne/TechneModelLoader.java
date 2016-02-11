package com.nmd.forgecraft.model.techne;

import com.nmd.forgecraft.model.IModelCustom;
import com.nmd.forgecraft.model.IModelCustomLoader;
import com.nmd.forgecraft.model.ModelFormatException;

import net.minecraft.util.ResourceLocation;

public class TechneModelLoader implements IModelCustomLoader {
    
    @Override
    public String getType()
    {
        return "Techne model";
    }

    private static final String[] types = { "tcn" };
    @Override
    public String[] getSuffixes()
    {
        return types;
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
    {
        return new TechneModel(resource);
    }

}