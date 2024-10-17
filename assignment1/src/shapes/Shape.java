public package shapes;

public abstract class ThreeDShape {
    protected VolumeStrategy volumeStrategy;

    // Constructor to accept a VolumeStrategy
    public ThreeDShape(VolumeStrategy volumeStrategy) {
        this.volumeStrategy = volumeStrategy;
    }

    // Method to set a different volume strategy at runtime
    public void setVolumeStrategy(VolumeStrategy volumeStrategy) {
        this.volumeStrategy = volumeStrategy;
    }

    // Abstract method for getting the name of the shape
    public abstract String getName();

    // Method to calculate volume using the current strategy
    public double calculateVolume() {
        return volumeStrategy.calculateVolume();
    }
}
