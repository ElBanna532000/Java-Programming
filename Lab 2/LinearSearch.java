class LinearSearch {
	public static void main(String args[]){
		int size=1000;
		int max = 2000;
		int min = -1;
		long startTime;
		long endTime;
		long timeDiff;
		int arr[] = new int[size];
		for(int i=0; i<size; i++){
			arr[i]=(int)(Math.random()*size+1);
		}
		startTime=System.nanoTime();
		for(int i=0; i<size; i++){
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i];
		}
		endTime=System.nanoTime();
		timeDiff=endTime-startTime;
		
		System.out.println("Time Consumed is: "+timeDiff);
	}
}
