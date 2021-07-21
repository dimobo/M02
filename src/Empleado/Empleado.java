package Empleado;

public class Empleado {

	private String rangoEmpelado;
	private String tipoEmpleado;
	private double salario;
	
	// Constructor
	public Empleado(String rangoEmpelado, String tipoEmpleado, double salario) {
		setRangoEmpelado(rangoEmpelado);
		setTipoEmpleado(tipoEmpleado);
		setSalario(salario);
	}
	
	// Coge el rango de empleado y verifica que sea correcto, luego lo retorna.
	public String tipoDeEmpleado() {
		
		// Coge el rango asignado a un empleado.
		String empleado = getRangoEmpleado();
		empleado.toLowerCase(); // Pasa a lower case.
		
		// String donde se guarda el tipo de empleado que es.
		String tipoEmpleado = getTipoEmpleado();
		tipoEmpleado.toLowerCase();
		
		switch (empleado) {
		case "boss":
			tipoEmpleado = "boss";
			break;
			
		case "manager":
			tipoEmpleado = "manager";
			break;
		
		case "empleado":
			
			if(tipoEmpleado.equalsIgnoreCase("senior")) {
				tipoEmpleado = "senior";
			}else if(tipoEmpleado.equalsIgnoreCase("mid")){
				tipoEmpleado = "mid";
			}else if(tipoEmpleado.equalsIgnoreCase("junior")){
				tipoEmpleado = "junior";
			}
			break;
			
		case "volunteer":
			tipoEmpleado = "volunteer";

			break;
		}
		
		return tipoEmpleado;
	}
	
	// Funcion que comprueba que tipo de empleado es y calcula el salario neto.
	public double calculaSueldoNeto() {
		//Salario.
		double salarioEmpleado = getSalario();
		double sueldoNeto = 0;
		
		// Guarda el tipo de empleado que viene verificado de la funcion anterior.
		String tipoEmpleado = tipoDeEmpleado();
		tipoEmpleado.toLowerCase(); // Pasa a lower case para asegurar.
		
		// Comprueba que tipo de empleado es, luego comprueba el salario y calcula.
		switch (tipoEmpleado) {
		
		case "boss":
			if(salarioEmpleado > 8000) {
				// Boss cobra un 50% mas.
				sueldoNeto = sueldoNeto + (salarioEmpleado*0.50);
				//Calcula el sueldo neto.
				sueldoNeto = calculaBrutoMensual() - (salarioEmpleado * 0.32);
			}else {
				sueldoNeto = 0; // Si el salario no es correcto lo pone a 0.
			}
			break;
			
		case "manager":
			if(salarioEmpleado > 3000 && getSalario() < 5000) {
				// Manager cobra un 10% mas.
				sueldoNeto = sueldoNeto + (salarioEmpleado*0.10);
				//Calcula el sueldo neto.
				sueldoNeto = calculaBrutoMensual() - (salarioEmpleado * 0.26);
			}else {
				sueldoNeto = 0; // Si el salario no es correcto lo pone a 0.
			}
			break;
			
		case "senior":
			if(salarioEmpleado > 2700 && salarioEmpleado < 4000) {
				// Empleado raso cobra 15% menos.
				sueldoNeto =  sueldoNeto - (salarioEmpleado*0.15);
				// Senior reduccion del 5%
				sueldoNeto = sueldoNeto -(this.salario*0.5);
				//Calcula el sueldo neto.
				sueldoNeto = calculaBrutoMensual() - (salarioEmpleado * 0.24);
			}else {
				sueldoNeto = 0; // Si el salario no es correcto lo pone a 0.
			}
			break;
			
		case "mid":
			if(salarioEmpleado > 1800 && salarioEmpleado < 2500) {
				// Empleado raso cobra 15% menos.
				sueldoNeto =  sueldoNeto - (salarioEmpleado*0.15);
				// Mid reduccion 10%
				sueldoNeto = sueldoNeto -(this.salario*0.10);
				//Calcula el sueldo neto.
				sueldoNeto = calculaBrutoMensual() - (salarioEmpleado * 0.15);
			}else {
				sueldoNeto = 0; // Si el salario no es correcto lo pone a 0.
			}
			break;
		
		case "junior":
			if(salarioEmpleado > 900 && salarioEmpleado < 1600) {
				// Empleado raso cobra 15% menos.
				sueldoNeto =  sueldoNeto - (salarioEmpleado*0.15);
				// Junior reduccion 15%
				sueldoNeto = sueldoNeto -(this.salario*0.15);
				//Calcula el sueldo neto.
				sueldoNeto = calculaBrutoMensual() -(salarioEmpleado * 0.2);
			}else {
				sueldoNeto = 0; // Si el salario no es correcto lo pone a 0.
			}
			break;
			
		case "volunteer":
			if(salarioEmpleado > 0) {
				// Empleado raso cobra 15% menos.
				sueldoNeto =  getSalario(); // En caso de tener una ayuda gubernamental.
			}else {
				sueldoNeto = 0;
			}
			break;
			
		}
		return sueldoNeto;
	}
	
	// Funciones sueldo neto y bruto mensual, neto y bruto anual.
	public double calculaNetoMensual() {
		return calculaSueldoNeto();
	}
	public double calculaBrutoMensual() {
		return getSalario();
	}
	public double calculaNetoAnual() {
		return calculaSueldoNeto()*12;
	}
	public double calculaBrutoAnual() {
		return getSalario()*12;
	}
	
	// Funcion añade un bonus a la plantilla.
	public void bonus() {
		
		// Calcula el bonus (10% del salario anual).
		double bonus = ( calculaNetoAnual()*0.10 );
		
		String tipoEmpleado = getRangoEmpleado();
		
		switch (tipoEmpleado) {
		case "boss":
			this.salario += bonus;
			break;
			
		case "manager":
			this.salario += bonus;	
			break;
			
		case "employee":
			this.salario += bonus;
			break;
		}
		
		System.out.println("Bonus del 10% asignado.");
	}
	
	// Ayuda del gobierno de 300 euros a voluntario
	public void ayudaVolunteer() {
		
		String tipoEmpleado = getRangoEmpleado();
		
		if(tipoEmpleado.equalsIgnoreCase("volunteer")) {
			this.salario = 300;
		}
		
		System.out.println("Asignados 300€ de ayuda gubernamental por ser voluntario.");
		
	}
	
	// Metodo toString()
	public String toString() {
		return "Rango: " + getRangoEmpleado() + "."
			+ "\nTipo de empleado: " + getTipoEmpleado() + "."
			+ "\nSalario: " + getSalario() + "€."
			+ "\nSalario neto: " + calculaSueldoNeto() + "€."
			+ "\nSalario neto mensual: " + calculaNetoMensual() + "€."
			+ "\nSalario bruto mensual: " + calculaBrutoMensual() + "€."
			+ "\nSalario neto anual: " + calculaNetoAnual() + "€."
			+ "\nSalario bruto anual: " + calculaBrutoAnual() + "€.\n";
	}
	
	// Getters.
	public double getSalario() {
		return salario;
	}
	public String getTipoEmpleado() {
		return tipoEmpleado;
	}
	public String getRangoEmpleado() {
		return rangoEmpelado;
	}

	// Setters.
	public void setRangoEmpelado(String rangoEmpelado) {
		this.rangoEmpelado = rangoEmpelado;
	}
	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}	
	
}
