import java.util.Scanner;

class Employee{
    int empId;
    String empName;
    public void setEmpId(int empId){
        this.empId=empId;
    }
    public void setEmpName(String empName){
        this.empName=empName;
    }

    public int getEmpId(){
        return empId;
    }
    public String getEmpName(){
        return empName;
    }

    public void display(){
        System.out.println("Employee ID is : " + empId);
        System.out.println("Employee Name is : " + empName);
    }
}
class Manager extends Employee{
    String Department;

    public void setDepartment(String Department){
        this.Department=Department;
    }

    public String getDepartment(){
        return Department;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Department is : " + Department);
    }
}
class Director extends Manager{
    String company;

    public void setCompany(String company){
        this.company=company;
    }
    public String getCompany(){
        return company;
    }

    public void display(){
        super.display();
        System.out.println("Company is : " + company);
    }
}
public class Day8_Encapsulation_Inheritance{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        Director d=new Director();

        System.out.println("Enter the employee ID : ");
        d.setEmpId(in.nextInt());
        in.nextLine();
        System.out.println("Enter the employee Name : ");
        d.setEmpName(in.next());
        System.out.println("Enter the department : ");
        d.setDepartment(in.next());
        System.out.println("Enter the company : ");
        d.setCompany(in.next());

        System.out.println("Details : ");
        d.display();

    }
}
