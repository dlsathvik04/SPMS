package SPMS;

import java.io.Serializable;

public class PlacementAdmin implements Serializable{
    private String password;
	private Long phNo;
	private String email;
	private String name;
    private String Organisation;

    PlacementAdmin(String password){
        this.password = password;
    }

    PlacementAdmin(String password, Long phNo, String email,String name, String Organisation){
        this.password = password;
        this.phNo = phNo;
        this.email = email;
        this.name = name;
        this.Organisation = Organisation;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public Long getPhone(){
        return this.phNo;
    }
    public void setPassword(Long phNo){
        this.phNo = phNo;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String Email){
        this.email = Email;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String Name){
        this.name = Name;
    }

    public String getOrganisation(){
        return this.Organisation;
    }
    public void setOrganisatin(String Organisation){
        this.Organisation = Organisation;
    }


    public String toString(){
        return ("name: " + this.name +";\nphone: "+ this.phNo +";\nEmail: "+ 
        this.email +";\nOrganisation: "+ this.Organisation);
    }

    public String oneLineString(){
		return("name: " + this.name + "phone: " + this.phNo + 
        "; Email: " +this.email+"; Organisation: "+ 
        this.Organisation);
	}
    


}
