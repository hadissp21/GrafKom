package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import  java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Rectangle extends Object2d{
    List<Integer> index;
    int ibo;
    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index){
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void draw(){
        drawSetup();
        // Draw the vertices
        //Bind IBO & draw
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
        //Optional
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // besar kecil vertex
        //Wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }
}
