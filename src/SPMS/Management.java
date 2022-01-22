package SPMS;

import java.io.IOException;

public class Management {
    private String passCode= "amritavishwavidyapeetam";

    public String getCode(){
        return passCode;
    }
    public void setCode(String passCode){
        this.passCode = passCode;
    }

    public void nullStudent(int i) throws ClassNotFoundException, IOException{
        SR.start();
        SR.nullifyStudent(i);
    }
    public void getAll() throws ClassNotFoundException, IOException{
        SR.start();
        int i = 0;
        for(Student s: SR.list){
            System.out.println(i + ": "+s.toString());
            System.out.println("*".repeat(75));
            i++;
        }    
    }
    public void reset() throws ClassNotFoundException, IOException{
        SR.start();
        SR.list.clear();
    }
}
