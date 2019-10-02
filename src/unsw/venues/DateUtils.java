package unsw.venues;

import java.time.LocalDate;

public class DateUtils {

	/**
	 * Check if dateStart->dateEnd is within rangeStart->rangeEnd (inclusive).
	 * rangeStart and rangeEnd is optional, but one must be present
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param rangeStart (optional)
	 * @param rangeEnd   (optional)
	 * @return boolean
	 */
	public static boolean dateRangeInDateRange(LocalDate dateStart, LocalDate dateEnd, LocalDate rangeStart,
			LocalDate rangeEnd) {

		// Either `rangeStart` or `rangeEnd` must be present
		if (rangeStart == null && rangeEnd == null)
			return false;

		if (rangeStart != null) {
			if (!(dateStart.isEqual(rangeStart) || dateStart.isAfter(rangeStart))) {
				return false;
			}
		}

		if (rangeEnd != null) {
			if (!(dateEnd.isEqual(rangeEnd) || dateEnd.isBefore(rangeEnd))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Check if dateStart->dateEnd overlaps rangeStart->rangeEnd (inclusive)
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param rangeStart
	 * @param rangeEnd
	 * @return boolean
	 */
	public static boolean dateRangeOverlapsDateRange(LocalDate dateStart, LocalDate dateEnd, LocalDate rangeStart,
			LocalDate rangeEnd) {

		return ((dateStart.isBefore(rangeEnd) || dateStart.isEqual(rangeEnd))
				&& (dateEnd.isAfter(rangeStart) || dateEnd.isEqual(rangeStart)));
	}

}
