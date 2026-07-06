import java.util.Arrays;
import java.util.Scanner;

public class Day4_Methods_Arrays_Strings {
    //void type method
    void display(){
        System.out.println("Inside a void method");
    }

    //return type method
    int add2(int a, int b){
         return a+b;
    }

    int add3(int a,int b,int c){
        return a+b+c;
    }

    public static void main(String[] args) {

        {
            //local variables
            int num1=10;
            int num2=20;

            int ans=num1*num2;
            System.out.println(num1 + " " + num2 + " " + ans);
        }


        Day4_Methods_Arrays_Strings obj=new Day4_Methods_Arrays_Strings();



        obj.display();

        //method overloading
        System.out.println(obj.add2(2,3));
        System.out.println(obj.add3(2,4,6));

        //arrays
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

        //sorting an array
        Arrays.sort(arr);
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

        //2D array
        int a=in.nextInt();
        int b=in.nextInt();
        int[][] matrix=new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //strings
        String str = "Java Programming";

        System.out.println(str.length());
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.substring(5));
        System.out.println(str.contains("Java"));
        System.out.println(str.replace("Java", "Spring"));

        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Backend");
        System.out.println(sb);

        StringBuffer sf = new StringBuffer("Spring");
        sf.append(" Boot");
        System.out.println(sf);


        //reverse array
        System.out.println("Reverse Array");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //find duplicate elements
        int[] duplicateArray = {10, 20, 30, 20, 40, 10, 50};

        System.out.println("Duplicate Elements");
        for (int i = 0; i < duplicateArray.length; i++) {
            for (int j = i + 1; j < duplicateArray.length; j++) {
                if (duplicateArray[i] == duplicateArray[j]) {
                    System.out.println(duplicateArray[i]);
                }
            }
        }

        //matrix multiplication
        int[][] first = {
                {1, 2},
                {3, 4}
        };

        int[][] second = {
                {5, 6},
                {7, 8}
        };

        int[][] result = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        System.out.println("Matrix Multiplication");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        //palindrome
        String word = "madam";
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

        if (word.equals(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        //anagram checker
        String s1 = "listen";
        String s2 = "silent";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        if (Arrays.equals(c1, c2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }

        //word count
        String sentence = "Java is easy to learn";

        String[] words = sentence.split(" ");

        System.out.println("Word Count = " + words.length);

    }

}
