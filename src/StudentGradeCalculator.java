import java.util.Scanner;

public class StudentGradeCalculator {
    static String grade(int marks){
        if(marks>90){
            return "A";
        }else if(marks<90 && marks>70){
            return "B";
        }else if(marks<70 && marks>50){
            return "C";
        }else{
            return "D";
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of students : ");
        int n=in.nextInt();
        in.nextLine();
        String[] names=new String[n];
        int[] marks=new int[n];
        int total=0;
        double average=0.0;

        for(int i=0;i<n;i++){
            System.out.println("Enter the student name : ");
            names[i]=in.nextLine();
            System.out.println("Enter the marks : ");
            marks[i]=in.nextInt();
            in.nextLine();

            total+=marks[i];
        }
        System.out.println();
        System.out.println("Student Details : ");
        for(int i=0;i<n;i++){
            System.out.println("Names : " + names[i]);
            System.out.println("Marks : " + marks[i]);
            System.out.println("Grade : " + grade(marks[i]));
            System.out.println();
        }
        average=(double)total/n;
        System.out.println("Class average is : " + average);

        int highest=marks[0];
        int lowest=marks[0];

        String highestStudent=names[0];
        String lowestStudent=names[0];

        for(int i=1;i<n;i++){
            if(marks[i]>highest){
                highest=marks[i];
                highestStudent=names[i];
            }
            if(marks[i]<lowest){
                lowest=marks[i];
                lowestStudent=names[i];
            }
        }
        System.out.println();
        System.out.println("Highest Scorer : " + highestStudent + "-" + highest);
        System.out.println("Lowest Scorer : " + lowestStudent + "-" + lowest);

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (marks[i] < marks[j]) {

                    int tempMarks = marks[i];
                    marks[i] = marks[j];
                    marks[j] = tempMarks;

                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                }

            }

        }
        System.out.println("Rank List : ");
        for(int i=0;i<n;i++){
            System.out.println(names[i] + "-" + marks[i]);
        }
    }
}
