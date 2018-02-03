class HelloWorld {
 
     static {
         System.loadLibrary("HelloWorld.dll");
     }
 
     private native void print();
 
     public static void main(String[] args) {
         new HelloWorld().print();
     }
 }