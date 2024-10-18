package shapes;

/**
 * The OctagonalPrism class is a subclass of Shape3D that represents an octagonal prism.
 */
public class OctagonalPrism extends Shape3D
{
    /**
     * The side length of the octagonal prism.
     */
    private double sideLength;

    /**
     * Constructs an OctagonalPrism object with the specified side length and height.
     *
     * @param sideLength
     * @param height
     */
    public OctagonalPrism(double sideLength, double height) {
        super(height);
        this.sideLength = sideLength;
    }

    /**
     * Returns the base area of the octagonal prism.
     *
     * @return
     */
    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(sideLength, 2);
    }

    /**
     * Returns the volume of the octagonal prism.
     *
     * @return
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
