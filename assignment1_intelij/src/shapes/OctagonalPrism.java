package shapes;

public class OctagonalPrism extends Shape3D
{
    private double sideLength;

    public OctagonalPrism(double sideLength, double height) {
        super(height);
        this.sideLength = sideLength;
    }

    // Formula for the area of a regular octagon's base
    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(sideLength, 2);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
