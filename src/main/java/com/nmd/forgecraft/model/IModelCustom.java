package com.nmd.forgecraft.model;

import static com.nmd.forgecraft.model.Side.CLIENT;
import com.nmd.forgecraft.model.SideOnly;

public interface IModelCustom
{
    String getType();
    @SideOnly(CLIENT)
    void renderAll();
    @SideOnly(CLIENT)
    void renderOnly(String... groupNames);
    @SideOnly(CLIENT)
    void renderPart(String partName);
    @SideOnly(CLIENT)
    void renderAllExcept(String... excludedGroupNames);
}