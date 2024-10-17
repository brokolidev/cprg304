package shapes;

public class Cylinder extends Shape3D
{
    private double radius;

    public Cylinder(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
