package unsw.venues;

import java.time.LocalDate;

public class LocalDateRange {
	private LocalDate dateStart;
	private LocalDate dateEnd;

	public LocalDateRange(LocalDate dateStart, LocalDate dateEnd) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	/**
	 * @return Start date
	 */
	public LocalDate getStart() {
		return this.dateStart;
	}

	/**
	 * @return End date
	 */
	public LocalDate getEnd() {
		return this.dateEnd;
	}

	/**
	 * Check if the date overlaps another LocalDateRange
	 * 
	 * @param dateRange
	 * @return boolean
	 */
	public boolean overlaps(LocalDateRange dateRange) {
		return DateUtils.dateRangeOverlapsDateRange(this.dateStart, this.dateEnd, dateRange.getStart(),
				dateRange.getEnd());
	}

	/**
	 * Check if the date overlaps another LocalDateRange
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return boolean
	 */
	public boolean overlaps(LocalDate dateStart, LocalDate dateEnd) {
		return DateUtils.dateRangeOverlapsDateRange(this.dateStart, this.dateEnd, dateStart, dateEnd);

	}

	@Override
	public String toString() {
		return this.dateStart.toString() + "->" + this.dateEnd.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		LocalDateRange localDateRangeObj = (LocalDateRange) obj;
		return (this.dateStart.equals(localDateRangeObj.getStart()) && this.dateEnd.equals(localDateRangeObj.getEnd()));
	}

	public boolean equals(LocalDate startDate, LocalDate endDate) {
		return (this.dateStart.equals(dateStart) && this.dateEnd.equals(this.dateEnd));
	}
}
