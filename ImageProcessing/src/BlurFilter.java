/**
 * @author Thilo König, Mona Porcher, Christian Zekovic
 * 
 * Verzerrt das Bild mit angegeben Radius
 *
 */
public class BlurFilter extends AreaFilter {

	private Utility helper = new Utility();
	private int radius;

	/**
	 * @param radius
	 */
	public BlurFilter(int radius) {
		this.radius = radius;
	}

	@Override
	public int calculate(int[] pixel, int[] maskPixel, int index, int width, int heigth) {

		int pixelColor = 0;
		int red = 0, green = 0, blue = 0;
		int border = 0;
		for (int i = index - (radius * width); i <= index + (radius * width);) {
			if (i < (heigth * width) && i >= 0) {
				if (i != index) {
					red += helper.getRed(pixel[i]);
					green += helper.getGreen(pixel[i]);
					blue += helper.getBlue(pixel[i]);
				}
			} else {
				border++;
			}
			i += width;
		}
		for (int i = index - radius; i <= index + radius; i++) {
			if (i >= 0 && i < (heigth * width)) {
				red += helper.getRed(pixel[i]);
				green += helper.getGreen(pixel[i]);
				blue += helper.getBlue(pixel[i]);
			}
		}
		red /= (4 * radius + 1) - border;
		green /= (4 * radius + 1) - border;
		blue /= (4 * radius + 1) - border;
		pixelColor = helper.setColor(red, green, blue);
		return pixelColor;
	}
}
