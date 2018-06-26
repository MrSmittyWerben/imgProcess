import java.awt.image.BufferedImage;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 *	Interface f�rs Img Processing
 */
public interface Filter {

	/**
	 * 
	 * 
	 * process Methode f�r alle Bilder
	 * @param img
	 * @return Bearbeitets Bild
	 */
	public BufferedImage process(BufferedImage... img);

}
