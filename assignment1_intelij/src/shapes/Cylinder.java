package shapes;

/**
 * The Cylinder class is a subclass of Shape3D that represents a cylinder.
 */
public class Cylinder extends Shape3D
{
    /**
     * The radius of the cylinder.
     */
    private double radius;

    /**
     * Constructs a Cylinder object with the specified radius and height.
     *
     * @param radius
     * @param height
     */
    public Cylinder(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    /**
     * Returns the base area of the cylinder.
     * @return
     */
    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Returns the volume of the cylinder.
     * @return
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
