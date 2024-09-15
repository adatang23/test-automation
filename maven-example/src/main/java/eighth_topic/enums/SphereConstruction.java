package eighth_topic.enums;

public enum SphereConstruction {
    MERCURY_CONSTRUCTION (3.303e+7, 2.4397e1),
    VENUS_CONSTRUCTION   (4.869e+8, 6.0518e1),
    EARTH_CONSTRUCTION   (5.976e+8, 6.37814e1),
    MARS_CONSTRUCTION    (6.421e+7, 3.3972e1),
    JUPITER_CONSTRUCTION (1.9e+11,   7.1492e2),
    SATURN_CONSTRUCTION  (5.688e+10, 6.0268e2),
    URANUS_CONSTRUCTION  (8.686e+9, 2.5559e2),
    NEPTUNE_CONSTRUCTION (1.024e+10, 2.4746e2);

    private final double price;   // in dollars
    private final double radius; // in meters
    final double PI = 3.14159;

    SphereConstruction(double price, double radius) {
        this.price = price;
        this.radius = radius;
    }

    public double getPrice() {
        return price;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateUnitPrice() {
        double volume = (4/3.0) * PI * Math.pow(radius, 3);
        double unitPrice = price/volume;
        return unitPrice;
    }
}
