package code;

import java.util.ArrayList;

public class Empleado {

	// Atributos del objeto empleado.
	protected String empleado;
	protected double salario;

	// Constructor para la clase empleado.
	public Empleado(String empleado, double salario) {

		if (empleadoDisponible().contains(empleado)) {
			this.empleado = empleado;
		} else {
			this.empleado = "Volunteer";
		}

		this.salario = calcSalario(empleado, salario);

	}

	// Este m�todo es una arraylist que contendr� los empleados posibles para poder
	// filtrarlos luego.
	protected ArrayList<String> empleadoDisponible() {
		ArrayList<String> empleadoList = new ArrayList<String>();

		empleadoList.add("Manager");
		empleadoList.add("Boss");
		empleadoList.add("Employee");
		empleadoList.add("Volunteer");

		return empleadoList;
	}

	// Este m�todo calcular� el salario final del empleado dependiendo de cu�l sea
	// su posici�n.
	protected double calcSalario(String empleado, double salario) {

		switch (empleado) {
		case "Boss":
			return salario + salario * 0.50;
		case "Manager":
			return salario + salario + salario * 0.10;
		case "Employee":
			return salario - salario * 0.10;
		case "Volunteer":
			return 0.0;
		default:
			return 0.0;
		}

	}

}
