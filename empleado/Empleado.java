package empleado;

public class Empleado {

	// Atributos.
	private int salario;
	private String tipoEmpelado;
	
	// Constructores.
	// Por defecto
	public Empleado() {
		this.tipoEmpelado = "";
		this.salario = 0;
	}
	// Con los atributos
	public Empleado(String tipoEmpleado, int salario) {
		this.tipoEmpelado = tipoEmpelado;
		this.salario = salario;
	}
	
	// Funcion que comprueba si el tipo de empleado es correcto.
	public boolean tipoDeEmpleados(String tipoEmpleado) {
		boolean correcto;
		tipoEmpleado.toLowerCase();
		
		switch (tipoEmpleado) {
		case "manager":
			correcto = true;	
			break;
				
		case "boss":
			correcto = true;
			break;
			
		case "employee":
			correcto = true;
			break;
			
		case "volunteer":
			correcto = true;
			break;

		default:
			correcto = false;
			break;
		}
		
		return correcto;
		
	}
	
}
