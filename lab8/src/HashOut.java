import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HashOut {

    public static int[] answer(int[] digest){
        int[] currentSum = new int[mult256.size()];
        int[] message = new int[digest.length];
        for(int i = 0 ; i < digest.length ; i++){

            // 256*x + y
            // or, 256*x + digest[i]
            for(int mutiple = 0; mutiple < mult256.size() ; mutiple++)
                currentSum[mutiple] = mult256.get(mutiple) + digest[i];

            // message[-1] = 0
            int prev = (i != 0) ? message[i-1] : 0;

            for(int indx = 0; indx < currentSum.length ; indx++){
                int result = currentSum[indx];


                if( ( (result ^ prev) % 129 ) == 0 ){
                    message[i] = ( (result ^ prev) / 129 ) % 256;
                    break;
                }
            }
        }
        return message;
    }

    private static List<Integer> mult256 = null;
    private static final int LowBound = 0;
    private static final int UpBound = 129*256;

    static {
        if(mult256 == null){
            mult256 = new ArrayList<Integer>();
            int coef = 0;
            while( (LowBound <= coef*256) && (coef*256 <= UpBound) )
                mult256.add(256 * coef++);

        }
    }

    public static void main(String[] args) {
		int[] digest = new int[]{0, 129, 3, 129, 7, 129, 3, 129, 15, 129, 3, 129, 7, 129, 3, 129};
		System.out.println(Arrays.toString(answer(digest)));

        int[] digest2 = new int[]{0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165};
        System.out.println(Arrays.toString(answer(digest2)));

        int[] digest3 = new int[]{199, 168, 128, 11, 68, 106, 165, 13, 195};
        System.out.println(Arrays.toString(answer(digest3)));
    }
}
