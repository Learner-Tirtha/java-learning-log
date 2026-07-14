package CoreJava.Multithreading.AtomicityProblem;

class BankAccount
{
    String accountHolderName;
    double balance;
    double intrestRate;

    public BankAccount(String name, double amount, double rate) {
        this.accountHolderName = name;
        this.balance = amount;
        this.intrestRate = rate;
    }
    
    public void withdraw(double amount)
    {
        if(balance >= amount)
    {     
         System.out.println(Thread.currentThread().getName()
                + " Old  Balance = " + balance);
        // try {
        //     Thread.sleep(1);   // Force context switch
        // } catch (InterruptedException e) {}

        balance -= amount;
        System.out.println(Thread.currentThread().getName()
                + " new Balance = " + balance );
    }

    }
   
    
   
}

