import java.util.*;

class Product{
   int id;
   String name;
   String sku;
   int quantity;

   Product(int id,String name,String sku,int quantity){
       this.id=id;
       this.name=name;
       this.sku=sku;
       this.quantity=quantity;
   }
}
public class Day15_Collections_List_Set_Queue {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<Product> stock=new ArrayList<>();
        HashSet<String> skuSet =new HashSet<>();
        PriorityQueue<Product> lowStock=new PriorityQueue<>((p1,p2)->p1.quantity-p2.quantity);

        System.out.println("Enter the number of products : ");
        int n=in.nextInt();

        for(int i=1;i<=n;i++){
            System.out.println("Enter Product " + i + "Details : ");

            System.out.println("Product Id : ");
            int Id=in.nextInt();

            System.out.println("Product Name : ");
            String Name=in.next();

            System.out.println("SKU : ");
            String sku=in.next();

            System.out.println("Quantity : ");
            int quantity=in.nextInt();

            if(skuSet.contains(sku)){
                System.out.println("Duplicate SKU , product added");
                continue;
            }

            Product p=new Product(Id,Name,sku,quantity);

            stock.add(p);
            skuSet.add(sku);
            if(quantity<5){
                lowStock.add(p);
            }
        }
        System.out.println("Ordered Stock");
        for(Product p:stock){
            System.out.println(p.id + "\n" + p.name + "\n" + p.sku + "\n" +p.quantity);
        }

        System.out.println("Unique SKU's");
        for (String s:skuSet){
            System.out.println(s);
        }

        System.out.println("Low stock alerts : ");
        while (!lowStock.isEmpty()){
            Product p=lowStock.poll();
            System.out.println(p.name + "Quantity : " + p.quantity);
        }
    }
}
