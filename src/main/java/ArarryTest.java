
public class ArarryTest {
	public static void main(String[] args) {
		String[][] romawords ={{"a" ,"i" ,"u" ,"e" ,"o" },
								{"ka" ,"ki","ku","ke","ko"},
								{"sa","shi","su","se","so"},
								{"ta","chi","tsu","te","to"}}; 
		String[] dictation =new String[100];
		String row_nos="1,2,3,4";
		String[] row_no = row_nos.split(",");
		for (int i=0;i<row_no.length;i++){
			int row=Integer.parseInt(row_no[i])-1;
			System.arraycopy(romawords[row], 0, dictation, 5*i, 5);
		}
		printarray(dictation);
	}
	
	public static <T> void  printarray(T[] ararry){
		for(T i:ararry){
			System.out.print(i);
			System.out.print(" ");
		}
	}


}
