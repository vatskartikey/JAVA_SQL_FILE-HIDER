package model;
import java.lang.*;
public class User {
   private String name;
    private String email;
    public User(String user_name,String user_email) {
       name=user_name;
       email = user_email;
    }
    public void setName(String user_name) {
        name = user_name;
    }

    public void setEmail(String user_email) {
        email = user_email;
    }

    public String getName() {
        return name;
    }
public String ematoName(String email){
        return name;
}
    public String getEmail() {
        return email;
    }



}
