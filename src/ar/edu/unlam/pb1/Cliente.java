package ar.edu.unlam.pb1;

import java.util.Objects;

public class Cliente {

	private Integer Dni;
	private String nombre;
	private Double billetera;

//	No puedo tener clientes duplicados
//	Diseñar un algoritmo, tenemos que modificarlo para cumplir 2 condiciones
//	Array: Utilice la menor cantidad de memoria posible(No ponerle cantidad)
//	2da: No tiene que tener limite (hardware)
	
	
	public Cliente(Integer dni, String nombre) {
		Dni = dni;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Cliente [Dni=" + Dni + ", nombre=" + nombre + ", clientela=" + "]";
	}



}
