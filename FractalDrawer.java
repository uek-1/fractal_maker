// FractalDrawer class draws a fractal of a shape indicated by user input
// Finished by Vivek Kethineni, kethi012
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
        System.out.println("Drawing " + type + " fractal. Make the window fullscreen and reset to original size if the fractal doesn't draw completely.");
        //For all fractals, the starting position is supposed to be somewhere around the center with slight alterations for aesthetic purposes.
        //This position was calculated using the dimensions of the starting shape and canvas, which is 800x800 by default.
        switch (type) {
            case "circle": {
                totalArea = 0;
                drawCircleFractal(100, 350, 350, Color.red, canvas, 0);
            }
            case "triangle": {
                totalArea = 0;
                drawTriangleFractal(200, 200, 300, 300, Color.green, canvas, 0);
            }
            case "rectangle": {
                totalArea = 0;
                drawRectangleFractal(200, 200, 300, 300, Color.red, canvas, 0);
            }
            default: {
                System.out.println("Invalid type! Try either circle, triangle, or rectangle.");
            }
        }
        return totalArea;
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color color, Canvas can, int level){ // ideally, returns double area of the fractal.
        if (level <= 7) {
            Random random = new Random();
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            //color is RGB a 3-tuple with each channel's value between 0 and 255. The line above generates a random 3-tuple RGB color.

            Triangle triangle = new Triangle(x, y, width, height);
            triangle.setColor(color);


            drawTriangleFractal(width/2, height/2, x+width, y+height/2, color, can, level+1); // triangle to the right and below
            drawTriangleFractal(width/2, height/2, x-width/2, y+height/2, color, can, level+1); // triangle to the left and below
            drawTriangleFractal(width/2, height/2, x+width/4, y+height/2, color, can, level+1); // triangle directly below
            can.drawShape(triangle); //Draw shape after recursive call to avoid overlapping
            totalArea = totalArea + triangle.calculateArea();
        }

    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color color, Canvas can, int level) {
        if(level <= 7) {
            Random random = new Random();
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

            Circle circle = new Circle(x, y, radius);
            circle.setColor(color);



            drawCircleFractal(radius / 2, x, y - radius - radius / 2, color, can, level + 1); //above
            drawCircleFractal(radius / 2, x, y + radius + radius/2, color, can, level + 1); //below
            drawCircleFractal(radius/2, x - radius - radius / 2, y, color, can, level + 1); // left
            drawCircleFractal(radius/2, x + radius + radius/2, y, color, can, level + 1); // right
            can.drawShape(circle); //Draw shape after recursive call to avoid overlapping
            totalArea = totalArea + circle.calculateArea();
        }
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color color, Canvas can, int level) {
            if (level <= 7) {
                Random random = new Random();
                color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                Rectangle rectangle = new Rectangle(x, y, width, height);
                rectangle.setColor(color);


                drawRectangleFractal(width/2, height/2, x + width, y + height, color, can, level + 1); //Bottom right
                drawRectangleFractal(width/2, height/2, x - width/2, y + height, color, can, level + 1); //Upper right
                drawRectangleFractal(width/2, height/2, x + width, y-height/2, color, can, level + 1); //Bottom left
                drawRectangleFractal(width/2, height/2, x - width/2, y - height/2, color, can, level + 1); //Upper left
                can.drawShape(rectangle); //Draw shape after recursive call to avoid overlapping
                totalArea = totalArea + rectangle.calculateArea();
            }

            }


    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        FractalDrawer fractalDrawer = new FractalDrawer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a shape:");
        String inputShape = scanner.nextLine();
        System.out.println("The total area is " + fractalDrawer.drawFractal(inputShape));

    }
}
