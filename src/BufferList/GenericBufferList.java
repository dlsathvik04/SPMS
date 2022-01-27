package BufferList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

//this class extends the nonVolatileList so this class also implements the iterable design pattern. 
//this class combines the power of ArrayList which is an serializable when the elements are serializable and
//the concept of file handling to make an array like datatype which can retain its state even after restarting the program.
//this makes it possible to store the data of objects created over different sessions of program in an oreganised way.
//this class plays a major role in the working of this project
public class GenericBufferList<T> extends nonVolatileList<T>{
    // the arraylist which stores the data while the program is running
    ArrayList<T> list = new ArrayList<T>(); 

    //the file in which we will be saving the state of arraylist from time to time 
    File file;

    //a consructor with a single string parameter
    @SuppressWarnings("unchecked")
    public GenericBufferList(String fileName) throws IOException, ClassNotFoundException{
        //create a File object with the addres provided as a string inthe parameter 
        File file = new File(fileName);
        this.file = file;
        //if the file already exist then read the arraylist object from the file
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<T>) ois.readObject();
            fis.close();
            ois.close();
        }

        //if the file does not exist then create a new file and write the list into it
        else{
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(this.file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        }
    }


    //this method loads the past saved state of arrayList from the file 
    @SuppressWarnings("unchecked")
    void readyList() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (ArrayList<T>) ois.readObject();
        fis.close();
        ois.close();        
    }

    //this method loads the current state of the arraylist into the file for future recovery
    void updateList() throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        fos.close();
        oos.close();        
    }

    //this method is used to add an object to the list and save the state after adding the object
    public void add(T obj) throws IOException, ClassNotFoundException{
        readyList();
        list.add(obj);
        updateList();
    }

    //this method returns the element at an index i from the last saved state of the list
    public T get(int i) throws ClassNotFoundException, IOException{
        readyList();
        return list.get(i);
    }

    //this method replaces the existing element at index i with a new element and then updates the list
    public void set(int i ,T obj) throws IOException, ClassNotFoundException{
        readyList();
        list.set(i, obj);
        updateList();
    }

    //this method clears all the elements and saves the state 
    public void clear() throws IOException, ClassNotFoundException{
        readyList();
        list.clear();
        updateList();
    }

    //this item removes the element at the inde i and then saves the state
    public void remove(int i) throws ClassNotFoundException, IOException{
        readyList();
        list.remove(i);
        updateList();
    }

    //this makes it possible to iterate through the elements of the arralist when the iterator is called
    public Iterator<T> iterator() {
        return list.iterator();
    }

    //this method removes the last element added to the list and saves the state
	public void pop() throws ClassNotFoundException, IOException {
		readyList();
        list.remove(list.size()-1);
        updateList();
	}

    //this method removes the last i elements from the list and saves the state
	public void pop(int i) throws ClassNotFoundException, IOException {
		readyList();
        for (int j=0; j<i; j++){
            list.remove(list.size()-1);
        }
        updateList();
		
	}

    //ths method retuns the size of the list from its last saved state.
    public int size() throws ClassNotFoundException, IOException{
        readyList();
        return list.size();
    }

}
