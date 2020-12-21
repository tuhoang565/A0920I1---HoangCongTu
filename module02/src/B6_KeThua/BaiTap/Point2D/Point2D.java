package B6_KeThua.BaiTap.Point2D;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Point2D {
    private float x, y;

    public Point2D() {
        this(0.0f, 0.0f);
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] arrXY = {this.x, this.y};
        return arrXY;
    }

    @Override
    public String toString(){
         return "Point2D x: " + getX() + " y: " + getY();
    }
}
