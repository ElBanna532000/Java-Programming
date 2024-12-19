class NumberOccurence2{
	public static void main(String [] args){
		String sentence = "ITI develops people and ITI house of developers and ITI for people";
                String target = "ITI";
                int count=0;
                
                while(sentence.indexOf("ITI") != -1){
                	count++;
                	sentence = sentence.substring(sentence.indexOf(target)+target.length());
                }
                System.out.println("Count of target is: "+count);
	}
}
