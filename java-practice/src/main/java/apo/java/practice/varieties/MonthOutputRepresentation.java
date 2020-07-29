package apo.java.practice.intieties;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class MonthOutputRepresentation {
    public static void main(String[] args) {
	LocalDate actualDate = LocalDate.now();
	StringBuilder calendar = new StringBuilder("Mon Tue Wed Thu Fri Sat Sun\n");
	StringBuilder lineSB = new StringBuilder("                           ");
	for (int i = 1; i <= actualDate.getMonth().maxLength(); i++) {
	    LocalDate tempDate = actualDate.with(ChronoField.DAY_OF_MONTH, i);
	    switch (tempDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault())) {
	    case "Mon":
		lineSB.replace(0, 3, String.format("%3s", i));
		break;
	    case "Tue":
		lineSB.replace(4, 7, String.format("%3s", i));
		break;
	    case "Wed":
		lineSB.replace(8, 11, String.format("%3s", i));
		break;
	    case "Thu":
		lineSB.replace(12, 15, String.format("%3s", i));
		break;
	    case "Fri":
		lineSB.replace(16, 19, String.format("%3s", i));
		break;
	    case "Sat":
		lineSB.replace(20, 23, String.format("%3s", i));
		break;
	    case "Sun":
		lineSB.replace(24, 27, String.format("%3s\n", i));
		calendar.append(lineSB);
		lineSB = new StringBuilder("                           ");
		break;
	    }
	}
	System.out.println(calendar);
    }
}
