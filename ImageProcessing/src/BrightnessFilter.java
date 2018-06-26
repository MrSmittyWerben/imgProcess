
public class BrightnessFilter extends PixelFilter implements Filter {
	private	Utility helper = new Utility();
	int helligkeit;
	
	public BrightnessFilter(int helligkeit){
		this.helligkeit = helligkeit;
	}

	@Override
	public int calculate(int pixelColor) {
		int red, green, blue;
		
		red = bearbeiten(helper.getRed(pixelColor)+ helligkeit);
		green = bearbeiten(helper.getGreen(pixelColor)+ helligkeit);
		blue = bearbeiten(helper.getBlue(pixelColor)+ helligkeit);
	
		return helper.setColor(red, green, blue);

	}
	
	public int bearbeiten(int color) {
		if(color < 0) {
			color = 0;
		}else if(color > 255) {
			color = 255;
		}
		return color;
	}
	
}