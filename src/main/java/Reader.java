import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by karenvega on 9/30/16.
 */
public class Reader {

    public void read() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            System.out.println(line + " line...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
