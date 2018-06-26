/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 *
 *reduziert angegebene Farbwerte auf Schwarz-weiss
 */
public class ThresholdFilter extends PixelFilter implements Filter {
	private Utility helper = new Utility();
	private int[] threshold;

	/**
	 * @param threshold
	 */
	public ThresholdFilter(int... threshold) {
		this.threshold = threshold;
	}

	@Override
	public int calculate(int pixelColor) {

		int grau1 = 92;
		int grau2 = 160;
		int grau3 = 255;
		int grau = (helper.grey(helper.getRed(pixelColor), helper.getGreen(pixelColor), helper.getBlue(pixelColor)));
		if (threshold.length == 1) { // Threshold einfach
			if (grau < threshold[0]) {
				return helper.setColor(0, 0, 0);
			}
			if (grau >= threshold[0]) {
				return helper.setColor(255, 255, 255);
			}
			return 0;
		} else { // Multithreshold
			if (grau < threshold[0]) {
				return helper.setColor(0, 0, 0);
			}
			if (grau >= threshold[0] && grau < threshold[1]) {
				return helper.setColor(grau1, grau1, grau1);
			}
			if (grau >= threshold[1] && grau < threshold[2]) {
				return helper.setColor(grau2, grau2, grau2);
			}
			if (grau > threshold[2]) {
				return helper.setColor(grau3, grau3, grau3);
			}
		}
		return 0;
	}
}
