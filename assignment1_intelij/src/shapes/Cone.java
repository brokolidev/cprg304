package shapes;

/**
 * The Cone class is a subclass of Shape3D that represents a cone.
 */
public class Cone extends Shape3D
{
    /**
     * The radius of the cone.
     */
    private double radius;

    /**
     * Constructs a Cone object with the specified radius and height.
     *
     * @param radius
     * @param height
     */
    public Cone(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    /**
     * Returns the base area of the cone.
     *
     * @return
     */
    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Returns the volume of the cone.
     *
     * @return
     */
    @Override
    public double getVolume() {
        return (1.0 / 3) * getBaseArea() * height;
    }
}
