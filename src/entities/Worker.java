package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department department;
	private List<HourContract> HourContracts = new ArrayList<HourContract>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getHourContracts() {
		return HourContracts;
	}

	public void addContract(HourContract contract) {
		HourContracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		HourContracts.remove(contract);
	}

	public Double income(Integer year, Integer mouth) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : HourContracts) {
			cal.setTime(c.getDate());
			int c_Year = cal.get(Calendar.YEAR);
			int c_Mouth = cal.get(Calendar.MONTH);
			if (year == c_Year && mouth == c_Mouth)
				sum += c.totalValue();
		}
		return sum;
	}
}
