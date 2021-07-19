package main;

import empleado.Empleado;

public class EmpleadosApp {

	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado("boss", "boss", 10000);
		Empleado emp2 = new Empleado("employee", "junior", 1000);
		Empleado emp3 = new Empleado("volunteer", "volunteer", 0);
		Empleado emp4 = new Empleado("volunteer", "volunteer", 0);
		
		System.out.println("BOSS");
		System.out.println(emp1.toString());
		
		System.out.println("BONUS10% ASIGNADO A BOSS");
		emp1.bonus();
		System.out.println(emp1.toString());
		
		System.out.println("EMPLOYEE - JUNIOR");
		System.out.println(emp2.toString());
		
		System.out.println("VOLUNTEERS SIN AYUDA");
		System.out.println(emp3.toString());
		
		System.out.println("VOLUNTEER CON 300€ DE AYUDA");
		emp4.ayudaVolunteer();
		System.out.println(emp4.toString());

	}

}
