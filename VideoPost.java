import java.util.ArrayList;

public class VideoPost extends TextPost {

	private String videoName;
	private int duration;

	public VideoPost(String text, double latitude, double longitude, ArrayList<User> tagged, String videoName,
			int duration) {
		super(text, latitude, longitude, tagged);
		this.setVideoName(videoName);
		this.setDuration(duration);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

}
