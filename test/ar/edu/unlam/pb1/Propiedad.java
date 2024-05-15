package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Propiedad  {

	protected String localidad;
	protected Double precio;
	protected Integer codigo;
	protected String calle;
	protected Integer numero;
	protected Integer metrosCuadrados;

	public Propiedad(String localidad, Double precio, Integer codigo, String calle, Integer numero) {
		this.localidad = localidad;
		this.precio = precio;
		this.codigo = codigo;
		this.calle = calle;
		this.numero = numero;
		
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public Integer getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Integer metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
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

	@Override
	public String toString() {
		return "Propiedad [localidad=" + localidad + ", precio=" + precio + ", codigo=" + codigo + ", calle=" + calle
				+ ", numero=" + numero + ", metrosCuadrados=" + metrosCuadrados + "]";
	}



}
