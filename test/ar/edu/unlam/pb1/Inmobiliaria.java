package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Inmobiliaria {

	private String nombre;
	private final Integer CANTIDAD_DE_PROPIEDADES = 100;
	private ArrayList<Propiedad> propiedades;
	private ArrayList<Cliente> clientes;
	private ArrayList<Casa> casas;
	private ArrayList<Departamento> departamentos;
	private ArrayList<PH> phs;
	private ArrayList<Terreno> terrenos;
	private ArrayList<Campo> campos;
	private Double cuenta;

	public Inmobiliaria() {
		this.clientes = new ArrayList<Cliente>();
		this.casas = new ArrayList<Casa>();
		this.departamentos = new ArrayList<Departamento>();
		this.phs = new ArrayList<PH>();
		this.terrenos = new ArrayList<Terreno>();
		this.campos = new ArrayList<Campo>();
		this.cuenta = (double) 100000;
		this.nombre = "Julian";

	}

//	No puedo tener clientes duplicados
//	Diseñar un algoritmo, tenemos que modificarlo para cumplir 2 condiciones
//	Array: Utilice la menor cantidad de memoria posible
//	2da: No tiene que tener limite (hardware)
	public Boolean agregarCasa(Casa nueva) {

		return this.casas.add(nueva);

	}

	public Boolean agregarDepartamento(Departamento nuevo) {

		return departamentos.add(nuevo);

	}

	public Boolean darDeAltaLaCasa(Casa casita) {

		return casas.remove(casita);

	}

	public Boolean darDeAlta2Casas(Casa casita1, Casa casita2) {
		Boolean darDeAlta = Boolean.FALSE;
		if (darDeAlta == Boolean.FALSE) {
			casas.remove(casita1);
			casas.remove(casita2);
		}
		darDeAlta = Boolean.TRUE;

		return darDeAlta;

	}

	public Boolean darDeAltaElDepartamento(Departamento dpto) {

		return departamentos.remove(dpto);

	}

	public Boolean darDeAlta2Dptos(Departamento dpto1, Departamento dpto2) {
		Boolean dadaDeAlta = false;
		if (dpto1 != null && dpto2 != null
				&& !(dpto1.getCalle().equals(dpto2.getCalle()) && dpto1.getLocalidad().equals(dpto2.getLocalidad())
						&& dpto1.getNumero().equals(dpto2.getNumero()) && dpto1.getPiso().equals(dpto2.getPiso())
						&& dpto1.getDepartamento().equals(dpto2.getDepartamento()))) {
			dpto1 = null;
			dpto2 = null;
			return dadaDeAlta = Boolean.TRUE;
		}

		return dadaDeAlta;
	}

	public Double obtenerValorPromedioDeLasCasas() {
		Double precioTotal = 0.0;
		Integer cantidadDeCasas = 0;
		Double promedio = 0.0;
		for (Casa casas : casas) {
			precioTotal += casas.getPrecio();
			cantidadDeCasas++;
		}

		promedio = precioTotal / cantidadDeCasas;
		return promedio;

	}

	public Double obtenerValorPromedioDeLosDptos() {
		Double precio = 0.0;
		Integer cantidadDeDptos = 0;
		Double promedio = 0.0;
		for (Departamento deptos : this.departamentos) {
			if (deptos != null) {
				precio += deptos.getPrecio();
				cantidadDeDptos++;
			}
		}

		promedio = precio / cantidadDeDptos;
		return promedio;

	}

//	public Casa[] buscarCasasPorRangoDePrecio(Double precioMinimo, Double precioMaximo) {
//		int cantidadDeCasas = 0;
//		Casa[] casasBuscadas = new Casa[casas.length];
//		for (int i = 0; i < casas.length; i++) {
//			if (casas[i] != null && casas[i].getPrecio() >= precioMinimo && casas[i].getPrecio() <= precioMaximo) {
//				casasBuscadas[cantidadDeCasas] = casas[i];
//				cantidadDeCasas++;
//			}
//		}
//
//		return casasBuscadas;
//	}
	public ArrayList<Casa> buscarCasasPorRangoDePrecio(Double precioMinimo, Double precioMaximo) {
		ArrayList<Casa> casasBuscadas = new ArrayList<Casa>();

		for (Casa i : this.casas) {
			if (i.getPrecio() >= precioMinimo && i.getPrecio() <= precioMaximo) {
				casasBuscadas.add(i);

			}
		}
		return casasBuscadas;

	}

	public Boolean agregarPropiedad(Propiedad nueva) {

		return this.propiedades.add(nueva);

	}

	public Boolean agregarCliente(Cliente nuevo) {

		return this.clientes.add(nuevo);

	}

	public Boolean modificarPrecioDeLaPropiedad(Integer codigo, Double precio) {
		Boolean modificado = false;
		for (Propiedad i : this.propiedades) {
			if (i != null && i.getCodigo() == codigo) {
				i.setPrecio(precio);
				return modificado = Boolean.TRUE;
			}
		}
		return modificado;
	}

	public Propiedad[] ordenarPropiedadesPorPrecio(Propiedad[] propiedades) {
		Propiedad aux = null;
		for (int i = 0; i < propiedades.length; i++) {
			for (int j = 0; j < propiedades.length - 1 - i; j++) {
				if (propiedades[j] != null && propiedades[j + 1] != null) {
					if (propiedades[j].getPrecio() > propiedades[j + 1].getPrecio()) {

						aux = propiedades[j];
						propiedades[j] = propiedades[j + 1];
						propiedades[j + 1] = aux;
					}
				}
			}
		}
		return propiedades;
	}

//	public Propiedad[] ordenarPropiedadesPorUbicacion(Propiedad[] propiedades) {
//		Propiedad aux = null;
//		for (int i = 0; i < propiedades.length; i++) {
//			for (int j = 0; j < propiedades.length - 1 - i; j++) {
//				if (propiedades[j] != null && propiedades[j + 1] != null) {
//					if (propiedades[j].getUbicacion().compareTo(propiedades[j + 1].getUbicacion()) > 0) {
//
//						aux = propiedades[j];
//						propiedades[j] = propiedades[j + 1];
//						propiedades[j + 1] = aux;
//					}
//				}
//			}
//		}
//		return propiedades;
//	}
//
//	public Propiedad buscarPropiedadPorPrecio(Double precio) {
//		Propiedad propiedadBuscada = null;
//		for (int i = 0; i < propiedades.length; i++) {
//			if (propiedades[i] != null && propiedades[i].getPrecio() == precio) {
//				propiedadBuscada = propiedades[i];
//				return propiedadBuscada;
//			}
//		}
//
//		return propiedadBuscada;
//	}
//
//	public Propiedad buscarPropiedadPorUbicacion(String ubicacion) {
//		Propiedad propiedadBuscada = null;
//		for (int i = 0; i < propiedades.length; i++) {
//			if (propiedades[i] != null && propiedades[i].getUbicacion().equals(ubicacion)) {
//				propiedadBuscada = propiedades[i];
//				return propiedadBuscada;
//			}
//		}
//
//		return propiedadBuscada;
//
//	}
//
//	public Boolean realizarVentaDePropiedad(String ubicacion, Double precio) {
//		Boolean ventaRealizada = false;
//		buscarPropiedadPorUbicacion(ubicacion);
//		for (int i = 0; i < propiedades.length; i++) {
//			if (propiedades[i] != null) {
//				precio += this.cuenta;
//				propiedades[i] = null;
//
//				for (int j = 0; j < clientes.length; j++) {
//					if (clientes[j] != null && clientes[j].getBilletera() >= precio) {
//						precio -= clientes[j].getBilletera();
//						return ventaRealizada = Boolean.TRUE;
//					}
//				}
//
//			}
//		}
//		return ventaRealizada;
//	}
//
//	public Boolean realizarAlquilerDePropiedad(String ubicacion, Double precioPorDia, Integer cantidadDias) {
//		Boolean alquilerRealizado = false;
//		Double precioTotal = 0.0;
//		buscarPropiedadPorUbicacion(ubicacion);
//
//		for (int i = 0; i < propiedades.length; i++) {
//			if (propiedades[i] != null) {
//				precioTotal = precioPorDia * cantidadDias;
//				precioTotal += this.cuenta;
//				propiedades[i] = null;
//
//				for (int j = 0; j < clientes.length; j++) {
//					if (clientes[j] != null && clientes[j].getBilletera() >= precioPorDia) {
//						precioPorDia -= clientes[j].getBilletera();
//						return alquilerRealizado = Boolean.TRUE;
//					}
//				}
//			}
//		}
//		return alquilerRealizado;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}

	public void setCasas(ArrayList<Casa> casas) {
		this.casas = casas;
	}

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public ArrayList<PH> getPhs() {
		return phs;
	}

	public void setPhs(ArrayList<PH> phs) {
		this.phs = phs;
	}

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	public void setTerrenos(ArrayList<Terreno> terrenos) {
		this.terrenos = terrenos;
	}

	public ArrayList<Campo> getCampos() {
		return campos;
	}

	public void setCampos(ArrayList<Campo> campos) {
		this.campos = campos;
	}

	public Double getCuenta() {
		return cuenta;
	}

	public void setCuenta(Double cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getCANTIDAD_DE_PROPIEDADES() {
		return CANTIDAD_DE_PROPIEDADES;
	}


}
