import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Klasse zur Steuerung
 *
 */
public class Controller {

	/**
	 * @param args
	 * 
	 * main, verarbeitet eingegebene Argumente, steuert das Img Processing
	 */
	public static void main(String[] args) {

		FilterVerwaltung Verwaltung = new FilterVerwaltung();
		BufferedImage img = null, mask = null;
		String input, output = null, key = null, maskName = null;
		boolean test = false;
		if (args[0].equals("test")) {
			test = true;
		} else if (!args[0].equals("test")) {
			key = args[0];
		}
		input = args[1];
		if (args[2].equals("-m")) {
			maskName = args[3];
			output = args[4];
		} else if (!args[2].equals("-m")) {
			output = args[2];
		}
		try {
			img = ImageIO.read(new File(input));
		} catch (IOException e) {
		}
		if (maskName != null) {
			try {
				mask = ImageIO.read(new File(maskName));
			} catch (IOException e) {
			}
		}
		if (test) {
			testMode(img, mask, key, Verwaltung, output, input);
		} else {
			filter(img, mask, key, Verwaltung, output);
		}
	}

	/**
	 * @param img
	 * @param mask
	 * @param key
	 * @param Verwaltung
	 * @param output
	 * @param input
	 * 
	 * 
	 * Test Modus, ruft alle Filter hintereinander auf
	 */
	public static void testMode(BufferedImage img, BufferedImage mask, String key, FilterVerwaltung Verwaltung,
			String output, String input) {

		BufferedImage[] pic = new BufferedImage[Verwaltung.verwalten().size()];
		for (int i = 0; i < Verwaltung.verwalten().size(); i++) {
			try {
				pic[i] = ImageIO.read(new File(input));
			} catch (IOException e) {
			}
		}
		int i = 0;
		for (Map.Entry<String, Filter> entry : Verwaltung.verwalten().entrySet()) {
			BufferedImage result = null;
			Filter x = null;
			if (mask != null) {
				x = Verwaltung.verwalten().get(entry.getKey());
				result = x.process(pic[i], mask);
			} else {
				x = Verwaltung.verwalten().get(entry.getKey());
				result = x.process(pic[i]);
			}
			try {
				ImageIO.write(result, "bmp", new File(entry.getKey() + "_" + output));
			} catch (IOException e) {
				System.out.println("Fehler beim Speichern von " + entry.getKey() + "_" + output);
			}
			i++;
		}
	}

	/**
	 * @param img
	 * @param mask
	 * @param key
	 * @param Verwaltung
	 * @param output
	 * 
	 * Aufruf der process Methode, Anwenden auf das Bild
	 */
	public static void filter(BufferedImage img, BufferedImage mask, String key, FilterVerwaltung Verwaltung,
			String output) {

		BufferedImage result = null;
		Filter filter = null;
		if (mask != null) {
			filter = Verwaltung.verwalten().get(key);
			result = filter.process(img, mask);
		} else {
			filter = Verwaltung.verwalten().get(key);
			result = filter.process(img);
		}
		try {
			ImageIO.write(result, "bmp", new File(key + "_" + output));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}