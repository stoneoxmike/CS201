import java.util.ArrayList;

/**
 * The model for the disk game
 * which stores and ArrayList of Disks
 */
public class DiskModel {
	// TODO: add fields.
	private ArrayList<Disk> disks;

	/**
	 * Constructor.
	 * Creates empty ArrayList
	 */
	public DiskModel() {
		//throw new UnsupportedOperationException("TODO - implement");
		disks = new ArrayList<Disk>();
	}
	
	/**
	 * @return the ArrayList of Disks
	 */
	public ArrayList<Disk> getDisks() {
		//throw new UnsupportedOperationException("TODO - implement");
		return disks;
	}
	
	/**
	 * @return the number of placed disks
	 */
	public int getNumDisks() {
		//throw new UnsupportedOperationException("TODO - implement");
		return disks.size();
	}
	
	/**
	 * Add a new disk to the ArrayList
	 * 
	 * @param disk Disk to add
	 */
	public void addDisk(Disk disk) {
		//throw new UnsupportedOperationException("TODO - implement");
		disks.add(disk);
	}

}
