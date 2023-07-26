
public class thread2 {
    public static void main(String args[]){
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        t.setPriority(1);
        System.out.println(t.getPriority());

        try{
            t.sleep(2000);
        }catch(Exception e){
            System.out.println("Error");
        }

        t.setName("Sauabh");
        System.out.println(t.getName());

    }
    
}
