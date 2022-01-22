import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	public static void test1() {
		//[\\w[.-]]等同于[\\w.-] 表示所有字母加上.和-这两个符号 在[] .就表示点号
		   p("-asdsfdfagf@adsdsfd.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));//true
	        
	        //matches() find() lookingAt()
		   p("123-34345-234-00".matches("\\d{3,5}"));
	        Pattern p = Pattern.compile("\\d{3,5}");
	        Matcher m = p.matcher("123-34345-00-234-00");
	        
	        //将整个"123-34345-234-00"用正则表达式引擎查找匹配，当到第一个"-"不匹配了，就停止，
	        //但不会将不匹配的"-"吐出来
	        p(m.matches());
	        //将不匹配的"-"吐出来
	        m.reset();
	        
	        //1:当前面有p(m.matches());查找子字符串从"...34345-234-00"开始
	        //将会是第1,2两个查到"34345"和"234" 后面2个查不到为false
	        //2:当前面有p(m.matches());和m.reset();查找子字符串从"123-34345-234-00"开始
	        //将为true,true,true,false
	        p(m.find());
	        p(m.start()+"---"+m.end());
	        p(m.find());
	        p(m.start()+"---"+m.end());
	        p(m.find());
	        p(m.start()+"---"+m.end());
	        p(m.find());
//	        p(m.start()+"---"+m.end());
	        //要是没找到就会报异常java.lang.IllegalStateException
	        //p(m.start()+"---"+m.end());

	        /**
	         * lookingAt()永远从第一个字符开始找，部分匹配就返回true，matches需要全部匹配才返回true
	         */
	        p(m.lookingAt());p(m.start()+"---"+m.end());
	        p(m.lookingAt());p(m.start()+"---"+m.end());
	        p(m.lookingAt());p(m.start()+"---"+m.end());
	        p(m.lookingAt());p(m.start()+"---"+m.end());
	        p(m.lookingAt());p(m.start()+"---"+m.end());

	        //字符串替换
	        //Pattern.CASE_INSENSITIVE大小写不敏感
	         p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
	         m = p.matcher("1java 2Java 3jAva 4ILoveJavA youHateJAVA adsdsfd");
	        //存放字符串
	        StringBuffer  buf = new StringBuffer();
	        //计数奇偶数
	        int i  = 0;
	        while(m.find()){
	            i++;
	            if(i%2 == 0){
	                m.appendReplacement(buf, "java");
	            }else{
	                m.appendReplacement(buf, "JAVA");
	            }
	        }
	        //不加这句话，字符串adsdsfd将会被遗弃
	        m.appendTail(buf);
	        p(buf);
	}

	public static void p(Object para) {
		// TODO 自动生成的方法存根
		
		System.out.println(para);
	}
	
	public static void test2(){
//		String pattern="\\.(?:(?:[^c][^s}[^v])|(?:[^x][^l][^s])|(?:[^x][^l][^s][^x]))";
		String pattern="\\.(?!jpg$)[^\\.]+$";
		String pa3="[^\\.]*(?!\\.jpg$)[^\\.]*";
		String pa2="^$|[^gG]$|[^pP][gG]$|[^jJ][pP][gG]$|[^.][jJ][pP][gG]$";
		String pa4="^.*$(?!\\.jpg$)";
		String pa5="^.*([^j][^p][^g])$";
		String pa6=".*(?<!jpg)$";
		String pa7="^(?!.*?\\.jpg$)";
		String pa8="^(?!.*?\\.jpg$).*$";
		String pa9="^\\w+$";
		String pa10 ="[0-9a-z]*";
		p("012345abcdez".matches(pa10));
	}
	  public static void test3() {

		    Pattern pattern = Pattern.compile("(This)(.*)(another) (tes)");
		    StringBuffer sb = new StringBuffer();

		    String candidateString = "This is another test . ";
		    
		    
		    String replacement = "$1 AAA $2";
		    Matcher m = pattern.matcher(candidateString);
		    m.lookingAt();
		    m.group(0);//This is another tes 等同于m.group()
		    m.group(1);//This
		    m.group(2);// is 
		    m.group(3);//another
		    m.group(4);//tes
		    
		    m.appendReplacement(sb, replacement);
		    m.appendTail(sb);
		    String msg = sb.toString();
		    System.out.println(msg);

		  }
	
	public static void main(String[] args) {
		test1();
		System.out.println("70010211".matches("^70010\\d{3}$"));
		System.out.println("70010211".matches("^70010[0-9]{3}$"));
	}
}
