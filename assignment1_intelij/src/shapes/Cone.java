package shapes;

// this class is a subclass of the Shape class
public class Cone extends Shape3D
{
    private double radius;

    public Cone(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * getBaseArea() * height;
    }
}
