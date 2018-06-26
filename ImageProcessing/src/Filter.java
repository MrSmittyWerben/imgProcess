import java.awt.image.BufferedImage;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 *	Interface fürs Img Processing
 */
public interface Filter {

	/**
	 * 
	 * 
	 * process Methode für alle Bilder
	 * @param img
	 * @return Bearbeitets Bild
	 */
	public BufferedImage process(BufferedImage... img);

}
