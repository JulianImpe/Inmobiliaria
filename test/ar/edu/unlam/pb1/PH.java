package ar.edu.unlam.pb1;

public class PH extends Propiedad {

	protected Integer piso;
	protected Integer ambientes;
	protected Integer dormitorios;
	protected Integer banios;

	public PH(String localidad, Double precio, Integer codigo, String direccion, Integer metrosCuadrados, Integer piso,
			Integer ambientes, Integer dormitorios, Integer banios) {
		super(localidad, precio, codigo, direccion, metrosCuadrados);
		this.piso = piso;
		this.ambientes = ambientes;
		this.dormitorios = dormitorios;
		this.banios = banios;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
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

}
