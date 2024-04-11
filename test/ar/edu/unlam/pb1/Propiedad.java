package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Propiedad {

	private String ubicacion;
	private Double precio;
	private TiposDePropiedades tipos;
//	private Cliente clientes[];
	private Integer precioAlquilerXDia;
	private Integer codigo;
	
	
	public Propiedad(String ubicacion, Double precio, TiposDePropiedades tipos,
			Integer precioAlquiler, Integer codigo) {
		this.ubicacion = ubicacion;
		this.precio = precio;
		this.tipos = tipos;
		this.precioAlquilerXDia = precioAlquiler;
		this.codigo = codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public TiposDePropiedades getTipos() {
		return tipos;
	}

	public void setTipos(TiposDePropiedades tipos) {
		this.tipos = tipos;
	}

//	public Cliente[] getInquilino() {
//		return clientes;
//	}
//
//	public void setInquilino(Cliente[] inquilino) {
//		this.clientes = inquilino;
//	}

	public Integer getPrecioAlquilerXDia() {
		return precioAlquilerXDia;
	}

	public void setPrecioAlquilerXDia(Integer cantidadDeDiasAlquilada) {
		this.precioAlquilerXDia = cantidadDeDiasAlquilada;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Propiedad [ubicacion=" + ubicacion + ", precio=" + precio + ", tipos=" + tipos 
				+ ", precioAlquilerPorDia=" + precioAlquilerXDia + "]";
	}

}
