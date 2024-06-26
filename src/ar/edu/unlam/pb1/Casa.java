package ar.edu.unlam.pb1;

public class Casa extends Propiedad {

	private Integer ambientes;
	private Integer dormitorios;
	private Integer banios;


	public Casa(String localidad, Double precio, Integer codigo, String calle, 
			Integer numero,AccionesParaLasPropiedades acciones) {
		super(localidad, precio, codigo, calle, numero, acciones);
		this.precio=precio;
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

	public Integer getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(Integer ambientes) {
		this.ambientes = ambientes;
	}

	public Integer getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}

	public Integer getBanios() {
		return banios;
	}

	public void setBanios(Integer banios) {
		this.banios = banios;
	}
	
	public Double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Casa [localidad=" + localidad + ", precio=" + precio + ", codigo=" + codigo + ", calle=" + calle
				+ ", numero=" + numero + ", metrosCuadrados=" + metrosCuadrados + ", acciones=" + acciones + "]";
	}

	
}
