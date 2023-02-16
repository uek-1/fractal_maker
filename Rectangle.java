//Written by Vivek Kethineni, kethi012
import java.awt.Color;
public class Rectangle {
    double x;
    double y;
    double width;
    double height;
    Color color;
    public Rectangle(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        //x and y coordinates refer to the location of the top left corner of the rectangle
        this.width = width;
        this.height = height;
    }
    public double calculatePerimeter(){
        return 2*width + 2*height;
    }
    public double calculateArea(){
        return width*height;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setPos(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public Color getColor(){
        return color;
    }
    public double getXPos(){
        return x;
    }
    public double getYPos(){
        return y;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
}
