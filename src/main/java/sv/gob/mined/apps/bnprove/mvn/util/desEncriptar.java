/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.util;

/**
 *
 * @author RAREcheverria
 */
public class desEncriptar {
    
    public desEncriptar() {}
  
    public static String encriptar(String paramString){
        String str1 = "CGI";
        String str2 = "";
    
        int m = 0;
        int n = 0;

        int j = 0;
        int k = str1.length() - 1;

        for (int i = 0; i < paramString.length(); i++)
        {
          m = paramString.charAt(i);
          n = str1.charAt(j);

          m += n;


          while (m > 255) {
            m -= 255;
          }
          char c = (char)m;

          str2 = str2 + c;

          j++;
          if (j > k)
            j = 0;
        }
        return str2;
    }
  
    public static String desencriptar(String paramString)
    {
      String str1 = "CGI";
      String str2 = "";

      int m = 0;
      int n = 0;

      int j = 0;
      int k = str1.length() - 1;

      for (int i = 0; i < paramString.length(); i++)
      {
        m = paramString.charAt(i);
        n = str1.charAt(j);

        m -= n;

        while (m < 0) {
          m += 255;
        }
        char c = (char)m;

        str2 = str2 + c;

        j++;
        if (j > k)
          j = 0;
      }
      return str2;
    }
}