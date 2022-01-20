package BufferList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

}
