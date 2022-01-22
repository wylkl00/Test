import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLTest {

    public static String path = "C:\\Users\\Administrator.WIN7U-20140112F\\Desktop";

    public static void main2() throws Exception {
        SAXReader reader = new SAXReader();
        //		  DOMReader reader = new DOMReader();
        File file = new File(path, "function.xml");
        Document document = reader.read(file);

        Element root = document.getRootElement();
        //		  List<Element> childElements =  root.elements();
        //		  Iterator it = root.elementIterator();
        Element im = root.element("function").element("import");
        Element ex = root.element("function").element("export");
        Iterator<Element> imit = im.elementIterator();
        List<Element> exit = ex.elements();
        while (imit.hasNext()) {
            imit.next().attribute("name").setValue("test");
        }
        exit.get(0).attribute("cname").setValue("abcd");

        //	       OutputFormat format = OutputFormat.createCompactFormat();
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("GBK");
        XMLWriter writer = new XMLWriter(System.out, format);
        //			BufferedWriter bwriter = Files.newBufferedWriter(file.toPath(),  Charset.forName("UTF-8"));
        //		  XMLWriter writer = new XMLWriter(bwriter);
        writer.write(document);
        //		  writer.flush();
    }

    @SuppressWarnings("deprecation")
    public static void xpath() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        File file = new File(path, "function.xml");
        Document document = reader.read(file);
        //		  List<Attribute> imname=document.selectNodes("/functionlist/function/import/stdFieldQuote/@name");
        List<Node> imname = document.selectNodes("functionlist/function/import/stdFieldQuote/@name");
        List<Node> name = document.selectNodes("//import//@name");
        java.text.DateFormat d;

        for (Node attr : name) {
            ((Attribute)attr).setValue("test");
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("GBK");
        XMLWriter writer = new XMLWriter(System.out, format);
        writer.write(document);
    }

    public static void main1() {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("books");
        Element book = root.addElement("book");
        book.addElement("name").setText("Java编程思想");
        book.addElement("author").setText("Bruce Eckel");
        OutputFormat format = OutputFormat.createPrettyPrint();
        //OutputFormat format = OutputFormat.createCompactFormat();
        format.setEncoding("UTF-8");
        StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(doc);
            writer.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(writer.toString());
    }

    public static void main(String[] args) throws Exception {
        main1();
    }

}
