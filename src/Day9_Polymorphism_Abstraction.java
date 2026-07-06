import java.util.Scanner;

interface Shape{
    double area();
    double perimeter();
}
class Circle implements Shape{
    double radius;

    Circle(double radius){
        this.radius=radius;
    }

    public double area(){
        return Math.PI*radius*radius;
    }
    public double perimeter(){
        return 2*Math.PI*radius;
    }
}
class Rectangle implements Shape{
    double length;
    double width;

   Rectangle(double length,double width){
       this.length=length;
       this.width=width;
   }

    public double area(){
        return length*width;
    }
    public double perimeter(){
        return 2*(length+width);
    }
}
class Triangle implements Shape{
    double side1;
    double side2;
    double side3;

    Triangle(double side1,double side2,double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double area() {

        double s = perimeter() / 2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}
public class Day9_Polymorphism_Abstraction {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");

        System.out.print("Enter your choice: ");
        int choice = in.nextInt();

        Shape shape;

        if(choice==1){
            System.out.println("Enter radius of a circle : ");
            double radius=in.nextDouble();

            shape=new Circle(radius);
        }else if(choice==2){
            System.out.println("Enter the length and width of the rectangle : ");
            double length=in.nextDouble();
            double width=in.nextDouble();

            shape=new Rectangle(length,width);
        }else{
            System.out.println("Enter the sides of triangle : ");
            double side1=in.nextDouble();
            double side2=in.nextDouble();
            double side3=in.nextDouble();

            shape=new Triangle(side1,side2,side3);
        }
        System.out.println("Area  is : " + shape.area());
        System.out.println("Perimeter  is : " + shape.perimeter());


    }
}
