package ar.edu.unlam.pb1;

public class Cliente {

	private Integer Dni;
	private String nombre;
	private Double billetera;

	public Cliente(Integer dni, String nombre) {
		Dni = dni;
		this.nombre = nombre;
		this.billetera=(double) 1000000;
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
