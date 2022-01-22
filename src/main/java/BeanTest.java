import java.util.HashMap;
import java.util.Map;

public class BeanTest {
	private String str1;
	
	private String str2;

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}
	
	public static void main(String[] args) {
		BeanTest test = new BeanTest();
		Map<String,String> map= new HashMap<>();
		String str1=test.getStr1();
		test.setStr2(map.get("Str2"));
		String str2=test.getStr2();
		System.out.println(str1);
		System.out.println(str2);
	}
}
