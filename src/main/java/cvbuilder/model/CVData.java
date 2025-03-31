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
    private ArrayList<String> references = new ArrayList<>();

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

    public ArrayList<String> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<String> references) {
        this.references = references;
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

public void readSuperCsv(String filename) {
    try (
            BufferedReader br = new BufferedReader(new FileReader(filename))) {
        while (br.ready()) {
            String lines = br.readLine();
            String[] v = lines.split(",");
            switch (v[0].toLowerCase()) {
                case "user" -> {
                    switch (v[1].toLowerCase()) {
                        case "name" -> {
                            for (int i = 2; i < v.length; i++) {
                                names.add(v[i]);
                            }
                        }
                        case "title" -> {
                            for (int i = 2; i < v.length; i++) {
                                titles.add(v[i]);
                            }
                        }
                        case "email" -> {
                            for (int i = 2; i < v.length; i++) {
                                emails.add(v[i]);
                            }
                        }
                    }
                }
                case "references" -> {
                    switch (v[1].toLowerCase()) {
                        case "referee 1" -> {
                            for (int i = 2; i <= 5; i++) {
                                references.add(v[i]);
                            }
                            for (int i = 6; i < v.length; i++) {
                                references.add(v[i]);
                            }
                        }
                        case "referee 2" -> {
                            for (int i = 2; i <= 5; i++) {
                                references.add(v[i]);
                            }
                            for (int i = 6; i < v.length; i++) {
                                references.add(v[i]);
                            }
                        }
                    }

                }
            }
        }
        catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(names);
    System.out.println(titles);
    System.out.println(emails);
}

    public void writeSuperCsv(String filename)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            bw.write("Section," + "Sub-Section," + "Variants");
            bw.newLine();
            bw.write("User,Name," + String.join(",", names));
            bw.newLine();
            bw.write("User,Title," + String.join(",", titles));
            bw.newLine();
            bw.write("User,Email," + String.join(",", emails));
            bw.newLine();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}