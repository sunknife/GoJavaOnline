package FiguresArea;

public class FiguresArea {

    public double triangleArea(int height, int base) {
        return 0.5 * height * base;
    }

    public int rectanglArea(int length, int width) {
        return length * width;
    }

    public double circleArea(int radius) {
        return Math.PI * radius * radius;
    }
    // 3.14 can be changed to Math.PI as more accurate value
}
