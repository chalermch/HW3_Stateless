/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessconvertclient;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter degree in Fahrenheit : ");
        Scanner in = new Scanner(System.in);
        double f = in.nextDouble();
        MyThread myThread = new MyThread(f);
        myThread.start();
        try{
            myThread.join();
        }catch(InterruptedException e){
            
        }
    }
    
}
