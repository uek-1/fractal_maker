// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Random;
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
            totalArea = 0;
            drawCircleFractal(100,350,350,Color.red,canvas,0);
        }
        else if (type.equals("triangle")){
            totalArea = 0;
            drawTriangleFractal(200,200,300,300, Color.green, canvas, 0); //canvas is 800x800
        }
        else if (type.equals("rectangle")){
            totalArea = 0;
            drawRectangleFractal(200,200,300,300,Color.red,canvas,0);
        }
        else{
            System.out.println("Invalid type! Try either circle, triangle, or rectangle.");
        }
        return totalArea; // need to return area!
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color color, Canvas can, int level){ // ideally, returns double area of the fractal.
        if (level <= 7) {
            double scaleFactor = 1;
            Random random = new Random();
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

            Triangle triangle = new Triangle(x, y, width, height);
            triangle.setColor(color);


            drawTriangleFractal(width/2, height/2, x+width, y+height/2, color, can, level+1);
            drawTriangleFractal(width/2, height/2, x-width/2, y+height/2, color, can, level+1);
            drawTriangleFractal(width/2, height/2, x+width/4, y+height/2, color, can, level+1);
            can.drawShape(triangle);
            totalArea = totalArea + triangle.calculateArea();
        }

    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if(level <= 7) {
            Random random = new Random();
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

            Circle circle = new Circle(x, y, radius);
            circle.setColor(color);



            drawCircleFractal(radius / 2, x, y - radius - radius / 2, color, can, level + 1); // above solve x + new radius + y= x + old radius => y = old radius - e
            drawCircleFractal(radius / 2, x, y + radius + radius/2, color, can, level + 1);
            drawCircleFractal(radius/2, x - radius - radius / 2, y, color, can, level + 1); // left
            drawCircleFractal(radius/2, x + radius + radius/2, y, color, can, level + 1); // right
            can.drawShape(circle);
            totalArea = totalArea + circle.calculateArea();
        }
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
            if (level <= 7) {
                Random random = new Random();
                Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                Rectangle rect = new Rectangle(x, y, width, height);
                rect.setColor(color);


                drawRectangleFractal(width/2, height/2, x + width, y + height, c, can, level + 1); //BR
                drawRectangleFractal(width/2, height/2, x - width/2, y + height, c, can, level + 1); //UR
                drawRectangleFractal(width/2, height/2, x + width, y-height/2, c, can, level + 1); //BL
                drawRectangleFractal(width/2, height/2, x - width/2, y - height/2, c, can, level + 1); //UL
                can.drawShape(rect);
                totalArea = totalArea + rect.calculateArea();
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
        System.out.println("The total area is " + fd.drawFractal(inputShape));

    }
}
