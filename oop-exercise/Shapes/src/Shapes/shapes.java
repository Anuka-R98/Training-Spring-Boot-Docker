package Shapes;

abstract class shapes {
    protected String name;
//    protected double area;
//    protected double Perimeter;

    // function that will be implemented in child classes
    abstract public double calArea();
    abstract public double calPerimeter();

    //object initializing to default values
    public shapes(){
        this.name = "Unknown Shapes";
//        this.area = 0;
//        this.Perimeter =0;
    }
    // passing object values
    public shapes(String name){
        this.name = name;
//        this.area = area;
//        this.parameter = parameter;
    }
    // display object values
    public void displayShapeInfo(){

        System.out.println("Shape :" + this.name);
//        System.out.println("Area :" + this.area);
//        System.out.println("Area :" + this.Perimeter);
    }

}
