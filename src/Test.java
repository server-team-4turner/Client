import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		Scanner resp = Network.makeRequest("http://google.com");
		while (resp.hasNext())
			System.out.println(resp.next());
	}
}
