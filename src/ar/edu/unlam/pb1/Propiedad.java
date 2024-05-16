package ar.edu.unlam.pb1;

import java.util.Arrays;
import java.util.Objects;

public class Propiedad  {

	protected String localidad;
	protected Double precio;
	protected Integer codigo;
	protected String calle;
	protected Integer numero;
	protected Integer metrosCuadrados;
	protected AccionesParaLasPropiedades acciones;

	public Propiedad(String localidad, Double precio, Integer codigo, String calle, Integer numero,AccionesParaLasPropiedades acciones) {
		this.localidad = localidad;
		this.precio = precio;
		this.codigo = codigo;
		this.calle = calle;
		this.numero = numero;
		this.acciones=acciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, codigo, localidad, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(localidad, other.localidad) && Objects.equals(numero, other.numero);
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
