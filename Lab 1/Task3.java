class Task3{
	public static void main(String [] args){
		if(args.length != 2){
			System.out.println("2 parameters are needed!");
			return;
		}
		int num;
		try{
			num=Integer.parseInt(args[1]);
			if(num<0){
				System.out.println("Negative numbers are not allowed!");
				return;
			}
			for(int i=0; i<num; i++){
                                System.out.println(args[0]);
                        }
		}catch(Exception e){
			System.out.println("Second parameter must be a digit!");
			return;
		}
	}
}
