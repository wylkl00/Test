import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilTest {

	public static void main2(String[] args) {
		 List<Map<String,String>> list= new ArrayList<>();
		 List<String> list2=new ArrayList<>();
		 String[] array ={"a","b","c"};
		Arrays.asList(array);
		 for(Map<String,String> map:list){
			 System.out.println(map.get("key"));
		 }
//		 list2=Arrays.asList(array);
		 list2.add("a");
		 list2.add("b");
		 list2.add("c");
		 list2.add(0, "d");
		 List<String>list3=Arrays.asList(array);
		 list2.addAll(list3);
		 
		 System.out.println(list2);

		 String[] arr2={"1","2","3"};
		 String[] arr=list2.toArray(arr2);
		 System.out.println(arr.toString()); 
		 int a =arr2.length;
		 System.out.println("abc".matches("[a-z]{2}"));
		 Pattern.compile("[a-z]{2}").matcher("abc");
		 Map<String,String>strmap=new HashMap<>();
		 strmap.put("1","1");
		 strmap.put("2","2");
		 strmap.put("3","3");
		 Map<String,String>objmap=new HashMap<>();
		 
	}
	public static void main(String[] args) {
		 List<Map<String,String>> list= new ArrayList<>();
		 Map<String,String>objmap=new HashMap<>();
		 objmap.put("menu_id", "70010101");
		 objmap.put("menu_name","客户资料修改");
		 list.add(objmap);
			objmap.put("menu_id", "70010103");
			objmap.put("menu_name","身份证信息变更");
			list.add(objmap);
			objmap.put("menu_id", "70010204");
			objmap.put("menu_name","密码重置");
			list.add(objmap);
			objmap.put("menu_id", "70010301");
			objmap.put("menu_name","创业板权限开通");
			list.add(objmap);
	}
}
