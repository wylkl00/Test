import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Test {

	public static void main(String[] args) {
		// 测试从Base64编码转换为图片文件
		String strImg = "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";
		GenerateImage(strImg, "D:\\wangy.jpg");

		// 测试从图片文件转换为Base64编码
		System.out.println(GetImageStr("d:\\wangy.jpg"));
	}

	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}