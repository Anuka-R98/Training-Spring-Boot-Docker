package Shapes;

public class circle extends shapes{

    private double radius;

    public circle(double radius){
        super("Circle");
        this.radius = radius;
    }
    @Override
    public double calArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    public void dispInfoCir(){
        super.displayShapeInfo();
        System.out.println("  ");
        System.out.println("Properties :");
        System.out.println("Radius :" + radius);
        System.out.println("  ");
        System.out.println("Area :" + calArea());
        System.out.println("Perimeter :" + calPerimeter());
    }
}
