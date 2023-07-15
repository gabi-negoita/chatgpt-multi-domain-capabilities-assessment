package ro.ugal.master;

public class StringUtils {

    public static String sanitizeString(String text) {
        return text
                .trim()
                .replace("\n", " ")
                .replace("  ", " ");
    }
}
