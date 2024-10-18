package utilities;

import shapes.Shape3D;

import java.util.Comparator;

/**
 * The BaseAreaComparator class is a comparator that compares two Shape3D objects based on their base areas.
 */
public class BaseAreaComparator implements Comparator<Shape3D> {
    /**
     * Compares two Shape3D objects based on their base areas.
     *
     * @param shape1
     * @param shape2
     * @return
     */
    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
    }
}