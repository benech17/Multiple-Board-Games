package model.core.enums;


public enum Color {
    RED (204, 0, 0),
    GREEN (0, 204, 0),
    BLUE (0, 0, 204),
    ORANGE (255, 128, 0),
    YELLOW (255, 255, 0);

    private final int red, green, blue;

    Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getRGB() {
        return red + ", " + green + ", " + blue;
    }

    @Override
    public String toString() {
        return "Color{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
