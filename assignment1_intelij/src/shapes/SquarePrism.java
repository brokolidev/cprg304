package shapes;

public class SquarePrism extends Shape3D
{
    private double sideLength;

    public SquarePrism(double sideLength, double height) {
        super(height);
        this.sideLength = sideLength;
    }

    // Area of the square base
    @Override
    public double getBaseArea() {
        return Math.pow(sideLength, 2);
    }

    // Volume of a square prism = Base Area * Height
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
