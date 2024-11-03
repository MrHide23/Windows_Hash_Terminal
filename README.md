# What is this?? 🏫
This is a simple program written in Java that gives you the possibility of making a hash of something. The idea is that you can make a.dom file and add it to your path system in Windows and execute the program as a Linux system does.
First of all, how can I add the program to my variable system path?? 

First you need to compile the program and ontend the .class file resultant. You can do it executing this in some terminal in the same directori of the .java program.
````bash
javac hash.java 
````
This gives you the resultant hash class. It's important to know that if you want to implement a personal feature and add your own changes, you need to change the code of hash.jave and compile as before. 
Next, we go to create the.dom file. To do this, we will open a text editor, write the following, and save the file as hash.dom.
```` bash 
@echo off

java -cp "hash.class file path" hash %*

pause
````
Finally, you must open the system environment variables > Environment Variables > Path(System Variables) > Edit > New

And then you add the path where the hash.dom file you just created is located. You keep the exchange and everything is ready.

# How to use it?? 
This first version is really easy to use; you can just make the hash of raw text and only hash MD5, SHA-1, and SHA-256. To execute, you first need to add the hash.dom to Environment Variables, and then you can execute the next command in your Windows terminal. 
`````bash
hash text md5/sha-1/sha-256
``````

And then you get instantly the corresponded hash from this text 💥. In the future, the idea is to add new commands and new functionalities. This is the v1.0 is not somthing incredible but is more easy than try to get a hash using powrshell comands 💀
