import wit.security.ecc.EllipticCurve;
import wit.security.ecc.Point;

import java.math.BigInteger;
import java.security.SecureRandom;


public class Lab9 {
    public static void main(String[] args) {
        EllipticCurve cc = new EllipticCurve(new BigInteger("11"), new BigInteger("1"), new BigInteger("6"));
        Point G = new Point(cc, new BigInteger("2"), new BigInteger("7"));

        BigInteger n = new BigInteger("13");
        BigInteger  Na = new BigInteger(4,new SecureRandom());
        BigInteger  Nb = new BigInteger(4,new SecureRandom());


        Point Pa = G.multiply(Na);
        Point Pb = G.multiply(Nb);

        Point  Ka = Pb.multiply(Na);
        Point  Kb = Pa.multiply(Nb);

        System.out.println("Public information n=13 and G="+G+"\n");
        System.out.println("UserA selects Na="+Na+"\n");
        System.out.println("UserA calculates Ka="+Ka+"\n");
        System.out.println("     ---- UserA Transmits Ka to UserB ---->\n");
        System.out.println("                                        UserB selects Nb="+Nb+"\n");
        System.out.println("\t\t\t\t\tUserB calculates Kb="+Kb+"\n");
        System.out.println("     <---- UserB Transmits Kb to UserA ----\n");
        System.out.println("\n");
        System.out.println("UserA's Key="+Ka+"\n");
        System.out.println("                                        UserB's Key="+Kb+"");

    }
}
