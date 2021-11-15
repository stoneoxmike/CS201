import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Map colors to iteration counts based on the "frequency" of each iteration count.
// RGB colors are created using a trigonometric process for red, green, and blue
//    blue:  ranges from cos(0) * 255    to cos(PI/2) * 255 (decreases from low to high)
//    red:   ranges from sin(PI/2) * 255 to sin(0) * 255 (increases from low to high)
//    green: ranges from sin(0) * 255    to sin(PI) * 255 (starts/ends at 0, peaks in the middle)
public class ColorMappingColorChooser implements ColorChooser {

	// declare map references
	private TreeMap<Integer, Integer> iterCountMap;
	private HashMap<Integer, Integer> iterSpectrumMap;
	private HashMap<Integer, Color>   iterColorMap;
	
	// the max spectrum location - should always be Mandelbrot.WIDTH * Mandelbrot.HEIGHT
	//    but it is calculated in createIterSpectrumMap()
	private int maxLocation;
	
	
	// CONSTRUCTOR: creates the 3 maps, but doesn't populate them
	// the maps will need to be populated separately
	// this allows for separate testing of the constituent Map creation methods
	ColorMappingColorChooser() {
		
		// create the Maps, but don't populate them
		iterCountMap    = new TreeMap<Integer, Integer>();
		iterSpectrumMap = new HashMap<Integer, Integer>();
		iterColorMap    = new HashMap<Integer, Color>();
	}	
	
	
	// CONSTRUCTOR: creates all 3 Maps and populates them
	ColorMappingColorChooser(int[][] iterCounts) {
		
		// create the Maps
		iterCountMap    = new TreeMap<Integer, Integer>();
		iterSpectrumMap = new HashMap<Integer, Integer>();
		iterColorMap    = new HashMap<Integer, Color>();		
		
		// populate the Maps from iterCounts array
		createIterCountMap(iterCounts);
		createIterSpectrumMap();
		createIterColorMap();
	}

	
	// GET COLOR: returns the Color mapped to the iterCount in iterColorMap
	@Override
	public Color getColor(int iterCount) {
		
		// if invalid iterCount, return BLACK
		if (!iterColorMap.containsKey(iterCount)) {
			System.out.println("Invalid iterCount key: " + iterCount + ", set to BLACK");
			return Color.BLACK;
		}
		
		// otherwise return color from Color Map
		return iterColorMap.get(iterCount);
	}	

	// GET iterCountMap: returns the iterCountMap Map
	public TreeMap<Integer, Integer> getIterCountMap() {
		return iterCountMap;
	}

	// GET iterSpectrumMap: returns the iterSpectrumMap Map
	public HashMap<Integer, Integer> getIterSpectrumMap() {
		return iterSpectrumMap;
	}

	// GET iterColorMap: returns the iterColorMap Map
	public HashMap<Integer, Color> getIterColorMap() {
		return iterColorMap;
	}

	
	// TODO: implement the following method, which runs through the supplied iterCounts array,
	// TODO:    and creates a Map that stores the unique iterCount values (as keys), along with
	// TODO:    the number of occurrences of each iterCount value into the iterCountMap field
	// TODO: this map will be used to create the Spectrum Map

	// CREATE ITERCOUNT MAP: run through iterCounts array, and accumulate distribution of counts
	// for an 800 x 800 array, the # of points will be 640,000, but there can only be
	// maxCounts different iteration values
	// using a TreeMap since we will need sorted keys (iterCount values)
	public void createIterCountMap(int[][] iterCounts) {
		for (int i = 0; i < iterCounts.length; i++) {
			for (int j = 0; j < iterCounts[0].length; j++) {
				if (iterCountMap.containsKey(iterCounts[i][j])) {
					iterCountMap.put(iterCounts[i][j], iterCountMap.get(iterCounts[i][j]) + 1);
				} else {
					iterCountMap.put(iterCounts[i][j], 1);
				}
			}
		}
	}
	
	// TODO: Implement the following method, which runs through the keys of the iterCountMap,
	// TODO:    and creates a second Map that stores the same keys, along with the relative position
	// TODO:    of the corresponding Color in the color Spectrum in the iterSpectrumMap field
	// TODO: Note that this does not yet determine the Color for each iterCount value, but rather
	// TODO:    determines the relative distance between each iterCount in the Color spectrum.
	// TODO: The iterCount entries (the keys) from iterCountMap will need to be processed in ascending
	// TODO:    order.  As you run through the the keys of the iterCountMap, you should keep a running
	// TODO:    total (sum) of the values from iterCountMap.  The value of that running total will determine
	// TODO:    the starting location of the Spectrum band for each iterCount.  Center the Spectrum location
	// TODO:    within the band by adding 1/2 of the iterCount value for the current key to the current
	// TODO:    leading up to that key.  Add one to that value for rounding purposes:
	// TODO:        iterSprectrumMap value = running sum + occurrences / 2 + 1
	// TODO: Store the final running sum value in maxLocation - it should equal the number of points
	// TODO:    in the iterCounts[][] array.

	// CREATE ITER SPECTRUM MAP: run through iterCountMap, and determine the spectrum location (this
	// is not the actual color, but rather its relative location in the color spectrum), based on
	// the frequency (# of occurrences) for each iteration count in the iterCountMap
	public void createIterSpectrumMap() {
		int sum = 0;
		int centeredLocatoion = 0;
		for (int key : iterCountMap.keySet()) {
			centeredLocatoion = sum + (iterCountMap.get(key) / 2) + 1;
			iterSpectrumMap.put(key, centeredLocatoion);
			sum = sum + iterCountMap.get(key);
		}
		maxLocation = sum;
	}
	

	// TODO: Run through the iterSpectrumMap and create the iterColorMap, which maps the iterCount keys to
	// TODO:    an actual RGB Color.  The Color mapping is based on the relative position in the Spectrum that
	// TODO:    was determined when creating iterSpectrumMap.
	// TODO: Assign Colors based on the sine and cosine trig functions.  As the relative Spectrum location
	// TODO:    increases:
	// TODO:       blue goes from 255 to 0
	// TODO:       green goes from 0 to 255 and back to 0
	// TODO:       red goes from 0 to 255
	// TODO: Thus, the calculation for each Color component is:
	// TODO:       blue  = cos(SpectrumMap value / maxLocation * PI/2) * 255
	// TODO:       green = sin(SpectrumMap value / maxLocation * PI) * 255
	// TODO:       red   = sin(spectrumMap value / maxLocation * PI/2) * 255
	// TODO: Make sure to return black for the max iteration count 

	// CREATE ITER COLOR MAP: run through iterSpectrumMap, and create a color mapping
	// using trig functions to create a smooth transition between RGB color bands
	// an alternate color assignment method is provided that is linear (commented out)
	public void createIterColorMap() {
		for (int key : iterSpectrumMap.keySet()) {
			int blue = 0;
			int green = 0;
			int red = 0;
			if (key == Mandelbrot.THRESHOLD) {
				Color color = new Color(red, green, blue);
				iterColorMap.put(key, color);
			} else {
				blue = (int) (Math.cos((double) iterSpectrumMap.get(key) / maxLocation * Math.PI/2) * 255);
				green = (int) (Math.sin((double) iterSpectrumMap.get(key) / maxLocation * Math.PI) * 255);
				red = (int) (Math.sin((double) iterSpectrumMap.get(key) / maxLocation * Math.PI/2) * 255);
				Color color = new Color(red, green, blue);
				iterColorMap.put(key, color);
			}
		}
	}
}
