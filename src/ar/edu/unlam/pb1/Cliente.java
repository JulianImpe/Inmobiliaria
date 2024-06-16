package ar.edu.unlam.pb1;

import java.util.Objects;

public class Cliente {

	private Integer Dni;
	private String nombre;
	private Double billetera;
	private Propiedad propiedad;
	
	
	public Cliente(Integer dni, String nombre, Propiedad propiedad) {
		Dni = dni;
		this.nombre = nombre;
		this.propiedad = propiedad;
		this.billetera=(double) 1000000;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Dni, other.Dni);
	}

	public Integer getDni() {
		return Dni;
	}

	public void setDni(Integer dni) {
		Dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getBilletera() {
		return billetera;
	}

	public void setBilletera(Double billetera) {
		this.billetera = billetera;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	public String toString() {
		return "Cliente [Dni=" + Dni + ", nombre=" + nombre + ", clientela=" + "]";
	}



}
