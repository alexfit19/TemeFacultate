package isp.lab5.exercise4;

public class RoundedShapeFactory extends AbstractShapeFactory {
     @Override
    Shape getShape(String type) {
        if ("roundedRectangle".equals(type)) {
            return new RoundedRectangle();
        }

        return null;
    }
}
