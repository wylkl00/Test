import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
		new ReflectTest().getMethodInfo("sort.CountAccurrenceOfWord");
	}

	/**
	 * 传入全类名获得对应类中所有方法名和参数名
	 */
	@SuppressWarnings("rawtypes")
	private void getMethodInfo(String pkgName) {
		try {
			Class clazz = Class.forName(pkgName);
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				System.out.println("方法名称:" + methodName);
				Class<?>[] parameterTypes = method.getParameterTypes();
				for (Class<?> clas : parameterTypes) {
					String parameterName = clas.getName();
					System.out.println("参数名称:" + parameterName);
				}
				System.out.println("*****************************");
				if("main".equals(methodName)){
					try {
						try {
							method.invoke(clazz.newInstance(),(Object)new String[1]);
						} catch (InstantiationException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					} catch (IllegalAccessException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class claz =this.getClass();
		System.out.println(claz);
		System.out.println(claz.getResource("ReflectTest.class"));
		
		
	}
}
