import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateFromTimezoneGetter {

	public static void main(String[] args) {
		try {
			getDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private static void getDate() throws ParseException {
		String date = "20161017 00:00:00";
		String timeZoneId = "America/Sao_Paulo";
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
		
		TimeZone defaultTimeZone = TimeZone.getDefault();
		
		DateFormat dateFormatLocal = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		// This date object is given time and given timezone
		java.util.Date parsedDate = dateFormatLocal.parse(date);
		System.out.println(dateFormatLocal.format(parsedDate));		
		
		if (timeZone.inDaylightTime(parsedDate)) {
			// We need to re-parse because we don't know if the date
			// is DST until it is parsed...
			parsedDate = dateFormatLocal.parse(date);
		}

		// assigning to the java.sql.TimeStamp instace variable
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		
		System.out.println(dateFormatLocal.format(timestamp));
	}
}
