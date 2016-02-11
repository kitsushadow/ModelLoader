package com.nmd.forgecraft.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraftforge.fml.common.SidedProxy;

//import cpw.mods.fml.common.SidedProxy;


/**
 * Marks the associated element as being only available on a certain {@link Side}. This is
 * generally meant for internal Forge and FML use only and should only be used on mod classes
 * when other more common mechanisms, such as using a {@link SidedProxy} fail to work.
 *
 * Note, this will <em>only</em> apply to the direct element marked. This code:
 * <code> @SideOnly public MyField field = new MyField();</code> will <strong>not</strong> work, as the initializer
 * is a separate piece of code to the actual field declaration, and will not be able to find
 * it's field on the wrong side.
 *
 * @author cpw
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface SideOnly
{
    public Side value();
}