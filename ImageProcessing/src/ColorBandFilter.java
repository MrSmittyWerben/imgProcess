


/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Legt Farbfilter über das Bild
 *
 */
public class ColorBandFilter extends PixelFilter implements Filter {
	private	Utility helper = new Utility();
	
	public enum ColorBand{ // Enum zur Verwaltung
		RED,GREEN,BLUE;
	}
	
	ColorBand farbe;
	
	/**
	 * @param farbe
	 */
	public ColorBandFilter(ColorBand farbe) {
		this.farbe = farbe;
	}
	
	
	@Override
	public int calculate(int pixelColor) {
		
		switch(farbe) {
			
		case RED:
			pixelColor = helper.getRed(pixelColor)<<16;
			break;
		
		case GREEN:
			pixelColor = helper.getGreen(pixelColor)<<8;
			break;
			
		case BLUE:
			pixelColor = helper.getBlue(pixelColor);
		}
		
		
		
		return pixelColor;
		
	}
	
	
}
