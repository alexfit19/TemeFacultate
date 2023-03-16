package isp.lab5.exercise4;

public class Exercise4 {
     public static void main(String[] args) {
        AbstractShapeFactory roundedShapeFactory = ShapeFactoryProvider.getShapeFactory("rounded");
        AbstractShapeFactory normalShapeFactory = ShapeFactoryProvider.getShapeFactory("normal");

        // create instances
        Shape rectangle = roundedShapeFactory.getShape("roundedRectangle");
        Shape shape = normalShapeFactory.getShape("rectangle");
        Shape square = roundedShapeFactory.getShape("roundedSquare");
        Shape shape1 = normalShapeFactory.getShape("square");

        rectangle.draw();
        shape.draw();
        square.draw();
        shape1.draw();
    }
}
