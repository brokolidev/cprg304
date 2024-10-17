package shapes;

public class TriangularPrism extends Shape3D
{
    private double base;
    private double heightOfBase;

    public TriangularPrism(double base, double heightOfBase, double height) {
        super(height);
        this.base = base;
        this.heightOfBase = heightOfBase;
    }

    // Area of a triangle base = 1/2 * base * heightOfBase
    @Override
    public double getBaseArea() {
        return 0.5 * base * heightOfBase;
    }

    // Volume of a triangular prism = Base Area * Height
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
