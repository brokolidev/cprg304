package ProblemDomain;

import Enums.SoundRatingLevel;

public class Dishwasher extends Appliance {
    public String feature;
    public String soundRating;
    public SoundRatingLevel soundRatingLevel;

    public Dishwasher(Integer itemNumber, String brand, Integer quantity,
                      Integer wattage, String color, Double price,
                      String feature, String soundRating) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.feature = feature;
        this.soundRating = soundRating;
    }

    /**
     * Method to determine sound level
     */
    public SoundRatingLevel getSoundRatingLevel()
    {
        return switch (this.soundRating) {
            case "Qt" -> SoundRatingLevel.Qt;
            case "Qr" -> SoundRatingLevel.Qr;
            case "Qu" -> SoundRatingLevel.Qu;
            case "M" -> SoundRatingLevel.M;
            default -> SoundRatingLevel.Undefined;
        };
    }

    /**
     * Method to display sound level
     */
    public String displaySoundRating()
    {
        return switch (this.getSoundRatingLevel()) {
            case SoundRatingLevel.Qt -> "Quietest";
            case SoundRatingLevel.Qr -> "Quieter";
            case SoundRatingLevel.Qu -> "Quiet";
            case SoundRatingLevel.M -> "Moderate";
            default -> "Undefined";
        };
    }

    /**
     * Method to format the all properties for a file
     */
    @Override
    public String FormatForFile()
    {
        String commonFormatted = super.FormatForFile();

        return String.join(
                ";",
                commonFormatted,
                feature,
                soundRating
        );
    }

    // redefine the toString method
    @Override
    public String toString() {
        return "Dishwasher{" +
                "itemNumber=" + itemNumber +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", feature='" + feature + '\'' +
                ", soundRating='" + soundRating + '\'' +
                '}';
    }
}
