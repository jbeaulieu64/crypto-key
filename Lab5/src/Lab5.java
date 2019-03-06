public class Lab5 {
    public static void main(String[] args) {
        if( args.length != 3 ) {
            System.err.println("Provide 3 filenames: plain encrypted decrypted.");
            System.exit(-1);
        }

        RSA_WIT rsa = new RSA_WIT("977447",  "649487", "6359");         // see the constructor for details.
        //  p            q     publicKey


        rsa.PrintParameters();

        System.out.println(rsa);

        //rsa.EncryptDecrypt(args[0], args[2]); // encrypt/decrypt on the fly

        rsa.EncryptFile(args[0], args[1]);      // Encrypt file
        rsa.DecryptFile(args[1], args[2]);      // Decrypt file

        System.out.println("FINISHED");
    }
}
