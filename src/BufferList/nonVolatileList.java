package BufferList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//this is an absract class written as a framework similar to collections which implements the iterable design pattren
//this abstact class acts as a bluprint for other classes in this framework.
//as the name suggests this framework works on array type classes which can retain their state over different sessions 
//of program. that is the data in the array wont be lost even after terminating and running the program again.

abstract class nonVolatileList<T> implements Iterable<T>{
    ArrayList<T> list;
    File file;

    abstract void readyList() throws IOException, ClassNotFoundException;
    abstract void updateList() throws IOException;
    abstract void add(T obj) throws IOException, ClassNotFoundException;
    abstract T get(int i) throws ClassNotFoundException, IOException;
    abstract void set(int i ,T obj) throws IOException, ClassNotFoundException;
    abstract void clear() throws IOException, ClassNotFoundException;
    abstract void remove(int i) throws ClassNotFoundException, IOException;
    public abstract Iterator<T> iterator();
    abstract void pop() throws ClassNotFoundException, IOException;
    abstract void pop(int i) throws ClassNotFoundException, IOException;
    abstract int size() throws ClassNotFoundException, IOException;

}
