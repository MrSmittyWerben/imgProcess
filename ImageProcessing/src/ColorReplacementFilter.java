import java.awt.Color;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 *
 *Ändert eine Farbe des Bildes zu einer anderen
 */
public class ColorReplacementFilter extends PixelFilter implements Filter {
	private Utility helper = new Utility();
	private Color replaceFarbe;
	private Color farbeToReplace;

	/**
	 * @param farbeToReplace
	 * @param replaceFarbe
	 */
	public ColorReplacementFilter(Color farbeToReplace, Color replaceFarbe) {
		this.farbeToReplace = farbeToReplace;
		this.replaceFarbe = replaceFarbe;
	}

	/**
	 * @param farbeToReplace
	 */
	public ColorReplacementFilter(Color farbeToReplace) { // falls keine zweite Farbe angegeben wird
		this.farbeToReplace = farbeToReplace;
		final int AREA = 255;
		int randR = (int) (Math.random() * AREA) + 1;
		int randB = (int) (Math.random() * AREA) + 1;
		int randG = (int) (Math.random() * AREA) + 1;
		this.replaceFarbe = new Color(randR, randB, randG);
	}

	@Override
	public int calculate(int pixelColor) {
		int r = helper.getRed(pixelColor);
		int g = helper.getGreen(pixelColor);
		int b = helper.getBlue(pixelColor);
		if (farbeToReplace.getRed() == r && farbeToReplace.getGreen() == g && farbeToReplace.getBlue() == b) {
			r = replaceFarbe.getRed();
			g = replaceFarbe.getGreen();
			b = replaceFarbe.getBlue();
		}
		return helper.setColor(r, g, b);
	}
}
