import java.util.ArrayList;

public class ImagePost extends TextPost {
	
	private String imageName;
	private int xdimension, ydimension;
	
	public ImagePost (String text, double latitude, double longitude, ArrayList<User> tagged, int xdimansion, int ydimension, String imageName){
		super(text, latitude, longitude, tagged);
		this.setImageName(imageName);
		this.setXdimension(ydimension);
		this.setYdimension(ydimension);
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getXdimension() {
		return xdimension;
	}
	public void setXdimension(int xdimension) {
		this.xdimension = xdimension;
	}
	public int getYdimension() {
		return ydimension;
	}
	public void setYdimension(int ydimension) {
		this.ydimension = ydimension;
	}

}
