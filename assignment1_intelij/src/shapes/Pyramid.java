package shapes;

public class Pyramid extends Shape3D
{
    private double baseSideLength;

    public Pyramid(double baseSideLength, double height) {
        super(height);
        this.baseSideLength = baseSideLength;
    }

    // Formula for the area of a square base
    @Override
    public double getBaseArea() {
        return Math.pow(baseSideLength, 2);
    }

    // Volume of a pyramid = (1/3) * Base Area * Height
    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * height;
    }
}
