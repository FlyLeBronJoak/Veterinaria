/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

 public class CopiarArchivo {
    
          public CopiarArchivo(String sourceFile, String destinationFile) {
            System.out.println("Desde: " + sourceFile);
            System.out.println("Hacia: " + destinationFile);

            try {
                File inFile = new File(sourceFile);
                File outFile = new File(destinationFile);

                FileInputStream in = new FileInputStream(inFile);
                FileOutputStream out = new FileOutputStream(outFile);

                int c;
                while( (c = in.read() ) != -1)
                    out.write(c);

                in.close();
                out.close();
            } catch(IOException e) {
            
                 JOptionPane.showMessageDialog(null, e);
            }
        }

        

    }

    