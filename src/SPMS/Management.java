package SPMS;

import java.io.IOException;

public class Management {
    private String passCode= "amritavishwavidyapeetam";

    //returns the passcode
    public String getCode(){
        return passCode;
    }

    //method to null a student 
    public void nullStudent(int i) throws ClassNotFoundException, IOException{
        SR.start();
        SR.nullifyStudent(i);
    }

    //priints all the details of all the students 
    public void getAll() throws ClassNotFoundException, IOException{
        SR.start();
        int i = 0;
        for(Student s: SR.list){
            System.out.println(i + ": "+s.toString());
            System.out.println("*".repeat(75));
            i++;
        }    
    }

    //method to reset the whole application
    public void reset() throws ClassNotFoundException, IOException{
        SR.start();
        SR.list.clear();
    }
}
