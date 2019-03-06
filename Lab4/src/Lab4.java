import java.math.BigInteger;
import java.security.SecureRandom;


public class Lab4 {
//    Public information  q=353 which is a prime number (the module)
//    Public information  a=3   which is a primitive root of q (a < q)
//
//    UserA selects a secret XA=97 (XA < q)
//    UserA calculates the public component of the key YA=(a to the power of XA) mod q
//    UserA transmits YA to UserB
//    UserB selects a secret XB=233 (XB < q)
//    UserB calculates the public component of the key YB=(a to the power of XB) mod q
//    UserB transmits YB to UserA
//
//    At this point both users can calculate a common key K.
//    UserA calculates Ka= (YB to the power of XA) mod q
//    UserB calculates Kb= (YA to the power of XB) mod q
//
//
//    Ka is equal to Kb!  But why?

    public static void main(String[] args) {
        BigInteger  q = randomPrime(80);
        BigInteger  a = new BigInteger("3");
        BigInteger  XA = randomPrime(50);
        BigInteger  XB = randomPrime(50);

        BigInteger  YA = a.modPow(XA,q);
        BigInteger  YB = a.modPow(XB,q);

        BigInteger  Ka = YB.modPow(XA,q);
        BigInteger  Kb = YA.modPow(XB,q);

        System.out.println("Public information a=3 and q="+q+"\n");
        System.out.println("UserA selects XA="+XA+"\n");
        System.out.println("UserA calculates YA="+YA+"\n");
        System.out.println("     ---- UserA Transmits YA to UserB ---->\n");
        System.out.println("                                        UserB selects XB="+XB+"\n");
        System.out.println("\t\t\t\t\tUserB calculates YB="+YB+"\n");
        System.out.println("     <---- UserB Transmits YB to UserA ----\n");
        System.out.println("\n");
        System.out.println("UserA's Key="+Ka+"\n");
        System.out.println("                                        UserB's Key="+Kb+"");

    }

    public static BigInteger randomPrime(int bits){
        SecureRandom random = new SecureRandom();
        BigInteger prime = BigInteger.probablePrime(bits, random);
        return prime;
    }
}
