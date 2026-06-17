// Topic: CLasses



//                  Do you need to reuse the blueprint globally?
//                                  │
//                     ┌────────────┴────────────┐
//                  [ YES ]                   [ NO ]
//                     │                         │
//       Does it need instance memory         Is it used across multiple 
//       of an outer parent object?           methods inside one file?
//             ┌───────┴───────┐                   ┌───────┴───────┐
//          [ YES ]         [ NO ]              [ YES ]         [ NO ]
//             │               │                   │               │
//             ▼               ▼                   ▼               ▼
//       [Inner Class]  [Static Nested]     [Local Class]   [Anonymous Class]


package CoreJava;

import java.util.HashMap;

public class NestedClass {
    public static void main(String [] args)
    {
        Devices[] peripherals = new Devices[] {
            new Devices(DeviceType.INPUT, "Keyboard"),
            new Devices(DeviceType.OUTPUT, "Monitor"),
            new Devices(DeviceType.BOTH, "TouchScreen")
        };

       
        Computer myPC = new Computer(16.0, 512.0, peripherals);

        
        ControlUnit cu = new ControlUnit();
        ALU alu = new ALU(ArchType.REGISTER_REGISTER, 128, 64);

       
        Computer.CPU myIntelCore = myPC.new CPU(8, alu, 16, cu);

        
        System.out.println("--- INITIATING SYSTEM POWER BUTTON ---");
        myIntelCore.bootUpSystem();

        BankProcessor  SBI =new BankProcessor();
        SBI.checkout(134);

        //That is not necessary that we have to use Anonymous Class we need to declare anyother class or method 
        //this way also we define the Anonymous Class
        PaymentGateway P1=new PaymentGateway() {
            @Override
            public void processPayment(double amount)
            {
                System.out.println("YOur Payment amount Should be: "+amount);
            }
        };
        P1.processPayment(124);

        

    }

    public void Greeting ()
    {
        //Effiectively Final
        // only becomes effictively final when variables are use inside the class not before that 
        //Question : Why it becomes effitively final ?
        //Reason: When Any local class use outer function or block fields then iternally it copy into local class as local class field because then the block ends the stack frame is out and reference of the object is destroyed , the object is not destroy from the heap if it would be still refering by other identifier or other thread or global variable then it want to access the block field it allowed 
        // but if changes are happened in field then copied value to local class and block field value become inconsistent to make it consistent eveery changes inside the local value copy to local class field value which slow tracking engine so  that it make used field of block as effictive final 
        // effictive solution:Freeze
        int person =0;


        // Local Class
        class Greet
        {
            void SayHello()
            {
                System.out.println("Hello");
                System.out.println(person); //Read Operation

            }
            void Namaste()
            {
                System.out.println("Namaste");
                // person+=1;    Because local Class access variable must be final or effectively final
            }
        }

        Greet G1=new Greet();
        G1.Namaste();
        G1.SayHello();
    }


    
}

interface PaymentGateway {
    void processPayment(double amount);
}

class BankProcessor {

    public void checkout(double totalBill) {
        
        // Local variable from the method stack
        //it would also be effiectively final
        double cashbackBonus = 50.0; 
    
        // We look like we are saying "new" on an Interface, but look at the curly braces!
        // We are defining a nameless class on the fly.  means dynamically at the runtime
       
        //The compiler creates a synthetic class such as: BankProcessor$1.class and immediately creates its object.
        PaymentGateway promoGateway = new PaymentGateway() {
            
            // 1. It can have its own internal fields/state
            private double transactionFee = 2.5;

            @Override
            public void processPayment(double amount) {

                // It uses  the method's local stack variables! -cashbackBonus
                double finalAmount = amount - cashbackBonus + transactionFee;
                
                System.out.println("Processing specialized promo checkout...");
                System.out.println("Final amount routed to vault: INR " + finalAmount);
            }
        }; // <--- Notice the semicolon! It's a statement that defines and creates the object.

    
        promoGateway.processPayment(totalBill); //Anonymous Class uses when we need the logic only at once because after that to get the same logic we have to write all logic again so used when we need only at once 
    }
}

enum Status
{
    SUCCESS,FAILED,PENDING
}
enum DeviceType
{
    INPUT,OUTPUT,BOTH
}
enum ArchType
{
    ACCUMULATOR_BASED,REGISTER_REGISTER,STACK_BASED,REGISTER_MEMORY,COMPLEX
}

class Devices
{
    DeviceType D;
    String DeviceName;
    public Devices(DeviceType D, String DeviceName) {
        this.D = D;
        this.DeviceName = DeviceName;
    }
}
class ControlUnit
{
    //control logic is here 
}
class ALU
{
    ArchType Arch;
    int NumberOperationSupported;
    int SystemArchBit;

    public ALU(ArchType Arch, int NumberOperationSupported, int SystemArchBit) {
        this.Arch = Arch;
        this.NumberOperationSupported = NumberOperationSupported;
        this.SystemArchBit = SystemArchBit;
    }
}
//Nested Non- static class Example
class Computer
{
    private double RamSize;
    private double SecondaryMemorySize;
    Devices [] IO;

