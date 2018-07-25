import java.util.ArrayList;

public class TextPost extends Post {
	
	private String text;

	public TextPost(String text, double latitude, double longitude, ArrayList<User> tagged){
		super(latitude, longitude, tagged);
		this.setText(text);
	}
	public TextPost(){
		
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
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setVideoName(String videoName) {
	}
}
