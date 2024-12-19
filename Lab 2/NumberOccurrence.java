class NumberOccurrence{
	public static void main(String [] args){
		String sentence = "ITI develops people and ITI house of developers and ITI for people";
		String target = "ITI";
		String [] array = sentence.split(" ");
		int count=0;
		for(String s: array){
			if(s.equals(target))
				count++;
		}
		System.out.println("Count is: "+count);
	}
}
