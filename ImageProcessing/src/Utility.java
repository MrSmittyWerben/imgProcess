

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Helfer Klasse für häufige Berechnungen
 *
 */
public class Utility {

	public Utility() {
		
	}
	
	/**
	 * @param pixelColor
	 * @return rot
	 * 
	 * holt rot-Anteil des Pixels
	 */
	public int getRed(int pixelColor){
		return (pixelColor&0xff0000)>>16;
	}
	
	/**
	 * @param pixelColor
	 * @return grün-anteil
	 * 
	 * gibt gruen-anteil des Pixels
	 */
	public int getGreen(int pixelColor){
		return (pixelColor&0xff00)>>8;
	}
	
	/**
	 * @param pixelColor
	 * @return Blau-Anteil
	 * 
	 * holt Blau-Anteil des Pixels
	 */
	public int getBlue(int pixelColor){
		return (pixelColor&0xff);
	}
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 * @return grau
	 * 
	 * Setzt Farbe Grau
	 */
	public int grey(int r, int g, int b) {
		return (r+g+b)/3;
			
	}
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 * @return Farbe
	 * 
	 * Setzt eine Farbe mit angegebenen rgb werten
	 */
	public int setColor(int r, int g, int b){
		return r<<16|g<<8|b;
		
	}
}

