package shapes;

/**
 * The PentagonalPrism class is a subclass of Shape3D that represents a pentagonal prism.
 */
public class PentagonalPrism extends Shape3D
{
    /**
     * The side length of the pentagonal prism.
     */
    private double sideLength;

    /**
     * Constructs a PentagonalPrism object with the specified side length and height.
     *
     * @param sideLength
     * @param height
     */
    public PentagonalPrism(double sideLength, double height) {
        super(height);
        this.sideLength = sideLength;
    }

    /**
     * Returns the base area of the pentagonal prism.
     *
     * @return
     */
    @Override
    public double getBaseArea() {
        return (5.0 / 4.0) * Math.pow(sideLength, 2) * (1.0 / Math.tan(Math.PI / 5));
    }

    /**
     * Returns the volume of the pentagonal prism.
     *
     * @return
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

}
