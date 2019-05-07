import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		Connection conn = new Connection("localhost:8000");
		Scanner resp = conn.call("random", 10);

		while (resp.hasNext())
			System.out.println(resp.next());
	}
}
