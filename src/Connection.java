import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Connection {
	public String url;

	public Connection(String url) {
		this.url = url;

		boolean http = this.url.substring(0, 7).equals("http://");
		boolean https = this.url.substring(0, 8).equals("https://");
		if (!http && https)
			this.url = "http://" + this.url;
		if (this.url.charAt(this.url.length() - 1) == '/')
			this.url = this.url.substring(0, this.url.length() - 1);
	}

	public Scanner call(Object... args) throws IOException {
		String call = "";
		for (Object i : args)
			call += "/" + i;
		return makeRequest(this.url + call);
	}

	public static Scanner makeRequest(String urlString) throws IOException {
		URL url = new URL(urlString);
		URLConnection con = url.openConnection();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
		return new Scanner(buffer);
	}
}
