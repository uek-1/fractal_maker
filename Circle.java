import java.awt.Color;
public class Circle {
    double x;
    double y;
    double radius;
    Color color;
    public Circle (double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double calculateArea(){
        return Math.PI * Math.pow(radius,2);
    }

    public void setColor(Color inputColor){
        color = inputColor;
    }

    public void setPo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRadius(double radius){
        this.radius = radius;
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
    public double getRadius(){
        return radius;
    }
}
