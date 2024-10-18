package utilities;

import shapes.Shape3D;

import java.util.Comparator;

/**
 * The VolumeComparator class is a comparator that compares two Shape3D objects based on their volumes.
 */
public class VolumeComparator implements Comparator<Shape3D> {

    /**
     * Compares two Shape3D objects based on their volumes.
     *
     * @param shape1
     * @param shape2
     * @return
     */
    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        return Double.compare(shape1.getVolume(), shape2.getVolume());
    }
}
