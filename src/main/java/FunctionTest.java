import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FunctionTest {
	static List<String> list= new ArrayList<String>();
	FunctionTest(){
		list=null;
	}
	
	public static void main(String[] args) {
		System.out.println(FunctionTest.list);
		new FunctionTest();
		System.out.println(FunctionTest.list);
	}
}
