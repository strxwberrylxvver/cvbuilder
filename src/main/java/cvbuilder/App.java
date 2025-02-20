/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cvbuilder;

import java.util.ArrayList;
import cvbuilder.model.CVData;
import cvbuilder.view.MainViewer;

public class App {
    public static ArrayList<String> names = new ArrayList<>();
    public static void main(String[] args) {
        CVData.getInstance();
        MainViewer mv = MainViewer.getInstance();
    }
    
}
