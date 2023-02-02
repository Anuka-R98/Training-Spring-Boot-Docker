package Shapes;

public class rectangle extends shapes{
    private double width;
    private double height;

    public rectangle(double width, double height){
        super("Rectangle");
        this.width = width;
        this.height = height;
    };

    @Override
    public double calArea() {
        return  width * height;
    }

    @Override
    public double calPerimeter() {
        return (width + height) * 2.0;
    }

    public void dispInfoRect(){
        super.displayShapeInfo();
        System.out.println("  ");
        System.out.println("Properties :");
        System.out.println("Height :" + height);
        System.out.println("Width :" + width);
        System.out.println("  ");
        System.out.println("Area :" + calArea());
        System.out.println("Perimeter :" + calPerimeter());
    }
}
