
import java.awt.image.BufferedImage;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Abstrakte Klasse für alle Area Filter
 *
 */
public abstract class AreaFilter implements Filter {
	
	
	
/*
 * 
 * @param: BufferedImage
 * @return: bearbeitetes Bild
 * 
 * Vearbeitet das Bild, ruft calculate auf
 */
	public BufferedImage process(BufferedImage... img) {

		BufferedImage newImg;

		int[] pixel;
		int[] maskPixel = null;

		if (img.length >1) {
			maskPixel = new int[img[1].getHeight() * img[1].getWidth()];
			maskPixel = img[1].getRGB(0, 0, img[1].getWidth(), img[1].getHeight(), null, 0, img[1].getWidth());
		}

		pixel = new int[img[0].getHeight() * img[0].getWidth()];
		pixel = img[0].getRGB(0, 0, img[0].getWidth(), img[0].getHeight(), null, 0, img[0].getWidth());

		newImg = new BufferedImage(img[0].getWidth(), img[0].getHeight(), BufferedImage.TYPE_INT_RGB);

		if (maskPixel != null) {
			for (int i=0; i<maskPixel.length -1; i++) {
			if (maskPixel[i] != -1) {
					pixel[i] = calculate(pixel, maskPixel, i, img[0].getWidth(), img[0].getHeight());
				}

			}
		} else {
			for (int i = 0; i < pixel.length - 1; i++) {
				pixel[i] = calculate(pixel, maskPixel, i, img[0].getWidth(), img[0].getHeight());
			}
		}

		newImg.setRGB(0, 0, img[0].getWidth(), img[0].getHeight(), pixel, 0, img[0].getWidth());
		
		return newImg;
	}

	/**
	 * @param pixel
	 * @param maskPixel
	 * @param index
	 * @param width
	 * @param height
	 * @return bearbeitetes Pixel
	 * 
	 * Bearbeitet alles Pixel des Bildes
	 */
	public abstract int calculate(int[] pixel, int[] maskPixel, int index, int width, int height);
}
