// InputStream (Abstract Class) --> read()
// |_[ByteArrayInputStream]
// |_[BufferedInputStream]
// |_[FileInputStream]
// |_[DataInputStream]


// OutputStream(Abstract Class)  --> write()
// |_[ByteArrayOutputStream]
// |_[BufferedOutputStream]
// |_[FileOutputStream]
// |_[PrintStream]


package CoreJava;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.lang.*; Auto Added
public class InputOutput {

    public static void main(String[] args) throws IOException {
        
        System.out.println("Hello");
        //System is class of java.lang package
        //System class static field is out 
        //out is reference of PrintStream
        //err is reference of PrintStream
        //println,print,printf is method of PrintStream
        //OutputStream and InputStream is abstract
        System.out.print("World \t");
        System.out.printf("Tirtha \n");
        System.err.println("Out Of your mind 😂"); 
        int Age=-78;
        if(Age<0)
        {
            System.err.println("Age he ya udhar !!");
        }
        // int x=System.in.read(); //return int
        // System.out.println(x); //ASCII value
        System.out.println("Using Manual Way:");
        String S="";
        int c;
        while(true)
        {
            c=System.in.read();
            if(c=='\n')
            {
                break;
            }
            S+=(char)c;

        }
        System.out.println(S);
    // Before reader   (KeyBoard-->Os Buffer-->Program) --->For each Char systemCall
    // Reader  (Abstract)  (Stream of Character)
    // |_ BufferedReader     (Keyboard-->Os Buffer-->Java Buffer -->Program)  --> Less System Call
    // |_ InputStreamReader 
    // |_ FileReader

        System.out.println("Using Buffer Reader");
        InputStreamReader lsr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(lsr);
        String name=br.readLine();
        System.out.println(name);
        System.out.println("Using Scanner Class");
        // Java 1.5 -->Scanner class
        Scanner sc=new Scanner(System.in);
        String Surname=sc.nextLine();
        System.out.println(Surname);
        sc.close();

    }
    
}
