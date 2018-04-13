package skyve.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.skyve.domain.types.DateOnly;
import org.skyve.domain.types.DateTime;

public class DateUtil {
	private DateUtil() {}

	public static Date asDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static DateTime asDateTime(LocalDateTime localDateTime) {
	    return new DateTime(asDate(localDateTime));
	}

	public static DateOnly asDateOnly(LocalDate localDate) {
	    return new DateOnly(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
	}

	public static LocalDate asLocalDate(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * A date-based amount of time such as '2 years, 3 months and 4 days' between two dates.
	 * @param from start {@link Date}
	 * @param to end {@link Date}
	 * @return {@link Period}
	 */
	public static Period periodBetween(Date from, Date to) {
		return Period.between(asLocalDate(from), asLocalDate(to));
	}

	/**
	 * Create date
	 * @param dayOfMonth
	 * @param month
	 * @param year
	 * @return
	 */
	public static DateOnly dateFrom(int dayOfMonth, Month month, int year) {
		return new DateOnly(java.sql.Date.from(LocalDate.of( year , month , dayOfMonth ).atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	/**
	 * Create date time
	 * @param dayOfMonth
	 * @param month
	 * @param year
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static DateTime dateTimeFrom(int dayOfMonth, Month month, int year, int hour, int minute) {
		return new DateTime(java.sql.Date.from(LocalDateTime.of( year , month , dayOfMonth,hour, minute ).atZone(ZoneId.systemDefault()).toInstant()));
	}

	public static Year currentFiscalYear() {
		LocalDate now = LocalDate.now();
		Integer month = now.getMonth().getValue();
		Integer year = now.getYear();
		year = month < 6 ? year : year + 1;
		return Year.of(year);
	}

	public static String currentfiscalYearAsString(){
		Year year = currentFiscalYear();
		return year.minusYears(1) + "-" + year;
	}

	public static Year fiscalYear(DateOnly asAt) {
		LocalDate now = asLocalDate(asAt);
		Integer month = now.getMonth().getValue();
		Integer year = now.getYear();
		year = month < 6 ? year : year + 1;

		return Year.of(year);
	}

	public static String fiscalYearAsString(DateOnly asAt){
		Year year = fiscalYear(asAt);
		return year.minusYears(1) + "-" + year;
	}

	/**
	 * Converts @{@link DateOnly} to xml calendar
	 * @param date
	 * @return @{@link XMLGregorianCalendar} or null
	 * @throws Exception
	 */
	public static XMLGregorianCalendar toXMLGregorianCalendar(DateOnly date) throws Exception {
		XMLGregorianCalendar xgc = null;
		if (date != null) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		}
		return xgc;
	}

	public static DateOnly min(DateOnly a,DateOnly b) {
		return a.after(b) ? b : a;
	}

	public static DateOnly max(DateOnly a,DateOnly b) {
		return a.after(b) ? a : b;
	}
}
