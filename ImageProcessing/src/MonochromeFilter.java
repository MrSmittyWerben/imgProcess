/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Gibt Bilder schwarz-weiss zurück
 *
 */
public class MonochromeFilter extends PixelFilter implements Filter {
	private	Utility helper = new Utility();
	
	@Override
	public int calculate(int pixelColor) {
		int grau = helper.grey(helper.getRed(pixelColor),helper.getGreen(pixelColor),helper.getBlue(pixelColor));
		
		return helper.setColor(grau, grau, grau);
	}
	
}

