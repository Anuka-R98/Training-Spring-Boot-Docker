package Shapes;

class square extends shapes{

    private double side_length;

    public square(double side_length){
        super("Square");
        this.side_length = side_length;
    }
    @Override
    public double calArea() {
        return side_length * side_length;
    }

    @Override
    public double calPerimeter() {
        return  side_length * 4;
    }

    public void dispInfoSquare(){
        super.displayShapeInfo();
        System.out.println("  ");
        System.out.println("Properties :");
        System.out.println("Height :" + side_length);
        System.out.println("Width :" + side_length);
        System.out.println("  ");
        System.out.println("Area :" + calArea());
        System.out.println("Perimeter :" + calPerimeter());
    }

}
