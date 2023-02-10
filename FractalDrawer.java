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
            drawTriangleFractal(200,200,0,200, Color.green, canvas, 0); //canvas is 800x800
        }
        else if (type.equals("rectangle")){
            drawRectangleFractal(80,80,360,360,Color.red,canvas,0);
        }
        else{
            System.out.println("Invalid type! Try either circle, triangle, or rectangle.");
        }
        return 0; // need to return area!
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color color, Canvas can, int level){ // ideally, returns double area of the fractal.
        if (level <= 7) {
            double scaleFactor = 1;
            if (level % 2 == 1){
                color = Color.red;
            }
            else {
                color = Color.green;
            }
            System.out.println(level + ":" + scaleFactor +" w:" + width);
            Triangle shapeTriangle1 = new Triangle(x, 200, width, height * Math.pow(-1, level));
            shapeTriangle1.setColor(color);

            Triangle shapeTriangle2 = new Triangle(0, y, width, height);
            shapeTriangle2.setColor(color);

            Triangle shapeTriangle3 = new Triangle(x, y, width, height * Math.pow(-1, level));
            shapeTriangle3.setColor(color);

            can.drawShape(shapeTriangle1);
            can.drawShape(shapeTriangle2);
            can.drawShape(shapeTriangle3);

            drawTriangleFractal(0.775304 *width, 0.775304 * height, x + width, y + 0.775304*height, color, can, level+1);
        }
        else {
            System.out.println("Exceeded recursion amount");
            return;
        }
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {

    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
            if (level <= 7) {
                if (level %2 == 1){
                    c = Color.black;
                }
                else {
                    c = Color.blue;
                }

                Rectangle rect = new Rectangle(x, y, width, height);
                rect.setColor(c);
                can.drawShape(rect);

                drawRectangleFractal(width * 0.8, height * 0.8, x + width, y + height, c, can, level + 1);
                drawRectangleFractal(width * 0.8, height * 0.8, x - width*0.8, y + height, c, can, level + 1);
                drawRectangleFractal(width * 0.8, height * 0.8, x + width, y - height, c, can, level + 1);
                drawRectangleFractal(width * 0.8, height * 0.8, x - width*0.8, y - height, c, can, level + 1);
            }
            else {
                System.out.println("Exceeded recursion amount");
                return;
            }
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
