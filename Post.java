import java.util.ArrayList;

public class Post {

	private double latitude, longitude;
	private ArrayList<User> tagged = new ArrayList<User>();

	public Post(double latitude, double longitude, ArrayList<User> tagged) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setTagged(tagged);
	}

	public Post() {

	}

	public String getText() {
		return null;
	}

	public void setText(String text) {
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public ArrayList<User> getTagged() {
		return tagged;
	}

	public void setTagged(ArrayList<User> tagged) {
		this.tagged = tagged;
	}

	public String getImageName() {
		return null;
	}

	public void setImageName(String imageName) {
	}

	public int getXdimension() {
		return 0;
	}

	public void setXdimension(int xdimension) {
	}

	public int getYdimension() {
		return 0;
	}

	public void setYdimension(int ydimension) {
	}

	public int getDuration() {
		return 0;
	}

	public void setDuration(int duration) {
	}

	public String getVideoName() {
		return null;
	}

	public void setVideoName(String videoName) {
	}
}