package CoreJava;



public class ParentOfAll {

    //Object :java.lang.Object
    // equals(),hashcode(),getclass(),tostring(),wait(),notify(),notifyall(),finalize(),clone()
public static void main(String[] args) {
    Student s1=new Student("Alice",122);
    Student s2=new Student("Alice",122);
    System.out.println(s1.toString());  //ByDefault  className + @ + hexdecimal of hascode
    System.out.println(s1.hashCode());
    int hash = s1.hashCode();
    System.out.println(Integer.toHexString(hash));
    System.out.println(s1==s2);  //false
    System.out.println(s1.equals(s2)); //true
    System.out.println(s1.getClass());
    
}

    
}
class Student 
{
    String Name;
    int ID;

    Student(String name,int id)
    {
        this.Name=name;
        this.ID=id;
    }
    @Override
    public String toString()
    {
        return this.Name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ID;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (ID != other.ID)
            return false;
        return true;
    }

   
}
