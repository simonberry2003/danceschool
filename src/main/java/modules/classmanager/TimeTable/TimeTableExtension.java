package modules.classmanager.TimeTable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.skyve.CORE;
import org.skyve.persistence.DocumentQuery;

import lombok.val;
import modules.classmanager.ClassDefinition.ClassDefinitionExtension;
import modules.classmanager.domain.Class;
import modules.classmanager.domain.ClassDefinition;
import modules.classmanager.domain.Period;
import modules.classmanager.domain.TimeTable;
import skyve.util.DateUtil;

@SuppressWarnings("serial")
public class TimeTableExtension extends TimeTable {
	@Override
	public String getBizKey() {
		return getName();
	}

	public void generateForPeriod() throws Exception {
		Period period = getPeriod();
		LocalDate date = DateUtil.asLocalDate(period.getStart());
		LocalDate end = DateUtil.asLocalDate(period.getEnd());
		while (!date.isAfter(end)) {
			DayOfWeek day = date.getDayOfWeek();
			List<ClassDefinitionExtension> classesForDay = getClassesFor(day);
			for (ClassDefinitionExtension classDefinition : classesForDay) {
				DocumentQuery query = CORE.getPersistence().newDocumentQuery(Class.MODULE_NAME, Class.DOCUMENT_NAME);
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
