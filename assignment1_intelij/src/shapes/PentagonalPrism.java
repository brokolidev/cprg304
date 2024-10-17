package shapes;

public class PentagonalPrism extends Shape3D
{
    private double sideLength;

    public PentagonalPrism(double sideLength, double height) {
        super(height);
        this.sideLength = sideLength;
    }

    // Formula for the area of a regular pentagon's base
    @Override
    public double getBaseArea() {
        return (5.0 / 4.0) * Math.pow(sideLength, 2) * (1.0 / Math.tan(Math.PI / 5));
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

}
