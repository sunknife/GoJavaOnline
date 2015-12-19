package FiguresArea;

public class FiguresArea {

    public double triangleArea(int height, int base) {
        double area = 1/2*height*base;
        return area;
    }

    public int rectanglArea(int length, int width) {
        int area = length*width;
        return area;
    }

    public double circleArea(int radius){
        double area = 3.14*radius*radius;
        return area;
    }
}
