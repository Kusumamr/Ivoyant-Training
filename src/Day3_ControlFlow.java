import java.util.Scanner;

public class Day3_ControlFlow {
    public static void main(String[] args) {

        //if-else
        int age=20;

        if (age<18) {
            System.out.println("Not Eligible");
        }else{
            System.out.println("Eligible");
        }

        //if else ladder
        int score = 75;

        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 75) {
            System.out.println("Grade B");
        } else if (score >= 50) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }

        //switch
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid");
        }

        //for loop
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        //while loop
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        //do-while
        int j = 1;
        do {
            System.out.println(j);
            j++;
        } while (j <= 5);

        //enchanted for loop
        int[] arr = {10, 20, 30, 40};

        for (int n : arr) {
            System.out.println(n);
        }

        //break
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                break;
            }
            System.out.println(k);
        }

        //continue
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                continue;
            }
            System.out.println(k);
        }

        //pyramid pattern problem
        System.out.println("Pyramid Pattern");
        int p = 5;

        for (int q = 1; q <= p; q++) {
            for (int r = 1; r <= p - q; r++) {
                System.out.print(" ");
            }
            for (int r = 1; r <= (2 * q - 1); r++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //diamond pattern
        int x = 5;

        for (int y = 1; y <= x; y++) {
            for (int z = 1; z <= x - y; z++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= (2 * y - 1); z++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int y = x - 1; y >= 1; y--) {
            for (int z = 1; z <= x - y; z++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= (2 * y - 1); z++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //pascal triangle pattern
        int a = 5;

        for (int b = 0; b < a; b++) {
            for (int c = 1; c <= a - b; c++) {
                System.out.print(" ");
            }

            int val = 1;
            for (int c = 0; c <= b; c++) {
                System.out.print(val + " ");
                val = val * (b - c) / (c + 1);
            }
            System.out.println();
        }

        //fizzbuzz

        int max = 100;

        for (int num = 1; num <= max; num++) {
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (num % 3 == 0) {
                System.out.println("Fizz");
            } else if (num % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num);
            }
        }

        //ATM machine

        Scanner in=new Scanner(System.in);
        double balance=in.nextDouble();

        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        System.out.print("Enter Choice: ");
        int choice = in.nextInt();

        switch (choice){
            case 1:
                System.out.println("Your balance is : " + balance);
                break;

            case 2:
                System.out.println("Enter the deposit amount : ");
                double deposit=in.nextDouble();
                balance+=deposit;
                System.out.println("Balance amount is : " + balance);
                break;

            case 3:
                System.out.println("Enter the amount to withdraw : ");
                double withdraw=in.nextDouble();
                if(withdraw<=balance){
                    balance-=withdraw;
                    System.out.println("Balance amount is : " +  balance);
                }else{
                    System.out.println("Insufficient balance");
                }
                break;

            case 4:
                System.out.println("Thank you");
                break;

            default:
                System.out.println("Enter the valid input");
        }
    }
}
