import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javax.xml.transform.Source;

class Product implements Serializable{

    int productId,quantity;
    String name;
    double price;

    public Product(int id,int quan,String n,double p){
        productId = id;
        quantity = quan;
        name = n;
        price = p;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return false;
    }


}


class Customer implements Serializable{
    static String ids = "C001";
    String id,name; Product productDetails;
        public static String incrementId(String id) {
        String numericPart = id.substring(1); // Assuming the numeric part starts from index 1
        int numericValue = Integer.parseInt(numericPart);
        int nextNumericValue = numericValue + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return id.substring(0, 1) + nextNumericPart;
    }

    public Customer(String name,Product p){
        this.name = name;
        this.productDetails = p;
        String t = incrementId(ids);
        ids = t;
        this.id =t;
        
    }

    void buyProduct(int id,int quan,String name,double p){
        Product pro = new Product(id, quan, name, p);
    }

}

public class ProductClass{

    static void addProduct(){
        Product p[] = new Product[5];
        p[0]=new Product(1, 5, "Shampoo", 190.00);
        p[1]=new Product(2, 6, "Soap", 180.00);
        p[2]=new Product(3, 10, "Spray", 170.00);
        p[3]=new Product(4, 15, "Brush", 140.00);
        p[4]=new Product(5, 19, "Paste", 160.00);
        try{
            FileOutputStream ofs = new FileOutputStream("./product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(ofs);
            oos.writeObject(p);
            oos.close();

        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }

       
    }

    static Product[] takeOutProduct(){
        Product[] pdash = null;
         try{
            FileInputStream fis = new FileInputStream("./product.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            pdash = (Product[])ois.readObject();
            ois.close();
            return pdash;

        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
        return pdash;

        }
    
    }
    public static void main(String args[]){
        addProduct();
        Product parr[] = takeOutProduct();
        
        System.out.println("**********Product List*************");
        for(int i=0;i<parr.length;i++){
            System.out.println("Name: "+parr[i].name+"  "+"id: "+parr[i].productId+"  "+"Price: "+parr[i].price+"  "+"Quantity: "+parr[i].quantity);
            System.out.println();
        }
        System.out.println();
        System.out.println();

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n=1;
            try{      
            while (n == 1) {  
                System.out.println("Enter 1 to place order and 0 for exit : ");
                System.out.println();
                n = sc.nextInt();
                System.out.println("Entered = "+n);
                if(n==0){
                    break;
                }

                System.out.println("******* Place Order *******");
                System.out.print("Enter name: ");
                String name = br.readLine();
                System.out.print("Product Id to purchase :");
                String id = br.readLine();
                int ids = Integer.parseInt(id); 
                System.out.print("Quantity :");
                String qut = br.readLine();
                int quan = Integer.parseInt(qut);

                for(int i=0;i<parr.length;i++){
                    if(ids==parr[i].productId){
                        for(int j=0;j<quan;j++){
                            Customer c = new Customer(name,parr[i]); 
                            try{
                                parr[i].quantity--;
                                FileOutputStream f = new FileOutputStream("./sales.txt");
                                ObjectOutputStream os = new ObjectOutputStream(f);
                                os.writeObject(c);
                                os.close();
                                
                                System.out.println();
                                System.out.println();
                            }catch(Exception e){
                                System.out.println("Error "+e.getMessage());
                            }

                        }
                    }
                }

                System.out.println("**********Product List*************");
                for(int m=0;m<parr.length;m++){
                    System.out.println("Name: "+parr[m].name+"  "+"id: "+parr[m].productId+"  "+"Price: "+parr[m].price+"  "+"Quantity: "+parr[m].quantity);
                    System.out.println();
                }

            }
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());

        }

   
    }
}