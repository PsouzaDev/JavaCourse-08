package entities;

import java.util.Date;

public class HourContract {

	public Date date;
	public Double ValuePerHour;
	public Integer hours;

	public HourContract() {
	}

	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		ValuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return ValuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		ValuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "HourContract [date=" + date + ", ValuePerHour=" + ValuePerHour + ", hours=" + hours + "]";
	}

	public Double totalValue() {
		return this.hours * this.ValuePerHour;
	}

}
