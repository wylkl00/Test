import java.util.Random;

public class RandomTest {

	public static void main(String[]args){
		Random ran1 =new Random(24789365);
		Random ran2 =new Random();
		Math.random();
//		for(int i=1;i<10;i++){
//			System.out.println(ran1.nextInt(333));
//		}
		
//		for(int i=1;i<10;i++){
//			System.out.println(ran2.nextInt(100));
//		}
		
		for(int i=1;i<10;i++){
			System.out.println(Math.random());
		}
	}
}
