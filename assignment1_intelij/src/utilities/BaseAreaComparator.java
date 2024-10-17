package utilities;

import shapes.Shape3D;

import java.util.Comparator;

public class BaseAreaComparator implements Comparator<Shape3D> {
    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
    }
}