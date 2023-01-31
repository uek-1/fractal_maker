// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas canvas = new Canvas();
        System.out.println("type" + type);
        if (type.equals("circle")) {
            drawCircleFractal(100,0,0,Color.decode("red"),canvas,0);
        }
        else if (type.equals("triangle")){
            drawTriangleFractal(100,100,400,-400, Color.RED, canvas, 0);
        }
        else if (type.equals("rectangle")){
            drawRectangleFractal(100,100,0,0,Color.decode("red"),canvas,0);
        }
        else{
            System.out.println("Invalid type! Try either circle, triangle, or rectangle.");
        }
        return 0; // need to return area!
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if (level <= 7) {
            Triangle shapeTriangle = new Triangle(width, height, x, y);
            can.drawShape(shapeTriangle);
            drawTriangleFractal(width, height, x + 150, y + 150, c, can, level+1);
        }
        else {
            System.out.println("Exceeded recursion amount");
        }
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        FractalDrawer fd = new FractalDrawer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a shape:");
        String inputShape = scanner.nextLine();
        System.out.println(fd.drawFractal(inputShape));

    }
}
