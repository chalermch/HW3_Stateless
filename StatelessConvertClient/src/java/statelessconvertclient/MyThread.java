/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessconvertclient;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mybean.StatelessConvertBeanRemote;

/**
 *
 * @author Admin
 */
public class MyThread extends Thread {

    StatelessConvertBeanRemote convertBean = lookupStatelessConvertBeanRemote();
    private double f;

    public MyThread(double f) {
        this.f = f;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            sleep(r.nextInt(10));
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(f + " Fahrenheit = " + convertBean.fToC(f) + " Celsius");
    }

    private StatelessConvertBeanRemote lookupStatelessConvertBeanRemote() {
        try {
            Context c = new InitialContext();
            return (StatelessConvertBeanRemote) c.lookup("java:comp/env/StatelessConvertBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
