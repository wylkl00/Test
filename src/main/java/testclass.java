import static java.lang.System.out;
public class testclass {
	public static void main(String[] args) {
		System.out.println(SettleStepEnum.BOPDATECHANGEFAIL.name());
		System.out.println(SettleStepEnum.BOPDATECHANGEFAIL.ordinal());
		System.out.println(SettleStepEnum.valueOf("BOPDATECHANGEFAIL"));
		System.out.println(SettleStepEnum.BOPDATECHANGEFAIL.getRemark());
		System.out.println(SettleStepEnum.values());
		out.print(new testclass().test("123"));
	}
	public String test (String make){
		
		out.println(this.getClass());
		try{
			make.replaceFirst("x", "y");
		}catch(Exception e){
			
		}
		make ="a";
		return make ;
	}
}
;
