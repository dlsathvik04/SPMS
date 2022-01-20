package BufferList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericBufferList<T> extends nonVolatileList<T>{
    ArrayList<T> list = new ArrayList<T>();
    File file;

    @SuppressWarnings("unchecked")
    public GenericBufferList(String fileName) throws IOException, ClassNotFoundException{
        File file = new File(fileName);
        this.file = file;
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<T>) ois.readObject();
            fis.close();
            ois.close();
        }
        else{
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(this.file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        }
    }

    @SuppressWarnings("unchecked")
    void readyList() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (ArrayList<T>) ois.readObject();
        fis.close();
        ois.close();        
    }

    void updateList() throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        fos.close();
        oos.close();        
    }

    public void add(T obj) throws IOException, ClassNotFoundException{
        readyList();
        list.add(obj);
        updateList();
    }

    public T get(int i) throws ClassNotFoundException, IOException{
        readyList();
        return list.get(i);
    }

    public void set(int i ,T obj) throws IOException, ClassNotFoundException{
        readyList();
        list.set(i, obj);
        updateList();
    }

    public void clear() throws IOException, ClassNotFoundException{
        readyList();
        list.clear();
        updateList();
    }

    public void remove(int i) throws ClassNotFoundException, IOException{
        readyList();
        list.remove(i);
        updateList();
    }

    
    public Iterator<T> iterator() {
        return list.iterator();
    }

	public void pop() throws ClassNotFoundException, IOException {
		readyList();
        list.remove(list.size()-1);
        updateList();
	}

	public void pop(int i) throws ClassNotFoundException, IOException {
		readyList();
        for (int j=0; j<i; j++){
            list.remove(list.size()-1);
        }
        updateList();
		
	}

    public int size() throws ClassNotFoundException, IOException{
        readyList();
        return list.size();
    }

}
