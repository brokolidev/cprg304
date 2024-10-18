package shapes;

/**
 * The SquarePrism class is a subclass of Shape3D that represents a square prism.
 */
public class SquarePrism extends Shape3D
{
    /**
     * The side length of the square prism.
     */
    private double sideLength;

    /**
     * Constructs a SquarePrism object with the specified side length and height.
     *
     * @param sideLength
     * @param height
     */
    public SquarePrism(double sideLength, double height) {
        super(height);
        this.sideLength = sideLength;
    }

    /**
     * Returns the base area of the square prism.
     *
     * @return
     */
    @Override
    public double getBaseArea() {
        return Math.pow(sideLength, 2);
    }

    /**
     * Returns the volume of the square prism.
     *
     * @return
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
