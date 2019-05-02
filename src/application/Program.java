package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("DD/MM/YYYY");	
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name= sc.nextLine();
		System.out.print("Level: ");
		String level= sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary= sc.nextDouble();
		Worker worker= new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
		int nContract= sc.nextInt();
		
		for (int i = 0; i < nContract; i++) {
			System.out.println("Enter contract #"+(i+1)+ " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf1.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour= sc.nextDouble();
			sc.hasNextLine();
			System.out.print("Duration (hours): ");
			int hours= sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String cDate= sc.next();
		Integer year= Integer.parseInt(cDate.substring(0, 2));
		Integer mouth= Integer.parseInt(cDate.substring(3));
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Income for "+ cDate+": "+ worker.income(year, mouth));
	
		
		sc.close();
	}

}
