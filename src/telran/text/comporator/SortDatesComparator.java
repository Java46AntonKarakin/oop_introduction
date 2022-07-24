package telran.text.comporator;

import java.util.Comparator;

public class SortDatesComparator implements Comparator<String> {

	@Override
	public int compare(String st1, String st2) {
		String[] date1 = st1.split("/");
		String[] date2 = st2.split("/");

		if (date1[2].compareTo(date2[2]) != 0) {					
			return date1[2].compareTo(date2[2]) > 0 ? 1 : -1;			// if the 1st and the 2nd YYYY are not equal
		} else 
		if (date1[1].compareTo(date2[1]) != 0) {
			return date1[1].compareTo(date2[1]) > 0 ? 1 : -1;			// if the 1st and the 2nd MM are not equal
		} else 
		if (date1[0].compareTo(date2[0]) != 0) {
			return date1[0].compareTo(date2[0]) > 0 ? 1 : -1;			// if the 1st and the 2nd DD are not equal
		}
		return 0;
	}
}