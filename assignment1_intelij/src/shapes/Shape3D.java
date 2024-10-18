package shapes;

/**
 * The Shape3D class is an abstract class that represents a 3D shape.
 */
public abstract class Shape3D implements Comparable<Shape3D>
{
    /**
     * The height of the 3D shape.
     */
    protected double height;

    /**
     * Constructs a Shape3D object with the specified height.
     *
     * @param height
     */
    public Shape3D(double height) {
        this.height = height;
    }

    /**
     * Returns the height of the 3D shape.
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the volume of the 3D shape.
     *
     * @return
     */
    public abstract double getVolume();

    /**
     * Returns the base area of the 3D shape.
     *
     * @return
     */
    public abstract double getBaseArea();

    /**
     * Compares this 3D shape with the specified 3D shape based on height.
     *
     * @param otherShape
     * @return
     */
    @Override
    public int compareTo(Shape3D otherShape) {
        return Double.compare(this.height, otherShape.getHeight());
    }
}
