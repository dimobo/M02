package code;

public class M02APP {
	public static void main(String[] args) {
		
		TipoEmpleado arrayTipEmp[] = new TipoEmpleado[6];
		Empleado arrayEmp[] = new Empleado[6];
		
		arrayTipEmp[0] = new TipoEmpleado();
		arrayEmp[0] = new Empleado();
		
		
		System.out.println(arrayTipEmp[0].getSalario());
	}

}
