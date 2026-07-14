package CoreJava.Multithreading.AtomicityProblem;

public class Main {
    public static void main(String[] args)throws InterruptedException{
        BankAccount account = new BankAccount("Alice", 100, 0.6);
        Thread t1 = new Thread(() -> account.withdraw(100), "Alice");
        Thread t2 = new Thread(() -> account.withdraw(100), "Bob");
         t1.start();
         t2.start();
        t1.join();
        t2.join();
         System.out.println("Current Net Balance:"+account.balance);
    }
}
