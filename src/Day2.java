import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        //Primitive Data types
        byte exm1=90;
        short exm2=128;
        int exm3=10;
        long exm4=98987l;

        float exm5=7.8f;
        double exm6=89.98;

        char ch='a';
        boolean value=false;

        //Arithmetic operators
        int val1=10;
        int val2=20;

        int add=val1+val2;
        System.out.println(add);

        int sub=val2-val1;
        System.out.println(sub);

        int mul=val1*val2;
        System.out.println(mul);

        int div=val2/val1;
        System.out.println(div);

        int mod=val1%val2;
        System.out.println(mod);

        //logical operator
        boolean active = true;
        boolean inactive = false;
        boolean ans = active && inactive;
        System.out.println(ans);

        //bitwise operator
        int num1 = 12;
        int num2 = 10;
        int bitwiseResult = num1 & num2;
        System.out.println(bitwiseResult);

        //assignment operator
        int num=10;
        System.out.println(num+=10);
        System.out.println(num-=10);
        System.out.println(num*=10);
        System.out.println(num/=10);
        System.out.println(num%=10);

        //operator precedence
        int a=10;
        System.out.println(++a);
        System.out.println(a++);
        System.out.println(--a);
        System.out.println(a--);

        //type casting
        int p=10;
        long q=p;
        System.out.println(q);

        long x=98988;
        int y=(int)x;
        System.out.println(y);

        //simple km to miles ,°C to °F program
        Scanner in=new Scanner(System.in);
        System.out.println("1. Km to Miles");
        System.out.println("2. Miles to Km");
        System.out.println("3. Celsius to Fahrenheit");
        System.out.println("4. Fahrenheit to Celsius");

        int choice=in.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the kilometers");
                double km1=in.nextDouble();
                double m1=km1 * 0.621371;
                System.out.println(m1);
                break;

            case 2:
                System.out.println("Enter the miles");
                double m2=in.nextDouble();
                double k2=m2 * 1.60934;
                System.out.println(k2);
                break;

            case 3:
                System.out.println("Enter the Celsius");
                double c1=in.nextDouble();
                double f1=((c1 * 9 / 5) + 32);
                System.out.println(f1);
                break;

            case 4:
                System.out.println("Enter the Fahrenheit");
                double f2=in.nextDouble();
                double c2=((f2 - 32) * 5 / 9);
                System.out.println(c2);
                break;

            default:
                System.out.println("Invalid input ");
        }

    }
}
