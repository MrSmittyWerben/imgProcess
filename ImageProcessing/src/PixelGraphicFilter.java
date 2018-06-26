

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Verpixelt das Bild mit angegebener block groesse
 *
 */
public class PixelGraphicFilter extends AreaFilter {
	private Utility helper = new Utility();
	private int radius;

	/**
	 * @param area
	 */
	public PixelGraphicFilter(int area) {
		this.radius = area;
	}

	@Override
	public int calculate(int[] pixel, int[] maskPixel, int index, int width, int height) {
	
		int row = index%width;
		int column = index/width;
		int startRow = row/radius*radius;
		int startColumn = column/radius*radius;
		int avgR=0, avgB=0, avgG=0;
		
		for (int i = startRow; i< startRow+radius && i < width; i++) {
			for (int j = startColumn; j < startColumn+radius && j < height; j++) {
				int pixelColor = pixel[width* j + i];
				avgR+= helper.getRed(pixelColor);
			    avgB+= helper.getBlue(pixelColor);
		       	avgG+= helper.getGreen(pixelColor);
			}
		}
	avgR/=radius*radius;
	avgG/=radius*radius;
	avgB/=radius*radius;
	
	return  helper.setColor(avgR, avgG, avgB);
		
		

	}

}
