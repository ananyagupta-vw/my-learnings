package LLD.L7_factory_design_pattern;
// Factory design pattern is a creational design pattern that controls the creation of objects without exposing the instantiation logic to the client.
// The object creation logic is encapsulated in a separate factory class,
// which is responsible for creating objects based on the provided input or configuration.

public class Factory {
    public static void main(String[] args) {
        Shape circleShapeObj = ShapeFactoryMethod.createShapeFactory("circle").createShape();
        circleShapeObj.draw();

        Shape squareShapeObj = ShapeFactoryMethod.createShapeFactory("square").createShape();
        squareShapeObj.draw();

    }
}

interface ShapeFactory {
    Shape createShape();
}

class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}

class ShapeFactoryMethod {
    public static ShapeFactory createShapeFactory(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new CircleFactory();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new SquareFactory();
        }
        throw new IllegalArgumentException("Unknown shape type: " + shapeType);
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}