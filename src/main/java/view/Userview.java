package view;

import dao.DataDao;
import model.Data;
import model.User;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Userview {
    private String email;
    Userview(String email){
        this.email=email;
    }
    public void home(){
      do {
          System.out.println("***$ WELCOME TO FILE MANAGER ***$ \n User - "+this.email);
          System.out.println("Press 1 to {Show hidden files}");
          System.out.println("Press 2 to {Hide a new file}");
          System.out.println("Press 3 to {UnHide an existing file}");
          System.out.println("Press 0 to {Exit}");
          Scanner sc = new Scanner(System.in);
          int ch = Integer.parseInt(sc.nextLine());
          switch(ch){
              case 1->{
                  try {
                      List<Data> files = DataDao.getAllFiles(this.email);
                      System.out.println("ID - FileName ");
                      for(Data file:files){
                          System.out.println(file.getId()+ " - " + file.getFileName());
                      }
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }

              }
              case 2 -> {
                  System.out.println("Enter the file path");
                  String path  = sc.nextLine();
                  File f = new File(path);
                  Data file = new Data(0,f.getName(),path,this.email);
                  try {
                      DataDao.hideFile(file);
                  } catch (SQLException  e) {
                      e.printStackTrace();
                  }
                  catch(IOException ex){
                      ex.printStackTrace();
                  }

              }
              case 3 ->{
                  List<Data> files = null;
                  try {
                      files = DataDao.getAllFiles(this.email);
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }
                  System.out.println("ID - FileName ");
                  for(Data file:files){
                      System.out.println(file.getId()+ " - " + file.getFileName());
              }
                  System.out.println("Enter the id of the file to unhide");
              int id  = Integer.parseInt(sc.nextLine());
              boolean isValid = false;
              for(Data file: files){
                  if(file.getId()==id){
                      isValid=true;
                      break;}
              }
              if(isValid){
                  try {
                      DataDao.unHide(id);
                  } catch (SQLException e) {
                     e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
              else {
                  System.out.println("Invalid id");
              }
              }
              case 0->{
                  System.out.println("Thanks for using File Hider Application");
                  System.exit(0);
              }
          }
      }while(true);
    }
}
