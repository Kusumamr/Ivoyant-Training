import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Book{
    int bookId;
    String title;

    Book(int bookId,String title){
        this.bookId=bookId;
        this.title=title;
    }
}
class Member{
    int memberId;
    String name;

    Member(int memberId,String name){
        this.memberId=memberId;
        this.name=name;
    }
}
public class LibraryManagementSystem {
        static ArrayList<Book> books=new ArrayList<>();
        static ArrayList<Member> members=new ArrayList<>();

        static void loadBooks(){
            try(BufferedReader br=new BufferedReader(new FileReader("books.txt"))){
                String line;
                while((line=br.readLine())!=null){
                    String data[]=line.split(",");
                    books.add(new Book(Integer.parseInt(data[0]),data[1]));
                }
            }catch (IOException e){
                System.out.println("Book File not found");
            }
        }
    static void loadMembers(){
        try(BufferedReader br=new BufferedReader(new FileReader("members.txt"))){
            String line;
            while((line=br.readLine())!=null){
                String data[]=line.split(",");
                members.add(new Member(Integer.parseInt(data[0]),data[1]));
            }
        }catch (IOException e){
            System.out.println("Member File not found");
        }
    }
    static void saveBook(){
            try(BufferedWriter bw=new BufferedWriter(new FileWriter("books.txt"))){
                for(Book b:books){
                    bw.write(b.bookId + "," + b.title);
                    bw.newLine();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
    }
    static void saveMember(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("members.txt"))){
            for(Member m:members){
                bw.write(m.memberId + "," + m.name);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        loadBooks();
        loadMembers();

        while (true){
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Add Member");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            int choice=in.nextInt();
            in.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter book id : ");
                    int bookId=in.nextInt();
                    in.nextLine();
                    System.out.println("Enter the book title : ");
                    String title=in.nextLine();
                    books.add(new Book(bookId,title));
                    saveBook();
                    System.out.println("Book added");
                    break;

                case 2:
                    System.out.println("Enter the book id to search : ");
                    int searchId=in.nextInt();
                    boolean found=false;
                    for(Book b:books){
                        if(b.bookId==searchId){
                            System.out.println("Book Found");
                            System.out.println("ID : " + b.bookId);
                            System.out.println("Title : " + b.title);
                            found=true;
                        }
                    }
                    if(!found){
                        System.out.println("Book not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID : ");
                    int removeId = in.nextInt();
                    boolean removed = false;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).bookId == removeId) {
                            books.remove(i);
                            saveBook();
                            removed = true;
                            System.out.println("Book Removed.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Book Not Found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter member ID : ");
                    int memberId=in.nextInt();
                    in.nextLine();
                    System.out.println("Enter member name : ");
                    String name=in.nextLine();
                    members.add(new Member(memberId,name));
                    saveMember();
                    System.out.println("Member added");
                    break;

                case 5:
                    System.out.println("Thank you");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
