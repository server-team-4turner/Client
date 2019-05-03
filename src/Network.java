import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Network {
	public static Scanner makeRequest(String urlString) throws IOException {
		URL url = new URL(urlString);
		URLConnection con = url.openConnection();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
		return new Scanner(buffer);
	}
}
