/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class StatelessConvertBean implements StatelessConvertBeanRemote {
    double c = 0;
    @Override
    public double fToC(double f) {
         c = (5 / 9) * (f - 32);
        return c;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
