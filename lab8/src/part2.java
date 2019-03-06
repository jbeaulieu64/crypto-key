import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class part2 {
    public static void main(String[] args) {
        HashTester ht = null;
        try {
            ht = new HashTester("SHA-256");
            FileInputStream fis = new FileInputStream(args[0]);
            byte[] bytes = new byte[1];
            int nb = 0;
            while ((nb = fis.read(bytes)) != -1)//read a line from the file into the variable STR )
            {
                ht.update(bytes);
            }
            //Close the input file.
            fis.close();

            String ss = ht.formatHashValue(ht.digest());
            System.out.println(ss);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
