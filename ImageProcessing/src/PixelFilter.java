

import java.awt.image.BufferedImage;

/**
 * Abstrakte Klasse für alle PixelFilter
 * 
 * 
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 *
 */
public abstract class PixelFilter {
	
	/** 
	 * Verarbeitet das Bild, übergibt jeden Pixel des Bildes an die calculate-Methode
	 * 
	 * 
	 * @param img
	 * @return BufferedImage
	 */
	public BufferedImage process(BufferedImage... img) {
		
		BufferedImage newImg;
		int[] pixel;
		int[] maskPixel = null;
		
		if(img.length>1) {
			maskPixel = new int[img[1].getHeight() * img[1].getWidth()];
			maskPixel = img[1].getRGB(0, 0, img[1].getWidth(), img[1].getHeight(), null, 0, img[1].getWidth());
		}
		
		
		pixel = new int[img[0].getHeight() * img[0].getWidth()];
		pixel = img[0].getRGB(0, 0, img[0].getWidth(), img[0].getHeight(), null, 0, img[0].getWidth());
		newImg = new BufferedImage(img[0].getWidth(), img[0].getHeight(), BufferedImage.TYPE_INT_RGB);
		
		if(maskPixel != null) {
			for(int i=0; i<maskPixel.length-1;i++) { // wenn die Maske geladen wird, werden nur Pixel die es auch in der Maske gibt bearbeitet
				if(maskPixel[i] != -1) {
					pixel[i] = calculate(pixel[i]); 
				}
			}
		}else {
		for( int i =0; i< pixel.length-1; i++) {
			pixel[i]= calculate(pixel[i]);
		}
		
		}
		newImg.setRGB(0, 0, img[0].getWidth(), img[0].getHeight(), pixel, 0, img[0].getWidth());		
		return newImg;
	}
	
	/**Gibt den bearbeiteten Pixel zurück 
	 * 
	 * @param pixelColor
	 * @return pixelColor
	 */
	public abstract int calculate(int pixelColor);
}
