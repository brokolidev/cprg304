package utilities;

import shapes.Shape3D;

import java.util.Comparator;

/**
 * The ShapeComparatorFactory class is a factory class that creates comparators for Shape3D objects.
 */
public class ShapeComparatorFactory {
    /**
     * Returns a comparator for Shape3D objects based on the specified type.
     *
     * @param type
     * @return
     */
    public static Comparator<Shape3D> getComparator(String type) {
        switch (type) {
            case "v":
                return new VolumeComparator();
            case "a":
                return new BaseAreaComparator();
            case "h":
                return null;
            default:
                throw new IllegalArgumentException("Invalid comparison type: " + type);
        }
    }
}
