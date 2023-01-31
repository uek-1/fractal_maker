import java.awt.Color;
public class Triangle {
    double x;
    double y;
    double width;
    double height;
    double diagonalLength = Math.sqrt(Math.pow((width/2),2) + Math.pow(height,2));
    Color color;
    public Triangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //x,y refers to the bottom left of the isoscles triangle being created
    }

    public double calculatePerimeter(){
        return 2 * diagonalLength + width;
    }

    public double calculateArea() {
        return width * height / 2;
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

    public void setWidth(double width) {
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
