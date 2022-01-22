import java.lang.Math;
import static java.lang.Math.*;

public class MathTest {

	public static void main(String[] args) {
		double def =400;
		double realdef=sqrt(def)*0.01+def*0.0003;
		System.out.println(realdef);
		damage(707,60,500,600,1.4*1.5,0);
		damage(707,60,750,900,1.4*1.5,0);
		damage(707,60,500,600,1.5,0);
		damage(707,60,750,900,1.5,realdef);
		damage(707,170,350,400,1.4,realdef);
	}
	
	public static void damage(double atk,double arm, double skilllow ,double skillhigh ,double addition ,double realdef){
		assert skilllow<=skillhigh;
		double realatk=sqrt(atk*100)+(atk*0.3);
		double npcatk =sqrt(atk*100*0.5)+(atk*0.3*0.5);
		
		float damagelow = (float) ((realatk+arm+skilllow*addition)*1.7675*(1-realdef));
		float damagehigh = (float) ((realatk+arm+skillhigh*addition)*1.7675*(1-realdef));
		float avgdamage = (float) ((realatk+arm+(skillhigh+skilllow)/2*addition)*1.7675*(1-realdef));
		float npcavgdamage = (float) ((npcatk+(skillhigh+skilllow)/2)*1.7675*(1-realdef));
		System.out.println("damage:"+damagelow+"-"+damagehigh);
		System.out.println("avgdamage:"+avgdamage);
		System.out.println("npcatk:"+npcavgdamage);
		System.out.println();
	}
}
