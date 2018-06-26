import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 *	Klasse der Filter
 */
public class FilterVerwaltung {

	/**
	 * @return Filter Map
	 * 
	 * Erzeugen und Verwalten aller Filter, Abruf aus der Map durch key
	 */
	public Map<String, Filter> verwalten() {

		Map<String, Filter> filterMap = new HashMap<String, Filter>();
		
		

		Filter blur_3 = new BlurFilter(3);
		Filter blur_5 = new BlurFilter(5);

		Filter monochrome = new MonochromeFilter();

		Filter threshold_128 = new ThresholdFilter(128);
		Filter threshold_192 = new ThresholdFilter(192);
		Filter multithreshold = new ThresholdFilter(64, 128, 192);

		Filter colorband_red = new ColorBandFilter(ColorBandFilter.ColorBand.RED);
		Filter colorband_green = new ColorBandFilter(ColorBandFilter.ColorBand.GREEN);
		Filter colorband_blue = new ColorBandFilter(ColorBandFilter.ColorBand.BLUE);

		Filter colorreplacement_0 = new ColorReplacementFilter(new Color(0, 0, 0));
		Filter colorreplacement_98 = new ColorReplacementFilter(new Color(98, 98, 98));
		Filter colorreplacement_160 = new ColorReplacementFilter(new Color(160, 160, 160));
		Filter colorreplacement_255 = new ColorReplacementFilter(new Color(255, 255, 255), new Color(0, 0, 0)); 
																												

		Filter pixel_20 = new PixelGraphicFilter(3);
		Filter pixel_40 = new PixelGraphicFilter(40);
		Filter pixel_60 = new PixelGraphicFilter(60);
		
		Filter brightness_50 =  new BrightnessFilter(50);

		Filter warhol = new ChainFilter();
		((ChainFilter) warhol).add(multithreshold);
		((ChainFilter) warhol).add(colorreplacement_0);
		((ChainFilter) warhol).add(colorreplacement_98);
		((ChainFilter) warhol).add(colorreplacement_160);
		((ChainFilter) warhol).add(colorreplacement_255);

		filterMap.put("warhol", warhol);
		filterMap.put("blur_3", blur_3);
		filterMap.put("blur_5", blur_5);
		filterMap.put("monochrome", monochrome);
		filterMap.put("colorband_red", colorband_red);
		filterMap.put("colorband_green", colorband_green);
		filterMap.put("colorband_blue", colorband_blue);
		filterMap.put("threshold_128", threshold_128);
		filterMap.put("multithreshold", multithreshold);
		filterMap.put("threshold_192", threshold_192);
		filterMap.put("colorreplacement_98", colorreplacement_98);
		filterMap.put("colorreplacement_160", colorreplacement_160);
		filterMap.put("colorreplacement_255", colorreplacement_255);
		filterMap.put("pixel_20", pixel_20);
		filterMap.put("pixel_40", pixel_40);
		filterMap.put("pixel_60", pixel_60);
		filterMap.put("brightness_50", brightness_50);

		return filterMap;
	}

}
