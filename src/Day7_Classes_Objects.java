class Course{
    int courseId;
    String courseName;

    Course(){
        courseId=0;
        courseName="Not assigned";
    }
    Course(int courseId,String courseName){
        this.courseId=courseId;
        this.courseName=courseName;
    }
    @Override
    public String toString(){
        return "Course ID is " + courseId + "\n" + "Course Name is " + courseName;
    }
}
class Student{
    int studentId;
    String studentName;
    Course course;

    Student(){
        studentId=0;
        studentName="Not assigned";
    }
    Student(int studentId,String studentName){
        this.studentId=studentId;
        this.studentName=studentName;
    }
    Student(int studentId,String studentName,Course course){
        this.studentId=studentId;
        this.studentName=studentName;
        this.course=course;
    }
    @Override
    public String toString(){
        return "Student ID is " + studentId + "\n" + "Student name is " + studentName + "\n" + course;
    }

    @Override
    public boolean equals(Object obj){
        Student s =(Student) obj;

        if(this.studentId==s.studentId){
            return true;
        }else{
            return false;
        }
    }
}
public class Day7_Classes_Objects {
    public static void main(String[] args) {
       Course c1=new Course(101,"Java");
       Course c2=new Course(102,"Spring boot");

       Student s1=new Student(1,"Alice",c1);
       Student s2=new Student(2,"Bob",c2);
       Student s3=new Student(1,"Alice",c2);

        System.out.println("Student 1 : ");
        System.out.println(s1);

        System.out.println("Student 2 : ");
        System.out.println(s2);

        System.out.println("Student 3 : ");
        System.out.println(s3);

        System.out.println("Comparing students ");

        if(s1.equals(s3)){
            System.out.println("Both students are same");
        }else{
            System.out.println("Students are different");
        }
    }
}