    public Computer(double RamSize, double SecondaryMemorySize, Devices[] IO) {
        this.RamSize = RamSize;
        this.SecondaryMemorySize = SecondaryMemorySize;
        this.IO = IO;
    }

//Therotical Perspective : When inner class object is only assosicated with the outer class object then we declared inner class rather than seperate class

//pratical approach : Use the inner class concept when the inner class is not independently exists without outer class or innerclass have to access the outerclass private object basically when innerclass want to use outerclass fleid and outerclass want to use inner class field so use this approach rather than creating compostion in eachother make it bidirectional tighting 

// Compiler generated reference:
//
// class CPU {
//     final Computer this$0;
// }
//
// Java automatically inserts this hidden field so the inner class
// can access the enclosing Computer object.
    class CPU
    {
        int core;
        HashMap<String,Double> GenralPurposeRegister;
        int [] TempRegister;
        //Use a compostion when 'has -a ' relationship where class useto interate with the other class but in lossly couple and class used in compostion doesnot use and donot want to know about the class where it declare 

        //Innerclass concpets use rarely 
        // because After outer class works done refer it reference as null still garbage collector canot collect it because inner class object refer the outer class using this$0 so for garbage collector if object have still reference then it donot free that memory space and outer class object reference point to null so cannot use it so it is memory leaks 
        ControlUnit C;
        ALU A;
       // Before Java 16, static variables as well as static methods were not allowed inside non-static inner classes. 
        // This was because an inner class is strictly associated with an instance (object) of the outer class. 
        // The designers feared an ambiguity trap: if a static field is placed inside an instance-dependent inner class, 
        // should its value change or stay frozen when the outer object changes? 
        // If it stays the same globally, it works exactly like an outer class static field, making its placement inside 
        // the inner class logically redundant. To eliminate this conceptual ambiguity, Java completely banned them.

        // BUT IN MODERN JAVA (Java 16+), IT IS SUPPORTED BECAUSE:
        // The Java architects decoupled bytecode compilation rules from Heap runtime instantiation. 
        // The JVM loads the outer class (e.g., Computer) and the inner class (e.g., Computer$CPU) as two entirely distinct, 
        // standalone Class types inside the JVM Metaspace (Method Area). 
        // Since they are distinct Class blueprints in memory, the inner class blueprint is perfectly capable of holding a 
        // static field in Metaspace. 

        // The Scope Rule Now: At runtime, that static field inside the inner class is allocated EXACTLY ONCE globally in Metaspace. 
        // It does not duplicate per outer class object. Any change made to it by one inner object instantly alters it 
        // for all other inner objects, across all outer class instances, exactly like an outer class static variable would.
        // Compile-time constants (static final int X = 10;) were allowed because the compiler secretly replaces that variable name with the hardcoded number 10 everywhere in the bytecode before it even runs. Modern Java (16+) lifted the ban on all mutable static fields and methods.
        static double clockfrq;

        public CPU(int core, ALU A,int tempRegister,ControlUnit C) {
            this.core = core;
            this.A = A;
            this.C = C;
            this.GenralPurposeRegister = new HashMap<>();
            this.TempRegister = new int[tempRegister]; 
        }

        public final void bootUpSystem() {
            System.out.println("CPU is initializing cores: " + this.core);
            System.out.println("ALU Architecture Type: " + this.A.Arch);
            
            // MAGIC MOMENT: The inner CPU directly reads its parent Computer's specifications!
            // It uses the implicit pointer to find 'RamSize' and 'SecondaryMemorySize'.
            System.out.println("Reading System Motherboard RAM... Found: " + RamSize + " GB");
            System.out.println("Mounting Storage Disk... Found: " + SecondaryMemorySize + " GB");
            System.out.println("System Booted Successfully! 🚀");
        }
    }
    
}

enum AccountType 
{
    SAVING,CURRENT;
}

class BankAccount
{
    String AccountHolderName;
    AccountType accountType;
    double Amount;
    double IntrestRate;

    public BankAccount(String name, double amount, double rate) {
        this.AccountHolderName = name;
        this.Amount = amount;
        this.IntrestRate = rate;
    }
    
    //Static class uses for helper method class or security purpose to hide the implementation
    //it also uses in DTO and builder design pattern
    //For static class there is no need to creater the outer class object ,it is assoicated with the outer class and so it access only static method and fields
    private static class Util
    {
       
        //class is private and method is also private so without outer class noone access it so logic being hide to everyone 
        private static double YearlyAmount(BankAccount B)
        {
            return B.Amount*B.IntrestRate;
        }
    }
    // Transitional log doesnot exists without the BankAccount
    //As Transtionallog is not assoicated to bank it mainly assoicated with person account therefore it is not static 
    //so everyobject of bankaacount has it own transtional log
    class TranstionalLog
    {
        String FromAccount;
        String ToAccount;
        double Amount;
        Status trans;
    }
    //implementation is hide and make it final indicate no one is override so it give us security 
    public final double CalculateYearlyIntrest()
    {
        return BankAccount.Util.YearlyAmount(this);
    }
}

// the compiler generates behind the scenes:

// Computer$CPU.class (Inner Class)

// NestedClass$1Greet.class (Numbered Local Class)

// BankProcessor$1.class (Numbered Anonymous Class)