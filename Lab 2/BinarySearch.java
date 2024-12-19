class BinarySearch{
	/*public static void binarySearchFun(int target, int arr[], int start, int end){
		int mid;
		while(start<=end){
			mid=(end+start)/2;
			if(target==arr[mid])
				return mid;
			else if(target<arr[mid]){	
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
	}*/
	public static void main(String args []){
		int size=1000;
		int initial=1;
		int arr[] = new int[size];
		long startTime;
                long endTime;
		long timeDiff;
                for(int i=0; i<size; i++){
                        arr[i]=initial;
                        initial++;
                }
                int mid;
                int end=size-1;
                int start=0;
                int target = 2;
                
		startTime=System.nanoTime();
                while(start<=end){
			mid=(end+start)/2;
			if(target==arr[mid]){
				System.out.println("index of target is: "+mid);
				return;
			}
			else if(target<arr[mid]){	
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
		endTime=System.nanoTime();
                timeDiff=endTime-startTime;

                System.out.println("Time Consumed is: "+timeDiff);
	}
}
