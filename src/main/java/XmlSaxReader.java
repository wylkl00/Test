import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 */

/**
 * @author wangy
 *
 */
public class XmlSaxReader {
	public static String path="C:\\Users\\lianglu\\Desktop\\";
	
	 public static void main(String[] args) throws Exception {
		 Map<String,Object> col = new HashMap<>();
		  SAXReader reader = new SAXReader();
//		  DOMReader reader = new DOMReader();
		  File file = new File(path, "applicationContext.xml");
		  Document document = reader.read(file);
		  
		  Element root = document.getRootElement();
		  List<Element> beans  = root.elements();		  
		  for(Element bean :beans){
			  System.out.println(bean.attribute("class").toString());
			  Object beanInstance = Class.forName(bean.attribute("class").getStringValue()).newInstance();
			  col.put(bean.attribute("id").getStringValue(),beanInstance);			  
		  }
		 System.out.println(col);
	 }

}
