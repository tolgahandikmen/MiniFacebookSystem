import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadFile {

	public ArrayList<User> readFileUsers(String file) {

		ArrayList<User> users = new ArrayList<User>();

		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(file));

			DateFormat Date_Format = new SimpleDateFormat("dd/MM/yyyy");
			while ((line = br.readLine()) != null) {
				String[] word = line.split("\t");
				Date birth;
				try {
					birth = Date_Format.parse(word[3]);
					users.add(new User(word[0], word[1], word[2], word[4], word[5], birth));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return users;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public void readFileCommands(String file, ArrayList<User> users) {

		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				String[] word = line.split("\t");
				if (word[0].equals("ADDFRIEND")) {
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getUsername().equals(word[1])) {
							for (int j = 0; j < users.size(); j++) {
								if (users.get(j).getUsername().equals(word[2])) {
									if (!(users.get(j).getContact().contains(users.get(i))
											|| users.get(i).getContact().contains(users.get(j)))) {
										users.get(i).getContact().add(users.get(j));
										users.get(j).getContact().add(users.get(i));
									}
								}
							}
						}
					}
				} else if (word[0].equals("BLOCKFRIEND")) {
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getUsername().equals(word[1])) {
							for (int j = 0; j < users.size(); j++) {
								if (users.get(j).getUsername().equals(word[2])) {
									if (users.get(j).getContact().contains(users.get(i))
											|| users.get(i).getContact().contains(users.get(j))) {
										users.get(i).getContact().remove(users.get(j));
										users.get(i).getBlocked().add(users.get(j));
										users.get(j).getContact().remove(users.get(i));
										for (int j2 = 0; j2 < users.get(i).getPosts().size(); j2++) {
											users.get(i).getPosts().get(j2).getTagged().remove(j);
										}
										for (int j2 = 0; j2 < users.get(j).getPosts().size(); j2++) {
											users.get(j).getPosts().get(j2).getTagged().remove(i);
										}
									}
								}
							}
						}
					}

				} else if (word[0].equals("ADDPOST-TEXT")) {
					ArrayList<User> tempTagged = new ArrayList<User>();

					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getUsername().equals(word[1])) {
							double lat = Double.parseDouble(word[3]);
							double longt = Double.parseDouble(word[4]);

							String[] taggedWords = word[5].split(":");
							for (int j = 0; j < taggedWords.length; j++) {
								for (int j2 = 0; j2 < users.get(i).getContact().size(); j2++) {
									if (taggedWords[j].equals(users.get(i).getContact().get(j2).getUsername())) {
										tempTagged.add(users.get(i).getContact().get(j2));
									}
								}
							}
							users.get(i).getPosts().add(new TextPost(word[2], lat, longt, tempTagged));
						}
					}
				} else if (word[0].equals("ADDPOST-IMAGE")) {
					ArrayList<User> tempTagged = new ArrayList<User>();

					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getUsername().equals(word[1])) {
							double lat = Double.parseDouble(word[3]);
							double longt = Double.parseDouble(word[4]);
							String[] tempDim = word[7].split("<x>");
							int tempx = Integer.parseInt(tempDim[0]);
							int tempy = Integer.parseInt(tempDim[1]);
							
							String[] taggedWords = word[5].split(":");
							for (int j = 0; j < taggedWords.length; j++) {
								for (int j2 = 0; j2 < users.get(i).getContact().size(); j2++) {
									if (taggedWords[j].equals(users.get(i).getContact().get(j2).getUsername())) {
										tempTagged.add(users.get(i).getContact().get(j2));
									}
								}
							}
							
							users.get(i).getPosts().add(new ImagePost(word[2], lat, longt, tempTagged, tempx, tempy, word[6]));
						}
					}

				} else if (word[0].equals("ADDPOST-VIDEO")) {
					ArrayList<User> tempTagged = new ArrayList<User>();

					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getUsername().equals(word[1])) {
							double lat = Double.parseDouble(word[3]);
							double longt = Double.parseDouble(word[4]);
							int duration = Integer.parseInt(word[7]);

							String[] taggedWords = word[5].split(":");
							for (int j = 0; j < taggedWords.length; j++) {
								for (int j2 = 0; j2 < users.get(i).getContact().size(); j2++) {
									if (taggedWords[j].equals(users.get(i).getContact().get(j2).getUsername())) {
										tempTagged.add(users.get(i).getContact().get(j2));
									}
								}
							}
							
							users.get(i).getPosts().add(new VideoPost(word[2], lat, longt, tempTagged, word[6], duration));
						}
					}
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;

	}
}
