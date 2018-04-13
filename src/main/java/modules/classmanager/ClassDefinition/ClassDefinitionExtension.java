package modules.classmanager.ClassDefinition;

import java.time.DayOfWeek;

import org.skyve.domain.types.DateOnly;

import modules.classmanager.Class.ClassExtension;
import modules.classmanager.domain.Class;
import modules.classmanager.domain.ClassDefinition;

@SuppressWarnings("serial")
public class ClassDefinitionExtension extends ClassDefinition {
	public boolean isFor(DayOfWeek day) {
		return getDay().toCode().toLowerCase().equals(day.name().toLowerCase());
	}

	public Class createClassOn(DateOnly date) throws Exception {
		Class newClass = ClassExtension.newInstance();
		newClass.setDate(date);
		newClass.setDay(getDay());
		newClass.setStartTime(getStartTime());
		newClass.setEndTime(getEndTime());
		newClass.setType(getType());
		newClass.setVenue(getVenue());
		return newClass;
	}
}
