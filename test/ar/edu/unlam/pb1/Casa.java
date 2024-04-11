package ar.edu.unlam.pb1;

public class Casa {

	private String calle;
	private Integer numero;
	private String localidad;
	private Double precio;
	
	public Casa(String calle, Integer numero, String localidad, Double precio) {
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.precio=precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Casa [calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + "]";
	}
	
}
