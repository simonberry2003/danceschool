package modules.classmanager.TimeTable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.skyve.CORE;

import lombok.SneakyThrows;
import lombok.val;
import modules.classmanager.ClassDefinition.ClassDefinitionExtension;
import modules.classmanager.domain.Class;
import modules.classmanager.domain.ClassDefinition;
import modules.classmanager.domain.TimeTable;
import skyve.util.DateUtil;

@SuppressWarnings("serial")
public class TimeTableExtension extends TimeTable {
	@Override
	public String getBizKey() {
		return getName();
	}

	@Override
	public String toString() {
		return getBizKey();
	}

	/**
	 * Generates classes if they don't exist for the selected period for this timetable
	 */
	@SneakyThrows
	public void generateForPeriod() {
		val period = getPeriod();
		LocalDate date = DateUtil.asLocalDate(period.getStart());
		val end = DateUtil.asLocalDate(period.getEnd());
		while (!date.isAfter(end)) {
			val day = date.getDayOfWeek();
			val classesForDay = getClassesFor(day);
			for (val classDefinition : classesForDay) {
				val query = CORE.getPersistence().newDocumentQuery(Class.MODULE_NAME, Class.DOCUMENT_NAME);
				query.getFilter().addEquals(Class.datePropertyName, DateUtil.asDateOnly(date));
				query.getFilter().addEquals(ClassDefinition.dayPropertyName, classDefinition.getDay());
				query.getFilter().addEquals(ClassDefinition.startTimePropertyName, classDefinition.getStartTime());
				query.getFilter().addEquals(ClassDefinition.endTimePropertyName, classDefinition.getEndTime());
				query.getFilter().addEquals(ClassDefinition.venuePropertyName, classDefinition.getVenue());
				query.getFilter().addEquals(ClassDefinition.typePropertyName, classDefinition.getType());
				if (query.beanResult() == null) {
					val classInstance = classDefinition.createClassOn(DateUtil.asDateOnly(date));
					CORE.getPersistence().save(classInstance);
				}
			};
			date = date.plusDays(1);
		}
	}

	private List<ClassDefinitionExtension> getClassesFor(DayOfWeek day) {
		return getClasses()
			.stream()
			.map(ClassDefinitionExtension.class::cast)
			.filter(cd -> cd.isFor(day))
			.collect(Collectors.toList());
	}
}
