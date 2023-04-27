package task03;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static boolean isNum(String token) {
    Pattern pattern = Pattern.compile("[0-9]*");
    Matcher matcher = pattern.matcher(token);
    return matcher.matches();
  }
	
	public static boolean isOP(String token) {
    Pattern pattern = Pattern.compile("[+|-|*|/]");
    Matcher matcher = pattern.matcher(token);
    return matcher.matches();
  }

};