/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf01_fitnesstracker;

import java.util.Scanner;

/**
 *
 * @author marle
 */
public class INF01_Fitnesstracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
         
        System.out.println("Welcome to the BMI Calculator!");
        System.out.println("Please provide your weight in kg:");
        double gewicht = myScanner.nextDouble();
        System.out.println("Please provide your height(Bsp 1,80):");
        double groesse = myScanner.nextDouble();
         
        double bmi = bmiRechner(groesse, gewicht);
        ausgabe(bmi);
    }
    //Ausgabe des BMI und Auswahl des passenden Namen.
    private static void ausgabe(double bmi) {       
        System.out.print("Youre BMI is: " + bmi + " ");
        if(bmi <16) {
            System.out.println("Starkes Untergewicht!");
        }else if(bmi>=16 && bmi<17) {
            System.out.println("Mäßiges Untergewicht.");
        }else if(bmi>=17 && bmi<18.5) {
            System.out.println("Leichtes Untergewicht.");
        }else if(bmi>=18.5 && bmi<25) {
            System.out.println("Normalgewicht!");
        }else if(bmi>=25 && bmi<30) {
            System.out.println("Präadipositas.");
        }else if(bmi>=30 && bmi<35) {
            System.out.println("Adipositas Grad I.");
        }else if(bmi>=35 && bmi<40) {
            System.out.println("Adipositas Grad II");
        }else if(bmi>= 40) {
            System.out.println("Adipositas Grad III");
        }else {
            System.out.println("Bitte überprüfe deine Eingabe!");
        }
}
 
    private static double bmiRechner(double groesse, double gewicht) {
        //BMI ausrechnen kg/m**2
        double bmi = gewicht / (groesse*groesse);
        //BMI auf 2 Nachkommastellen runden.
        double d = Math.pow(10, 2);
        return Math.round(bmi * d) / d;
    }}
