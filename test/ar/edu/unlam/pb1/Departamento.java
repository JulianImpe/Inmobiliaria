package ar.edu.unlam.pb1;

public class Departamento {

	private String calle;
	private Integer numero;
	private Integer piso;
	private String departamento;
	private String localidad;
	private Double precio;
	
	public Departamento(String calle, Integer numero, Integer piso, String departamento, String localidad, Double precio) {
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.departamento = departamento;
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

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Departamento [calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", departamento="
				+ departamento + ", localidad=" + localidad + "]";
	}

}
