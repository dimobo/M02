package code;

import java.util.ArrayList;

public class TipoEmpleado extends Empleado {

	// Esta es la zona de constructores, simplemente estamos aprovechando los que
	// teníamos en la clase padre.
	public TipoEmpleado() {
		super();
	}

	public TipoEmpleado(String empleado, double salario, boolean ayuda, boolean bonus) {
		super(empleado, salario, ayuda, bonus);

	}

	// Aquí estamos sobreescribiendo la lista de empleados disponibles para añadir
	// los tipos nuevos.
	@Override
	protected ArrayList<String> empleadoDisponible() {
		ArrayList<String> empleadoList = new ArrayList<String>();

		empleadoList.add("Manager");
		empleadoList.add("Boss");
		empleadoList.add("Junior");
		empleadoList.add("Mid");
		empleadoList.add("Senior");
		empleadoList.add("Volunteer");

		return empleadoList;
	}

	// Aquí estamos sobreescribiendo el método calcSalario que ya teníamos para
	// introducir los nuevos tipos de empleados y las condiciones de los salarios.
	@Override
	protected double calcSalario(String empleado, double salario) {
		double salario2 = 0;

		// En caso de introducir un salario no válido automáticamente se establecerá el
		// salario mínimo para el tipo de trabajador.
		switch (empleado) {
		case "Boss":
			salario2 = salario + salario * 0.50;
			if (salario2 > 8000) {
				return salario2;
			} else
				return 8001;
		case "Manager":
			salario2 = salario + salario + salario * 0.10;
			if (salario2 > 3000 && salario2 < 5000) {
				return salario2;
			} else
				return 3001;
		case "Senior":
			salario2 = salario - salario * 0.05;
			if (salario2 > 2700 && salario2 < 4000) {
				return salario2;
			} else
				return 2701;
		case "Mid":
			salario2 = salario - salario * 0.10;
			if (salario2 > 1800 && salario2 < 2500) {
				return salario2;
			} else
				return 1801;
		case "Junior":
			salario2 = salario - salario * 0.15;
			if (salario2 > 900 && salario2 < 1600) {
				return salario2;
			} else
				return 901;
		case "Volunteer":
			if (salario == 0) {
				return salario;
			} else
				return 0;

		default:
			return 0;
		}
	}

}
