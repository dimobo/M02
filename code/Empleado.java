package code;

import java.util.ArrayList;

public class Empleado {

	// Atributos del objeto empleado.
	protected String empleado;
	// protected double salario; En Minestrone 3 este deja de tener importancia
	// porque controlamos los sueldos de otra forma.

	// Atributos añadidos en la Milestone 3
	protected double salarioLimpioMensual, salarioSucioMensual, salarioLimpioAnual, salarioSucioAnual, beca, bonusAnual;
	protected boolean ayuda, bonus;

	// Esto representa la cantitad monetaria del ayuda governamental.
	protected final double AYUDAEUROS = 300;

	// Constructor por defecto.
	public Empleado() {

		empleado = "";
		// salario = 0; En Minestrone 3 este deja de tener importancia porque
		// controlamos los sueldos de otra forma.
		salarioLimpioMensual = 0;
		salarioLimpioAnual = 0;
		salarioSucioMensual = 0;
		salarioSucioAnual = 0;
		ayuda = false;
		bonus = false;
		beca = 0;

	}

	// Constructor para la clase empleado.
	public Empleado(String empleado, double salario, boolean ayuda, boolean bonus) {

		// En caso de que se introduzca un valor no aceptado para empleado se
		// introducira volunteer por defecto.
		if (empleadoDisponible().contains(empleado)) {
			this.empleado = empleado;
		} else {
			this.empleado = "Volunteer";
		}

		// Esto controlará si el empleado ha de recibir o no una ayuda (En caso que sea
		// volunteer y se indique).
		if (this.empleado.equals("Volunteer") && ayuda == true) {
			this.ayuda = true;
		} else
			this.ayuda = false;

		if (ayuda == true) {
			this.beca = AYUDAEUROS;
		}

		// this.salario = calcSalario(empleado, salario); En Minestrone 3 este deja de
		// tener importancia porque controlamos los sueldos de otra forma.

		this.salarioSucioMensual = calcSalario(empleado, salario);
		this.salarioSucioAnual = this.salarioSucioMensual * 12;
		this.salarioLimpioMensual = calcSalarioLimpio(empleado, this.salarioSucioMensual);
		this.salarioLimpioAnual = this.salarioLimpioMensual * 12;

		if (bonus == true) {
			this.bonusAnual = this.salarioSucioMensual * 0.1;
		} else
			this.bonusAnual = 0;

	}

	// Este método es una arraylist que contendrá los empleados posibles para poder
	// filtrarlos luego.
	protected ArrayList<String> empleadoDisponible() {
		ArrayList<String> empleadoList = new ArrayList<String>();

		empleadoList.add("Manager");
		empleadoList.add("Boss");
		empleadoList.add("Employee");
		empleadoList.add("Volunteer");

		return empleadoList;
	}

	// Este método calculará el salario final del empleado dependiendo de cuál sea
	// su posición.
	protected double calcSalario(String empleado, double salario) {

		switch (empleado) {
		case "Boss":
			return salario + salario * 0.50;
		case "Manager":
			return salario + salario * 0.10;
		case "Employee":
			return salario - salario * 0.15;
		case "Volunteer":
			return 0.0;
		default:
			return 0.0;
		}

	}

	// Este método calculará el salario limpio mensual de los trabajadores
	// dependiendo de su rango.
	protected double calcSalarioLimpio(String empleado, double salario) {

		switch (empleado) {
		case "Boss":
			return salario - salario * 0.32;
		case "Manager":
			return salario - salario * 0.26;
		case "Employee":
			return salario - salario * 0.15;
		case "Senior":
			return salario - salario * 0.24;
		case "Mid":
			return salario - salario * 0.15;
		case "Junior":
			return salario - salario * 0.02;
		case "Volunteer":
			return 0.0;
		default:
			return 0.0;
		}

	}

	// Zona getters and setters
	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public double getSalarioLimpioMensual() {
		return salarioLimpioMensual;
	}

	public double getSalarioSucioMensual() {
		return salarioSucioMensual;
	}

	public void setSalarioSucioMensual(double salarioSucioMensual) {
		this.salarioSucioMensual = salarioSucioMensual;
	}

	public double getSalarioLimpioAnual() {
		return salarioLimpioAnual;
	}

	public double getSalarioSucioAnual() {
		return salarioSucioAnual;
	}

}
