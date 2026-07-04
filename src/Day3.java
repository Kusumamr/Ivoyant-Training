public class Day3 {
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
    }
}
