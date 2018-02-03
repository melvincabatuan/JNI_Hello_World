# JNI Hello World Example (in Windows)

## Create HelloWorld.java
```
class HelloWorld {
 
     static {
         System.loadLibrary("HelloWorld");
     }
 
     private native void print();
 
     public static void main(String[] args) {
         new HelloWorld().print();
     }
 }
```

## Compile HelloWorld.java
```
javac HelloWorld.java
```

## Create JNI Header
```
javah -jni HelloWorld
```

## Create HelloWorld.c 
```C
#include <jni.h>
#include <stdio.h>
#include "HelloWorld.h"
  
JNIEXPORT void JNICALL 
Java_HelloWorld_print(JNIEnv *env, jobject obj)
{
     printf("Hello World!\n");
     return;
}
```

## Compile HelloWorld.c
```
gcc -c -o HelloWorld.o HelloWorld.c -I"C:\Program Files\Java\jdk1.8.0_144\include" -I"C:\Program Files\Java\jdk1.8.0_144\include\win32"
gcc -o HelloWorld.dll -s -shared HelloWorld.o -Wl,--subsystem,windows
```

These may vary in your set-up:
- Path to your JDK Include for jni.h: C:\Program Files\Java\jdk1.8.0_144\include
- Path to your JDK Win32 include for jni_md.h: C:\Program Files\Java\jdk1.8.0_144\include\win32
- I'm using TDM gcc: C:\TDM-GCC-64\bin\gcc.exe

## Sample Run

![](https://github.com/melvincabatuan/JNI_Hello_World/blob/master/Capture.PNG)
