package shapes;

public abstract class Shape3D implements Comparable<Shape3D>{
    protected double height;

    public Shape3D(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double getVolume();
    public abstract double getBaseArea();

    // Implement Comparable to compare by height
    @Override
    public int compareTo(Shape3D otherShape) {
        return Double.compare(this.height, otherShape.getHeight());
    }
}
