/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author Kumar BN
 */
public class Texteditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen(4000);
    // Normally, we'd call splash.showSplash() and get on with the program.
    // But, since this is only a test...
    splash.showSplashAndExit();
        TextEditorFrame frame=new TextEditorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
