package shapes;

/**
 * The TriangularPrism class is a subclass of Shape3D that represents a triangular prism.
 */
public class TriangularPrism extends Shape3D
{
    /**
     * The base of the triangular prism.
     */
    private double base;

    /**
     * The height of the base of the triangular prism.
     */
    private double heightOfBase;

    /**
     * Constructs a TriangularPrism object with the specified base, height of the base, and height.
     *
     * @param base
     * @param heightOfBase
     * @param height
     */
    public TriangularPrism(double base, double heightOfBase, double height) {
        super(height);
        this.base = base;
        this.heightOfBase = heightOfBase;
    }

    /**
     * Returns the base area of the triangular prism.
     *
     * @return
     */
    @Override
    public double getBaseArea() {
        return 0.5 * base * heightOfBase;
    }

    /**
     * Returns the volume of the triangular prism.
     *
     * @return
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
