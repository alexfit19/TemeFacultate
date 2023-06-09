package isp.lab5.exercise4;

public class ShapeFactory extends AbstractShapeFactory {
     @Override
    Shape getShape(String type) {
        if ("rectangle".equals(type)) {
            return new Rectangle();
        }

        return null;
    }
}
