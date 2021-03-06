import xy.lib.theme.EqualizedTheme;
import xy.lib.theme.ThemeEqualizerDialog;

public class Example {

	public static void main(String[] args) {
		/*
		 * The jar file is runnable.
		 * 
		 * To run:
		 * 
		 * either double-click on the jar file (OS-dependant) or run this command: java
		 * -jar specifyTheDownloadedJarFile
		 * 
		 * By default it will:
		 * 
		 * open the theme selection dialog try to download and open a test application
		 * 
		 * A Metalizer theme is an 'EqualizedTheme' object. It is defined by 3 values:
		 * hue, saturation and brightness. Each value is an integer between 0 and 255.
		 * Open the theme selection dialog to find out your preferred values. Example:
		 */
		int hue = 0;
		int saturation = 0;
		int brightness = 0;
		EqualizedTheme myTheme = new EqualizedTheme(hue, saturation, brightness);
		/*
		 * To enable the theme, include the following code in your application before
		 * creating any controls:
		 */
		try {
			myTheme.activate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		/*
		 * If the controls are already created, then use:
		 * 
		 * SwingUtilities.updateComponentTreeUI(applicationWindow);
		 * 
		 * Use the following code to open the theme selection window:
		 */
		EqualizedTheme selectedTheme = ThemeEqualizerDialog.open(null, myTheme);
		if (selectedTheme == null) {
			System.out.println("Theme selection cancelled");
		} else {
			System.out.println("Selected theme values: hue=" + selectedTheme.getHueOffset() + ", saturation="
					+ selectedTheme.getSaturationOffset() + ", brightness=" + selectedTheme.getBrightnessOffset());
		}

	}

}
