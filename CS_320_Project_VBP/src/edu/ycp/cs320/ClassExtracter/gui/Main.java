/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ycp.cs320.ClassExtracter.gui;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author npaulovi
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame =new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				SoftwareD_GUI2 view = null;
				//try {
					view = new SoftwareD_GUI2();
					//} catch (FileNotFoundException ex) {
					//    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
					//}

					frame.setContentPane(view);

					frame.pack();
					frame.setVisible(true);
			}

		});
	}

}
