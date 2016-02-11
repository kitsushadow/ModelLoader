package com.nmd.forgecraft.model.obj;

//import net.minecraft.client.renderer.Tessellator;
import com.nmd.forgecraft.util.Tessellator;
import com.nmd.forgecraft.util.Vec3;
import com.nmd.forgecraft.util.Vertex;

//import net.minecraftforge.client.model.obj.OBJModel.TextureCoordinate;
import com.nmd.forgecraft.model.obj.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Face
{
    public Vertex[] vertices;
    public Vertex[] vertexNormals;
    public Vertex faceNormal;
    public com.nmd.forgecraft.model.obj.TextureCoordinate[] textureCoordinates;

    @SideOnly(Side.CLIENT)
    public void addFaceForRender(Tessellator tessellator)
    {
        addFaceForRender(tessellator, 0.0005F);
    }

    @SideOnly(Side.CLIENT)
    public void addFaceForRender(Tessellator tessellator, float textureOffset)
    {
        if (faceNormal == null)
        {
            faceNormal = this.calculateFaceNormal();
        }

        //tessellator.setNormal(faceNormal.x, faceNormal.y, faceNormal.z);
        tessellator.setNormal(faceNormal.x, faceNormal.y, faceNormal.z);
        //tessellator.setNormal(faceNormal., p_78375_2_, p_78375_3_);

        float averageU = 0F;
        float averageV = 0F;

        if ((textureCoordinates != null) && (textureCoordinates.length > 0))
        {
            for (int i = 0; i < textureCoordinates.length; ++i)
            {
                averageU += textureCoordinates[i].u;
                averageV += textureCoordinates[i].v;
            }

            averageU = averageU / textureCoordinates.length;
            averageV = averageV / textureCoordinates.length;
        }

        float offsetU, offsetV;

        for (int i = 0; i < vertices.length; ++i)
        {

            if ((textureCoordinates != null) && (textureCoordinates.length > 0))
            {
                offsetU = textureOffset;
                offsetV = textureOffset;

                if (textureCoordinates[i].u > averageU)
                {
                    offsetU = -offsetU;
                }
                if (textureCoordinates[i].v > averageV)
                {
                    offsetV = -offsetV;
                }

                tessellator.addVertexWithUV(vertices[i].x, vertices[i].y, vertices[i].z, textureCoordinates[i].u + offsetU, textureCoordinates[i].v + offsetV);
            }
            else
            {
                tessellator.addVertex(vertices[i].x, vertices[i].y, vertices[i].z);
            }
        }
    }
    
    public Vertex calculateFaceNormal()
    {
        Vec3 v1 = Vec3.createVectorHelper(vertices[1].x - vertices[0].x, vertices[1].y - vertices[0].y, vertices[1].z - vertices[0].z);
        Vec3 v2 = Vec3.createVectorHelper(vertices[2].x - vertices[0].x, vertices[2].y - vertices[0].y, vertices[2].z - vertices[0].z);
        Vec3 normalVector = null;

        normalVector = v1.crossProduct(v2).normalize();

        return new Vertex((float) normalVector.xCoord, (float) normalVector.yCoord, (float) normalVector.zCoord);
    }
}