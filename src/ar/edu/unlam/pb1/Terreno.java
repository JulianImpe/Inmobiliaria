package ar.edu.unlam.pb1;

public class Terreno extends Propiedad {

	protected Boolean estaEdificado;
	protected Double precioMetroCuadrado;

	public Terreno(String localidad, Double precio, Integer codigo, String direccion,AccionesParaLasPropiedades acciones, Integer metrosCuadrados,
			Boolean estaEdificado, Double precioMetroCuadrado) {
		super(localidad, precio, codigo, direccion, metrosCuadrados, acciones);
		this.estaEdificado = estaEdificado;
		this.precioMetroCuadrado = precioMetroCuadrado;
	}

	public Boolean getEstaEdificado() {
		return estaEdificado;
	}

	public void setEstaEdificado(Boolean estaEdificado) {
		this.estaEdificado = estaEdificado;
	}

	public Double getPrecioMetroCuadrado() {
		return precioMetroCuadrado;
	}

	public void setPrecioMetroCuadrado(Double precioMetroCuadrado) {
		this.precioMetroCuadrado = precioMetroCuadrado;
	}

}
