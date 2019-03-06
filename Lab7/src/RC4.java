import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class RC4 {
    public void ksa(byte state[], byte key[], int len){
//        ---------------------------------------------------------
//            - state: the state used to generate the keystream
//            - key:   key to use to initialize the state
//            - len:   Length of key in bytes (normally 5 to 16 bytes)
//        which is 5*8=40  and 16*8=128 bits
//                ---------------------------------------------------------
//                Here is the Algorithm:

        for(int i=0;i<256;i++){
             state[i] = (byte)i;
        }

        for(int i=0,j=1;i<256;i++,j++) {
            j = (j + state[i] + key[i % len] +256) % 256;
           byte temp=state[i];
           state[i]=state[j];
           state[j]=temp;


        }
    }
    public void prga(byte state[], String input, String output)  {
        byte [] buffer = new byte[1];
        try {
            int i=0;
            int j=0;
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);
            while( fis.read(buffer) == 1 ) {
                // run the prga on the byte buffer[0]
                // store the result in byte result[0]
                i = (i+1) % 256;
                j = (j + state[i]+256) % 256;
                byte temp=state[i];
                state[i]=state[j];
                state[j]=temp;

                byte k = state[ (state[i] + state[j]+256) % 256 ];
                buffer[0]=(byte)(buffer[0] ^ k );

                fos.write(buffer);
            }
            fis.close();
            fos.close();

        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


    public static void main(String args[]) {
        byte key[]="MyPassword".getBytes();
        int PASS_size = key.length;

        byte state[] = new byte[256];

        RC4 rc4 = new RC4();

        // ENCRYPT
        rc4.ksa(state, key, PASS_size);
        rc4.prga(state, "a.png", "b.png");

        // DECRYPT
        rc4.ksa(state, key, PASS_size);
        rc4.prga(state, "b.png", "c.png");

        // Files a.png and c.png must be identical.
    }
}





