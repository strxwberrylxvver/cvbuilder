/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CVData {
    
    private static CVData instance;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }
    
    private CVData(){   
        this.readSuperCsv("data/cv_repo_3.csv");
    }
    
    public static CVData getInstance(){
        if (instance == null){
            instance =  new CVData();
        }
        return instance;
    }
    
public void readSuperCsv(String filename)
{
    try(
                BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            while(br.ready())
            {
                String lines = br.readLine();
                String[] v = lines.split(",");
                //users.add(new User(v[0],v[1],v[2],v[3]));
                switch (v[0].toLowerCase()) {
                    case "user" -> {
                        switch (v[1].toLowerCase()){
                            case "name" -> {
                                for (int i=2;i<v.length;i++) {
                                    names.add(v[i]);
                                }
                        }
                            case "title" -> {
                                for (int i=2;i<v.length;i++) {
                                    titles.add(v[i]);
                                }
                        }
                            case "email" -> {
                                for (int i=2;i<v.length;i++) {
                                    emails.add(v[i]);
                                }
                        }        
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
              e.printStackTrace();
        }
    System.out.println(names);
    System.out.println(titles);
    System.out.println(emails);


//    public void writeSuperCsv(String filename)
//    {
//        try(
//                BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
//        {
//            for (User u: users)
//            {
//            bw.write(u.getUserProfileID() + "," + u.getTitle() + "," + u.getName() + "," + u.getEMail());
//            bw.newLine();
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
}}