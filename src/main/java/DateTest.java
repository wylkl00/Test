import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 */

/**
 * @author wangy
 *
 */
public class DateTest {

	public static void main2 (String[] arg){

        System.out.println(System.currentTimeMillis()); 
        
        Date date = new Date();  
        
        System.out.println("date.toString: " + date.toString());  
        System.out.println("date: " + date.getDate());  
        System.out.println("day: " + date.getDay());  
        System.out.println("hour: " + date.getHours());  
        System.out.println("minutes: " + date.getMinutes());  
        System.out.println("month: " + (date.getMonth() + 1));  
        System.out.println("seconds: " + date.getSeconds());  
        System.out.println("time: " + date.getTime());  
        System.out.println("timezone: " + date.getTimezoneOffset());  
        System.out.println("year: " + (date.getYear() + 1900));  
          
        Calendar calendar = Calendar.getInstance();  
        int year = calendar.get(Calendar.YEAR);  
        int month = calendar.get(Calendar.MONTH) + 1;  
        int day = calendar.get(Calendar.DATE);  
        int hour = calendar.get(Calendar.HOUR);  
        int minute = calendar.get(Calendar.MINUTE);  
        int second = calendar.get(Calendar.SECOND);  
          
        System.out.println("----------Calendar-------");  
        System.out.println("year: " + year);  
        System.out.println("month: " + month);  
        System.out.println("day: " + day);  
        System.out.println("hour: " + hour);  
        System.out.println("minute: " + minute);  
        System.out.println("second: " + second); 
          
	}
	
    public static void main3(String args[]) {  
        Date date = new Date();
          
        /* 
         * DateFormat会依电脑上的区域设定显示时间格式
			G：年代标识，表示是公元前还是公元后 
			y：年份 
			M：月份 
			d：日 
			h：小时，从1到12，分上下午 
			H：小时，从0到23 
			m：分钟 
			s：秒 
			S：毫秒 
			E：一周中的第几天，对应星期几，第一天为星期日，于此类推    
			z：时区 
			D：一年中的第几天 
			F：这一天所对应的星期几在该月中是第几次出现 
			w：一年中的第几个星期 
			W：一个月中的第几个星期 
			a：上午/下午标识 
			k：小时，从1到24 
			K：小时，从0到11，区分上下午  
         * 从Date-->String 
         */  
        DateFormat dateFormat = new SimpleDateFormat("y-MM-dd G E z kk:mm:ss a w W F D",Locale.ENGLISH); 
        System.out.println(dateFormat.format(date));  
          
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
        System.out.println(format1.format(date));  
          
        DateFormat format2 = new SimpleDateFormat("y-MM-dd G E z kk:mm:ss a ww WW FF DD");  
        System.out.println(format2.format(date));  
      
        /* 
         * 从String-->Date 
         */  
        String dateStr = "2011-7-19";  
        try {  
            Date dateTrans = format1.parse(dateStr);  
            //System.out.println(dateTrans.toString());   
            System.out.println(dateTrans.toLocaleString());  //转换为本地的形式  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
          
    }  
    
    public static void main4(String[] args) {  
        
        Date date = new Date();  
        DateFormat shortFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);  
        DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);  
        DateFormat longFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);  
        DateFormat fullFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);  
        System.out.println(shortFormat.format(date));  
        System.out.println(mediumFormat.format(date));  
        System.out.println(longFormat.format(date));  
        System.out.println(fullFormat.format(date));  
          
    }  
    
    public static void main(String[] args) {

        //Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date="+today);
 
        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date="+firstDay_2014);
 
        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException: 
        //Invalid date 'February 29' as '2014' is not a leap year
 
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST="+todayKolkata);
 
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
 
        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= "+dateFromBase);
 
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014="+hundredDay2014);
        
        
     // Returns the current time based on your system clock and set to UTC.  
        Clock clock = Clock.systemUTC();  
        System.out.println("Clock : " + clock);  

          
        // Returns time based on system clock zone Clock defaultClock =  
        Clock.systemDefaultZone();  
        System.out.println("Clock : " + clock.millis());  
        
        LocalDateTime localtDateAndTime = LocalDateTime.now();  
        //ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime,ZoneId.of("PRC"));  
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime,ZoneId.of("America/New_York"));  
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork); 
        
        
        Instant timestamp = Instant.now();  
        System.out.println("What is value of this instant " + timestamp);  
       // Date.from(timestamp).toInstant();
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        //LocalDate formatted = LocalDate.parse(dayAfterTommorrow,  DateTimeFormatter.ofPattern("yMMdd"));  
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);  
        		  

	}
	
}
