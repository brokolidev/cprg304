package shapes;

/**
 * The Pyramid class is a subclass of Shape3D that represents a pyramid.
 */
public class Pyramid extends Shape3D
{
    /**
     * The side length of the base of the pyramid.
     */
    private double baseSideLength;

    /**
     * Constructs a Pyramid object with the specified base side length and height.
     *
     * @param baseSideLength
     * @param height
     */
    public Pyramid(double baseSideLength, double height) {
        super(height);
        this.baseSideLength = baseSideLength;
    }

    /**
     * Returns the base area of the pyramid.
     *
     * @return
     */
    @Override
    public double getBaseArea() {
        return Math.pow(baseSideLength, 2);
    }

    /**
     * Returns the volume of the pyramid.
     *
     * @return
     */
    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * height;
    }
}
