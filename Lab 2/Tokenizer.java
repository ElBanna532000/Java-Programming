import java.util.*; 

class Tokenizer{
	public static void main(String [] args){
		String sentence = "ITI develops people and ITI house of developers and ITI for people";
                String target = "ITI";
                int count=0;
		StringTokenizer str = new StringTokenizer(sentence);
		while(str.hasMoreTokens()){
			if(str.nextToken().equals(target))
				count++;
		}
		System.out.println("Number of Occurrence is:" +count);		
	}
}
