import java.util.*; 

class ipTokenizer{
	public static void main(String [] args){
		String ip = "192.168.1.1";
		StringTokenizer str = new StringTokenizer(ip,".");
		while(str.hasMoreTokens()){
			System.out.println(str.nextToken());
		}
	}
}
