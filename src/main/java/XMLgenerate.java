import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLgenerate {

    public static String base = "C:\\Users\\lianglu\\Desktop\\xml\\";
    //	public static String impfilename ="LS_基金外围接入_基金份额冻结.service_design";
    //	public static String description ="基金份额冻结";

    public static void generate(String impfilename, String description) throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document design = reader.read(new File(base, impfilename));
        Document stdfields = reader.read(new File(base, "stdfields.xml"));
        Document functionlist = DocumentHelper.createDocument();
        @SuppressWarnings("unchecked") List<Node> stds = design.selectNodes("//stdFieldQuote");
        String objectId = ((Attribute)design.selectNodes("//basic//@objectId").get(0)).getValue();
        Element function = functionlist.addElement("functionlist").addElement("function").
                addAttribute("objectId", objectId).addAttribute("description", description).addAttribute("type", "T2");
        for (Node std : stds) {
            Element element = (Element)std;
            String name = element.attribute("name").getValue();
            Attribute cname = ((Element)stdfields.selectNodes("//stdfield[@name='" + name + "']").get(0)).attribute("cname");
            element.add((Attribute)cname.clone());
            element.remove(element.attribute("flag"));
            element.remove(element.attribute("comment"));
        }
        Element imp = (Element)design.selectNodes("//import").get(0);
        Element exp = (Element)design.selectNodes("//export").get(0);
        function.add((Element)imp.clone());
        function.add((Element)exp.clone());
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        OutputStream out = Files.newOutputStream(Paths.get(base, description + ".xml"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(functionlist);
        System.out.println(description + "  生成成功！");
    }

    public static void main(String[] args) throws Exception {
        DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get(base));
        Pattern pattern = Pattern.compile("^LS_.+_(.+)\\.service_design$");

        for (Path path : dir) {
            Matcher matcher = pattern.matcher(path.getFileName().toString());
            if(matcher.matches()) {
                generate(path.getFileName().toString(), matcher.group(1));
            }
        }
    }
}
