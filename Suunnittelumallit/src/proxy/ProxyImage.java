package proxy;

public class ProxyImage implements Image{
    private final String filename;
    private RealImage image;
    
    /**
     * Constructor
     * @param filename
     */
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
           image = new RealImage(filename);
        }
        image.displayImage();
    }

	@Override
	public String getData() {
		String descript;
		if(image==null) {
			descript = " -- Image not loaded";
		} else {
			descript = " -- Image is loaded";
		}
		return filename + descript;
	}
}
