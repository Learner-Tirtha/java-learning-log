package CoreJava;
import java.util.Scanner;
public class Level1 {
    public static void main(String [] args)
    {
        //datatype: primitive and non-primitive
        // decimal : byte,short,int,long
        //floating point : float,double
        //character : char
        //Boolean : boolean
        char chr='a';  //use Unicode which is superset of ascii
        System.out.println(chr);
        float a=23.56f; // f: to indicate it is float because it is by default take it as double
        System.out.println(a);
        byte a1=123;   //Range : -128 to 127
        int a2=a1;     //Range: -2^31 to 2^31 -1
        System.out.println(a2);   //Implicit Type conversion   -- widening conversion (automantically /done by compiler)
        int cvt = chr;
        System.out.println(cvt);
        float a3 = 300f;
//        byte aw=a2;    //Explicit Type conversion --Error
        // Narrowing conversion
        byte aw=(byte) a3;   // least 8 bit are taken  -- data truncated  (value mod range of dest. type )
        System.out.println(a3); //300
        System.out.println(aw); //44
        byte b=20;
       //  b=b*4;  Error -- char,short,byte converted to int  using type promotion after that  b * 4  in int and b type
        //  is byte so type's mismatch
        b*=4; //No Error  it internally means b=(byte) b*4; Therefore mainly uses type of decimal is int not short and byte
        System.out.println(b);
//        basic but important
        Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();

        if(age>=13 && age<=19)
            System.out.println("Teenager");
        else
            System.out.println(" NotTeenager");
        int DayNo;
        DayNo=sc.nextInt();
        // switch is implemented by tableswitch or lookupswitch  by JVM
        switch(DayNo)
        {
            case 1:
                System.out.println("Monday");
                break;
            case 2:System.out.println("Tueday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Out Of Scope");



        }
      
        // Loops

        // for loop mostly used when know about the number of interation
        for(int i=1;i<=10;i++)
        {
            System.out.println(i);
        }

        int j=1;
        // while used when knowing about the when to stop -at what condition
        while(j!=11)
        {
            System.out.println("Hello Dear");
            j++;
        }
        //do -while mostly use when first excute the logic then ask for condition
        int ordered_item;
        do
        {
            ordered_item=sc.nextInt();

        }while(ordered_item!=0);


        sc.close();


    }
}
