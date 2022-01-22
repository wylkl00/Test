import java.util.Scanner;

public class Test {
	final static double  distance = 1.20;
	final static double speed = 2.82;
	
	public static double getMove(double distanceA, double distanceB, double speedA, double speedB){
		double newdistance = distance * (1+distanceA) +	distanceB;
		double newspeed = speed * (1+speedA) + speedB;
		System.out.println(newdistance + " " + newspeed);
		
		return  newdistance * newspeed;
	}
	
	
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
	            int a = in.nextInt();
	            int b = in.nextInt();
	            System.out.println(a + b);
	        }
	    }
}
