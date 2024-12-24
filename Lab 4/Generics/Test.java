package Generics;
import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void showShapesChilds(List <? extends Shape>rects, List <? extends Shape>circles){
        System.out.println("Showing Rectangles: ");
        for (Shape rect : rects) {
            rect.draw();
        }

        System.out.println("Showing Circles: ");
        for (Shape circle : circles) {
            circle.draw();
        }
    }
    public static void main(String[] args) {
        List<Rectangle>rectangles = new ArrayList<Rectangle>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        List<Circle>circles = new ArrayList<Circle>();
        circles.add(new Circle());
        circles.add(new Circle());


        showShapesChilds(rectangles,circles);

    }
}

