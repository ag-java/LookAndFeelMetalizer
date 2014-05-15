import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import xy.lib.theme.EqualizedTheme;
import xy.lib.theme.ThemeEqualizerDialog;

public class Usage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final JFrame applicationWindow = new JFrame("Metalizer Test");
		applicationWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		applicationWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				/*
				 * A Metalizer theme is a 'EqualizedTheme' object.
				 * It is defined by 3 values: 
				 * - hue
				 * - saturation
				 * - brightness 
				 * Each value is an integer between 0 and 255.
				 * Example:
				 */
				int hue = 0;
				int saturation = 0;
				int brightness = 0;
				EqualizedTheme myTheme = new EqualizedTheme(hue, saturation,
						brightness);
				
				/*
				 * To enable the theme, 
				 * include the following code in your application
				 * before creating any controls:
				 */
				try {
					myTheme.apply();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				/*
				 * If the controls are already created, then use:
				 */
				SwingUtilities.updateComponentTreeUI(applicationWindow);
				
				
				/*
				 * Use the following code to
				 * open the theme selection window:
				 */
				EqualizedTheme selectedTheme = ThemeEqualizerDialog
						.open(applicationWindow, myTheme);
				System.out.println("Selected theme values: hue="
						+ selectedTheme.getHueOffset() + ", saturation="
						+ selectedTheme.getSaturationOffset() + ", brightness="
						+ selectedTheme.getBrightnessOffset());
				}

		});
		applicationWindow.setVisible(true);
	}

}
