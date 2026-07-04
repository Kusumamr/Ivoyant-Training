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

    }
}
