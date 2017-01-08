//    Chromis POS  - The New Face of Open Source POS
//    Copyright (c) (c) 2015-2016
//    http://www.chromis.co.uk
//
//    This file is part of Chromis POS
//
//     Chromis POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Chromis POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>.

package uk.chromis.pos.sync;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.SubstanceSkin;
import uk.chromis.pos.forms.AppConfig;
import uk.chromis.pos.forms.AppLocal;
import uk.chromis.pos.forms.JRootFrame;

public class JFrmSync extends javax.swing.JFrame {
    
    private JPanelManualSync config;
    
    public JFrmSync() {
        initComponents();        
        try {
            this.setIconImage(ImageIO.read(JRootFrame.class.getResourceAsStream("/uk/chromis/fixedimages/smllogo.png")));
        } catch (IOException e) {
        }   
      
       setTitle(AppLocal.APP_NAME +  " - Manual Synchronisation"); 
        addWindowListener(new MyFrameListener());         
        config = new JPanelManualSync(null);        
        getContentPane().add(config, BorderLayout.CENTER);       
        config.activate();
    }
    
    private class MyFrameListener extends WindowAdapter{
        
        @Override
        public void windowClosing(WindowEvent evt) {
            if (config.deactivate()) {
                dispose();
            }
        }
        @Override
        public void windowClosed(WindowEvent evt) {
            System.exit(0);
        }
    }    
      /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 507) / 2, (screenSize.height - 304) / 2, 507, 304);
    }// </editor-fold>//GEN-END:initComponents  
    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                AppConfig config = AppConfig.getInstance();
                new JFrmSync(config).setVisible(true);                

            }
        });
*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                AppConfig config = AppConfig.getInstance();

// Set the look and feel.
                try {
                    Object laf = Class.forName(AppConfig.getInstance().getProperty("swing.defaultlaf")).newInstance();
                    if (laf instanceof LookAndFeel) {
                        UIManager.setLookAndFeel((LookAndFeel) laf);
                    } else if (laf instanceof SubstanceSkin) {
                        SubstanceLookAndFeel.setSkin((SubstanceSkin) laf);
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }

                JFrmSync resetFrame = new JFrmSync();//
                resetFrame.setSize(600, 350);
                resetFrame.setVisible(true);

            }
        });


    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
