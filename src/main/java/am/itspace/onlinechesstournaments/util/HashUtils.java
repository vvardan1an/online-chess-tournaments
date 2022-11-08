package am.itspace.onlinechesstournaments.util;

import lombok.experimental.UtilityClass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    static public String hash(String source) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            byte[] bs;
            bs = messageDigest.digest(source.getBytes());
            for (int i = 0; i < bs.length; i++) {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if (hexVal.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        } catch (NoSuchAlgorithmException ex) {
        }
        return sb.toString();
    }
}