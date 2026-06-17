package CoreJava;

import java.util.Scanner;

public class Level2 {
    
    public static int fact(int n)
     {
         int pro=1;
         for(int i=1;i<=n;i++)
         {
            pro*=i;  
         }
         return pro;
     }
   
    public static void main(String[] args) {
     
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     
     //  pattern-1
    System.out.println("Pattern-1");
    System.out.println();
     for(int i=0;i<n;i++)
     {
         for(int j=0;j<n;j++)
         {
             System.out.print("*");
         }
         System.out.println();
     }
      System.out.println();
     System.out.println("Pattern-2");
      System.out.println();
    // pattern-2
   
    for(int i=1;i<=n;i++)
    {
     for(int j=1;j<=i;j++)
     {
         System.out.print("&");
     }
     System.out.println();
    }
    System.out.println("Pattern-3");
   
    //  pattern-3
   
    for(int i=n;i>=1;i--)
    {
        for(int j=1;j<=i;j++ )
        {
          System.out.print("M");
        }
        System.out.println();
    }

    System.out.println("Pattern-4"); 
    // pattern-4
   
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print(j);
        }
        System.out.println();
    }

    System.out.println();
   
    // pattern-5
   
    for(int i=1;i<2*n;i++)
    {
        int j;
        if(i>n)
        j=2*n-i;
        else
        j=i;
        for(int k=1;k<=j;k++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    System.out.println();
   
    // pattern-6
   
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n-i;j++)
        {
            System.out.print(" ");
        }
        for(int k=i;k>0;k--)
        {
            System.out.print("G");
        }
        System.out.println();
    }
    System.out.println();
   
    // pattern-7
   
      for(int i=n;i>=0;i--)
    {
      for(int j=n-i;j>0;j--)
      {
            System.out.print(" ");  
      }
      for(int k=i;k>0;k--)
      {
          System.out.print("M");
      }
        System.out.println();
    }
    System.out.println();
   
    // pattern-8
    for(int i=1;i<=n;i++)
    {
       
        for(int j=1;j<=n-i;j++)
        {
            System.out.print(" ");
        }
        for(int k=2*i-1;k>0;k--)
        {
            System.out.print("W");
        }
       
        System.out.println();
    }
     System.out.println();
    // pattern-9
    for(int i=n;i>0;i--)
    {
        for(int j=n-i;j>0;j--)
        {
            System.out.print(" ");
        }
        for(int k=2*i-1;k>0;k--)
        {
            System.out.print("Q");
        }
        System.out.println();
    }
    System.out.println();
   
    // pattern-10
   
    for(int i=1;i<=n;i++)
    {
        for(int j=n-i+1;j>0;j--)
        {
            System.out.print(" ");
        }
       
      for(int k=i;k>0;k--)
      {
          System.out.print("* ");
      }
       
       
        System.out.println();
    }
    System.out.println();
   
    // pattern-11
     for(int i=n;i>0;i--)
    {
      for(int j=n-i+1;j>0;j--)
      {
          System.out.print(" ");
      }
      for(int k=i;k>0;k--)
      {
          System.out.print("* ");
      }
        System.out.println();
    }
    System.out.println();
    //pattern-12
     for(int i=n;i>0;i--)
    {
      for(int j=n-i+1;j>0;j--)
      {
          System.out.print(" ");
      }
      for(int k=i;k>0;k--)
      {
          System.out.print("* ");
      }
        System.out.println();
    }
    for(int i=1;i<=n;i++)
    {
        for(int j=n-i+1;j>0;j--)
        {
            System.out.print(" ");
        }
       
      for(int k=i;k>0;k--)
      {
          System.out.print("* ");
      }
       
       
        System.out.println();
    }

    System.out.println();
   
    //pattern-13
    for(int i=1;i<n;i++)
    {
        for(int j=n-i;j>0;j--)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        for(int k=2*i-3;k>0;k--)
        {
            System.out.print(" ");
        }
        if(i!=1)System.out.print("*");
        System.out.println();
    }
    for(int i=2*n-1;i>0;i--)
    {
        System.out.print("*");
    }
   
    System.out.println();
    // pattern-14
    for(int i=1;i<=2*n-1;i++)
    {
        System.out.print("*");
    }
    System.out.println();
    for(int i=n-1;i>0;i--)
    {
        for(int k=n-i;k>0;k--)
        {
            System.out.print(" ");
        }
        System.out.print("*");
         for(int k=2*i-3;k>0;k--)
        {
            System.out.print(" ");
        }
        if(i!=1)System.out.print("*");
        System.out.println();
       
    }
   
    System.out.println();

    //pattern-15
    for(int i=1;i<=n;i++)
    {
        for(int j=n-i;j>0;j--)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        for(int k=2*i-3;k>0;k--)
        {
            System.out.print(" ");
        }
      if(i>1) System.out.print("*");
      System.out.println();
       
    }
    for(int i=1;i<n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        for(int k=2*(n-i)-3;k>0;k--)
        {
            System.out.print(" ");
        }
        if(i<n-1)System.out.print("*");
        System.out.println();
    }

    System.out.println();
   
    // pattern-16
    for(int i=0;i<=n;i++)
    {
        for(int j=n-i;j>=0;j--)
        {
            System.out.print(" ");
        }
       
        for(int j = 0; j <= i; j++) {
        System.out.print(fact(i)/(fact(j)*fact(i-j)) + " ");
        }
        System.out.println();
    }

    System.out.println();
   
    //pattern-17
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n-i;j++)
        {
            System.out.print(" ");
        }
        for(int k=i;k>0;k--)
        {
            System.out.print(k);
        }
        for(int t=2;t<=i;t++)
        {
            System.out.print(t);
        }
        System.out.println();
    }
    for(int i=1;i<n;i++)
    {
        for(int j=i;j>0;j--)
        {
            System.out.print(" ");
        }
        for(int k=n-i;k>0;k--)
        {
            System.out.print(k);
        }
        for(int t=2;t<=n-i;t++)
            System.out.print(t);
        System.out.println();
    }

    System.out.println();
   
    // pattern-18
    for(int i=1;i<=n;i++)
    {
        for(int j= n+1-i;j>0;j--)
        {
            System.out.print("*");
        }
        for(int k=2*(i-1);k>0;k--)
        {
            System.out.print(" ");
        }
        for(int t=n+1-i;t>0;t--)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print("*");
        }
        for(int k=2*(n-i);k>0;k--)
        {
            System.out.print(" ");
        }
        for(int t=1;t<=i;t++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    System.out.println();
   
    // pattern-19
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            System.out.print("*");
        }
        for(int k=2*(n-i);k>0;k--)
        {
            System.out.print(" ");
        }
         for(int j=1;j<=i;j++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i=1;i<n;i++)
    {
        for(int j=(n-1-i);j>=0;j--)
        {
            System.out.print("*");
        }
        for(int k=2*i;k>0;k--)
        {
            System.out.print(" ");
        }
        for(int j=(n-1-i);j>=0;j--)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    System.out.println();
   
    // pattern-20
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i==1 ||i==n || j==1 || j==n)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
       
        // pattern-21
        int w=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                w++;
                System.out.print(w+" ");
               
            }
            System.out.println();
        }

        System.out.println();
       
        //pattern-22
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if((i+j)%2==0)
                {
                    System.out.print("1");
                }
                else
                {
                    System.out.print("0");
                }
               
            }
           
            System.out.println();
        }
        System.out.println();
       
        //pattern-23
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k=1;k<=2*(i)-3;k++)
            {
                System.out.print(" ");
            }
            if(i>1)System.out.print("*");
            for(int t=2*(n-i);t>0;t--)
            {
                System.out.print(" ");
            }
            if(i<n) System.out.print("*");
            for(int k=1;k<=2*(i)-3;k++)
            {
                System.out.print(" ");
            }
            if(i>1)System.out.print("*");
            System.out.println();
        }
       
        System.out.println();
        // pattern-24
       
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i==j || j==1||j==n||i+j==n+1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
       
        // pattern-25
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=(n-i);j++)
            {
                System.out.print(" ");
            }
            if(i==1 || i==n)
            {
                for(int k=1;k<=n;k++)
                {
                    System.out.print("*");
                }
            }
            else
            {
                System.out.print("*");
                for(int k=1;k<=(n-2);k++)
                {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
           
            System.out.println();
        }
        System.out.println();
        //pattern-26
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=(n+1-i);j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();
 sc.close();  
}
}
