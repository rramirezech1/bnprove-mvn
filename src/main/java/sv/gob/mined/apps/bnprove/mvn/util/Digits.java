/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.util;

/**
 *
 * @author RMendez
 */
public class Digits {
    static int count_digit(int x)
    {
        int count = 0;
        while (x != 0) {
            x = x / 10;
            ++count;
        }
        return count;
    }
}
