import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Thilo Koenig, Mona Porcher, Christian Zekovic
 * 
 * Speichern verschiedener Filter in einer ArrayList
 *
 */

public class ChainFilter implements Filter {

	protected ArrayList<Filter> filterList = new ArrayList<Filter>();

	@Override
	public BufferedImage process(BufferedImage... img) {
		for (Filter filter : this.filterList) {
			img[0] = filter.process(img);

		}

		return img[0];
	}

	/**
	 * @param filter
	 * 
	 * adden der Filter
	 */
	public void add(Filter filter) {
		this.filterList.add(filter);
	}
}
