package ar.edu.unlam.pb1;

public class Departamento extends Propiedad {

	private Integer piso;
	private String departamento;
	private Integer ambientes;
	private Integer dormitorios;
	private Integer banios;


	public Departamento(String localidad, Double precio, Integer codigo, String calle, Integer numero,AccionesParaLasPropiedades acciones,
			  Integer piso, String departamento) {
		super(localidad, precio, codigo, calle, numero, acciones);
		this.piso = piso;
		this.departamento = departamento;
		
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


	@Override
	public String toString() {
		return "Departamento [localidad=" + localidad + ", precio=" + precio + ", codigo=" + codigo + ", calle=" + calle
				+ ", numero=" + numero + ", metrosCuadrados=" + metrosCuadrados + ", acciones=" + acciones + "]";
	}

	

}
