package CoreJava;

public class Enumeration {
    public static void main(String[] args) {
            //  AccountType acc=100;  NOT ALLOWED
            // AccountType acc="SAVING"; NOT ALLOWED only allowed AccountType.SAVING,AccountType.CURRENT,AccountType.FIXED_DEPOSIT
            // Main Thing !!  Compile Time Error 

            int status=Account.CURRENT;
            status=100;  //NO Type Safety
            status=Account.FD;
            if(status==Role.Admin) //As condition true  but create Bug
            { 
                System.out.println("Your Account is done with FD");
            }

            Direction d=Direction.EAST;
            System.out.println("Direction:"+d.name()+" "+"Degree: "+d.getDegree());
            System.out.println();
            d.move();
           for(Direction A:Direction.values())
           {
                System.out.println(A.name());
           }
           //values() : TO know about all possible value of enumeration

           Direction  d1=Direction.valueOf("SOUTH");
           System.out.println(d1.name());
           System.out.println(d1);
        //name() : cannot be override (It's final method in Enum !!)
        // tosttring() : Can be override  (Output:SOUTH)

        System.out.println(d.ordinal());
        
    }
    
}

class Account
{
    public static final int SAVING=1;
    public static final int CURRENT=2;
    public static final int FD=3;
}

class Role
{
     public static final int USER=1;
    public static final int TEAMLEAD=2;
    public static final int HR=3;
    public static final int Admin=3;  // Duplicate  Allowed !! problem
}
    

/*
    Type  safety        means it anywhere when i put int a1=Account.SAVGING , it can be change to 100 also
    poor readablity     it is refere to  if it  3 --> FD if 2-->CURRENT And all ..
    Grouping problem    if same 3 number also refer to use in role class it being logical corect and not give error there 
    String comparing    if it used we have to first convert all letter in the same format and then compare andcomparing is slow                operation and still it has type safety problem
    Duplicate value     Allow in same class 

*/
//  enum is class introduce in java 1.5  enum-->enumeration
// enum is still being class

enum AccountType{
    SAVING,CURRENT,FIXED_DEPOSIT;
}


// HOW enum work under the hood :

// class AccountType extends Enum<AccountType>{
//      public static final AccountType SAVING =new AccountType();
//      public static final AccountType CURRENT =new AccountType();
//      public static final AccountType FIXED_DEPOSIT =new AccountType();
//      private AccountType(){}   //no one outside the class can create object of the class Type Saftey 


//    when we do AccountType acc=AccountType.SAVING;  --> it means acc is reference of Accountype refere to same memory refer    by AccounuType.SAVING 
//   it also have Type safety because we cannot create object as we disscussed and second thing we can not give any integer or string value in AccountType reference 


        // ----------------ALLL THIS DONE AT COMPILE TIME ----------------------
    // private static final AccountType[] $_ACCOUNT_TYPES={
    // SAVING,CURRENT,FIXED_DEPOSIT
    // }

    // public static AccountType[] values()
    // {
            // return  $_ACCOUNT_TYPES.clone();
    // }
// 
// }


enum Direction
{
    NORTH(0){
        @Override
        public void move()
        {
            System.out.println("Moved in North Direction");
        }
    },    //public static final NORTH =new Direction(0);
    SOUTH(180)
    {
         @Override
        public void move()
        {
            System.out.println("Moved in south Direction");
        }

    }, //public static final SOUTH =new Direction(180);
    EAST(90)
    {
         @Override
        public void move()
        {
            System.out.println("Moved in east Direction");
        }
    },   //public static final EAST =new Direction(90);
    WEST(270)
    {
         @Override
        public void move()
        {
            System.out.println("Moved in West Direction");
        }
    };  //public static final WEST =new Direction(270);

    private int degree;
    // ByDefault /implictly Constructor is private 
    Direction(int Degree)
    {
        this.degree=Degree;
    }
    public int getDegree() {
        return degree;
    }
    public abstract void move();
    
}


