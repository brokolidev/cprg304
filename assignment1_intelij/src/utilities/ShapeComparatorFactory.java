package utilities;

import shapes.Shape3D;

import java.util.Comparator;

public class ShapeComparatorFactory {
    public static Comparator<Shape3D> getComparator(String type) {
        switch (type) {
            case "v":
                return new VolumeComparator();
            case "a":
                return new BaseAreaComparator();
            case "h":
                // Default behavior: Compare by height using Comparable
                return Comparator.naturalOrder();
            default:
                throw new IllegalArgumentException("Invalid comparison type: " + type);
        }
    }
}
