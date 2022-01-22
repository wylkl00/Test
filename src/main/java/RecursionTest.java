
public class RecursionTest {
	
	 public int getsum(int n){
		 int sum;
		 if(n==1) sum=1;
		 else{
		 
		 sum=getsum(n-1)+n;
		 }
		 return sum;		 
	 }
	 
	 public int allrabbit(int n){
		 int sum;
		 if(n==1) sum=1;
		 else{
			 sum=3*allrabbit(n-1);
		 }
		 return sum;
	 }
	 
	 public int[] quicksort(int[] array,int start,int end){

		 int key=start;
		 int temp=0;
		 int j=start;
		 int i=end;
			 for(i=end;i>j;i--){
				 if(array[i]<array[key]){
					 temp=array[i];
					 array[i]=array[key];
					 array[key]=temp;
					 key=i;
					 for( j=start;j<i;j++){
						 if(array[j]> array[key]){
							 temp=array[j];
							 array[j]=array[key];
							 array[key]=temp;
							 key=j;
							 break;
						 }
					 }
				 }
			 }
	
		if((key-1)>start){
				 quicksort(array,start,key-1);}
		if(end>(key+1)){
				quicksort(array,key+1,end);}
			

		
		 return array;
		 
	 }


	 public static void main(String[] args  ) {
		RecursionTest test=new RecursionTest();
		int[] array={3,3,10,33,32,4,6,8,8,45,2,1,14,11,53};
		int p=0;
		int q=array.length-1;
		array=test.quicksort(array,p,q);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		
	}
	 
}
