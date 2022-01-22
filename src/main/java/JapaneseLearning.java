import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JapaneseLearning {

	private final static String[][] romawords = {{"a" ,"i" ,"u" ,"e" ,"o" },
													{"ka" ,"ki","ku","ke","ko"},
													{"sa","shi","su","se","so"},
													{"ta","chi","tsu","te","to"},
													{"na","ni","nu","ne","no"},
													{"ha","hi","fu","he","ho"},
													{"ma","mi","mu","me","mo"},
													{"ya",null,"yu",null,"yo"},
													{"ra","ri","ru","re","ro"},
													{"wa",null,null,null,"wo"}};
	
	private final static String[][] hiragana = {{"あ","い","う","え","お"},                  
													{"か","き","く","け","こ"},                  
													{"さ","し","す","せ","そ"},                  
													{"た","ち","つ","て","と"},                  
													{"な","に","ぬ","ね","の"},                  
													{"は","ひ","ふ","へ","ほ"},                  
													{"ま","み","む","め","も"},                  
													{"や",null,"ゆ",null,"よ"},                
													{"ら","り","る","れ","ろ"},                  
													{"わ",null,null,null,"を"}};   
	
	private final static String[][]katakana =  {{"ア","イ","ウ","エ","オ"},
													{"カ","キ","ク","ケ","コ"},
													{"サ","シ","ス","セ","ソ"},
													{"タ","チ","ツ","テ","ト"},
													{"ナ","ニ","ヌ","ネ","ノ"},
													{"ハ","ヒ","フ","ヘ","ホ"},
													{"マ","ミ","ム","メ","モ"},
													{"ヤ",null,"ユ",null,"ヨ"},
													{"ラ","リ","ル","レ","ロ"},
													{"ワ",null,null,null,"ヲ"}};
	
	private final static int time = 1500;
	
	public static String[] init(String[][] words,int... row_nos){
		String[] dictation =new String[row_nos.length*5];
		for (int i=0;i<row_nos.length;i++){
			int row=(row_nos[i])-1;
			System.arraycopy(words[row], 0, dictation, 5*i, 5);
		}
		return dictation;
	}
	
	public static void circulation(int count,String[]dictation) throws InterruptedException {
		
		Random ran1 =new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("下面开始啦~");
		for(int i=0;i<count;){	
			int order =ran1.nextInt(dictation.length);
			if (dictation[order]!=null){					
//				if(sc.next()!=null){
					Thread.sleep(time);
					i++;
					System.out.print(i+".");
					System.out.println(dictation[order]);
//				}
			}
		}
		sc.close();
	}
	
	public static void sequence(String[]dictation) throws InterruptedException{
		List<String> list = new ArrayList<String>(Arrays.asList(dictation));
		Random ran1 =new Random();
		Scanner sc = new Scanner(System.in);
		int i = 0;
		System.out.println("下面开始啦~");
		while(list !=null&& !list.isEmpty()){
			int order = ran1.nextInt(list.size());
			if(list.get(order)!=null){
//				if(sc.next()!=null){
				Thread.sleep(time);
					i++;
					System.out.print(i+".");
					System.out.println(list.get(order));
//				}
			}
			list.remove(order);
		}
		sc.close();
	}
	
	public static void main(String[] args) throws Exception {

//		sequence(init(hiragana,1,2,3,4,5,6));
//		circulation(100,init(katakana,1,2,3,4,5,6));
		circulation(9999,init(hiragana,1,2,3,4,5,6,7));
//		circulation(50,new String[] {"く","さ","そ","た","つ","て","ク","サ","ソ","タ","ツ","テ"});
//		String[] both = (String[]) ArrayUtils.addAll(init(hiragana,1,2,3,4,5,6), init(katakana,1,2,3,4,5,6));
//		circulation(100, both);
	}
}
