import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

class ipTokenizer{
	static boolean isValidIP(String ip){
			Matcher matcher = pattern.matcher(ip);
			return matcher.matches();
		}	
	
	public static void main(String [] args){
		String ip = "192.168.1.1";
		String regex="(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		static Pattern pattern = Pattern.compile(regex);
		if(ip==null){
			System.out.println("Empty IP address");
			return;
		}
		if(!isValidIP(ip)){
			System.out.println("Invalid IP address");
			return;
		}
		
		StringTokenizer str = new StringTokenizer(ip,".");
		while(str.hasMoreTokens()){
			System.out.println(str.nextToken());
		}
	}
}
