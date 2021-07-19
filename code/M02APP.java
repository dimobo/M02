package code;

public class M02APP {
	public static void main(String[] args) {

		TipoEmpleado arrayTipEmp[] = new TipoEmpleado[7];
		Empleado arrayEmp[] = new Empleado[7];

		arrayTipEmp[0] = new TipoEmpleado();
		arrayTipEmp[1] = new TipoEmpleado("Boss", 9000, false, true);
		arrayTipEmp[2] = new TipoEmpleado("Manager", 9000, false, false);
		arrayTipEmp[3] = new TipoEmpleado("Manager", 4000, false, true);
		arrayTipEmp[4] = new TipoEmpleado("Senior", 2500, false, false);
		arrayTipEmp[5] = new TipoEmpleado("Volunteer", 0, true, false);
		arrayTipEmp[6] = new TipoEmpleado("Volunteer", 100, true, false);
		
		for(int i= 0; i< arrayTipEmp.length; i++) {
			System.out.println(arrayTipEmp[i].toString());
		}

	}

}
