
public class TT {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(arr.getClass().getName());//[I
        System.out.println(Integer.toHexString(arr.hashCode()));//14ae5a5
        System.out.println(arr);//[I@14ae5a5
        System.out.println(String.valueOf(arr));//[I@14ae5a5
        System.out.println(arr.toString());//[I@14ae5a5
    }
}


/*
The outcome:
[I
14ae5a5
[I@14ae5a5
[I@14ae5a5
[I@14ae5a5

The reason may be:
In the PrintStream.java, if the parameter of println method is an object, the method 
turns the Object into String using String.valueOf(Object obj).


    public void println(Object x) {
        String s = String.valueOf(x);
        synchronized (this) {
            print(s);
            newLine();
        }
    }
    
    
Then in the valueOf method, return the obj.toString() method.
    
    
    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }

Proping into the toString method in Object.java:


    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    
The so-called address is the combination of name+@+hashcode.
    
    
*/
