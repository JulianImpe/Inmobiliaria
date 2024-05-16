package ar.edu.unlam.pb1;

public class Campo extends Propiedad {

	protected String nombre;
	protected Boolean estaEnProduccion;
	
	public Campo(String localidad, Double precio, Integer codigo, String direccion, Integer metrosCuadrados,AccionesParaLasPropiedades acciones,
			String nombre, Boolean estaEnProduccion) {
		super(localidad, precio, codigo, direccion, metrosCuadrados, acciones);
		this.nombre = nombre;
		this.estaEnProduccion = estaEnProduccion;
	}

	
}
