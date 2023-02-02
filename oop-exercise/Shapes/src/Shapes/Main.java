package Shapes;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Select a shape: 1 for Square, 2 for Rectangle, 3 for Circle");
        int choice = scan.nextInt();

        switch (choice) {
            // Square
            case 1:
                System.out.println("Enter the side length of the square: ");
                double side = scan.nextDouble();
                square Square = new square(side);
                Square.dispInfoSquare();
                break;
            // Rectangle
            case 2:
                System.out.println("Enter the Height of the Rectangle: ");
                double height = scan.nextDouble();
                System.out.println("Enter the Width of the Rectangle: ");
                double width = scan.nextDouble();
                rectangle Rectangle = new rectangle(width, height);
                Rectangle.dispInfoRect();
                break;
            // Circle
            case 3:
                System.out.println("Enter the Radius of the Circle: ");
                double radius = scan.nextDouble();
                circle Circle = new circle(radius);
                Circle.dispInfoCir();
                break;

                default:
                System.out.println("Invalid selection.");
                break;
        }

    }
}