package ar.edu.unlam.pb1;

import java.util.Arrays;
import java.util.Iterator;

public class Inmobiliaria {

	private String nombre;
	private final Integer CANTIDAD_DE_PROPIEDADES = 100;
	private Cliente clientes[];
	private Propiedad propiedades[];
	private Casa casas[];
	private Departamento departamentos[];
	private Double cuenta;

	public Inmobiliaria() {
		this.propiedades = new Propiedad[CANTIDAD_DE_PROPIEDADES];
		this.clientes = new Cliente[5];
		this.cuenta = (double) 100000;
		this.nombre = "Julian";
		this.casas = new Casa[10];
		this.departamentos = new Departamento[21];
	}

	public Boolean agregarCasa(Casa nueva) {
		Boolean agregada = false;
		for (int i = 0; i < casas.length; i++) {
			if (casas[i] == null) {
				casas[i] = nueva;
				return agregada = Boolean.TRUE;
			}
		}

		return agregada;

	}

	public Boolean agregarDepartamento(Departamento nuevo) {
		Boolean agregada = false;
		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i] == null) {
				departamentos[i] = nuevo;
				return agregada = Boolean.TRUE;
			}
		}

		return agregada;

	}

	public Boolean darDeAltaLaCasa(Casa casita) {
		Boolean dadaDeAlta = false;
		if (casita != null) {
			casita = null;
			return dadaDeAlta = Boolean.TRUE;
		}

		return dadaDeAlta;

	}

	public Boolean darDeAlta2Casas(Casa casita1, Casa casita2) {
		Boolean dadaDeAlta = false;
		if (casita1 != null && casita2 != null
				&& !(casita1.getCalle().equals(casita2.getCalle())
						&& casita1.getLocalidad().equals(casita2.getLocalidad())
						&& casita1.getNumero().equals(casita2.getNumero()))) {
			casita1 = null;
			casita2 = null;
			return dadaDeAlta = Boolean.TRUE;
		}

		return dadaDeAlta;
	}

	public Boolean darDeAltaElDepartamento(Departamento dpto) {
		Boolean agregada = false;
		if (dpto != null) {
			dpto = null;
			return agregada = Boolean.TRUE;
		}

		return agregada;

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
		Double precio = 0.0;
		Integer cantidadDeCasas = 0;
		Double promedio = 0.0;
		for (int i = 0; i < casas.length; i++) {
			if (casas[i] != null) {
				precio += casas[i].getPrecio();
				cantidadDeCasas++;
			}
		}

		promedio = precio / cantidadDeCasas;
		return promedio;

	}

	public Double obtenerValorPromedioDeLosDptos() {
		Double precio = 0.0;
		Integer cantidadDeDptos = 0;
		Double promedio = 0.0;
		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i] != null) {
				precio += departamentos[i].getPrecio();
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
	public Casa[] buscarCasasPorRangoDePrecio(Double precioMinimo, Double precioMaximo) {
		Integer cantidadDeCasas = 0;
		Casa[] casasBuscadas = new Casa[casas.length];

		for (int i = 0; i < casas.length; i++) {
			if (casas[i] != null && casas[i].getPrecio() >= precioMinimo && casas[i].getPrecio() <= precioMaximo) {
				casasBuscadas[cantidadDeCasas] = casas[i];
				cantidadDeCasas++;
			}
		}

		// Cree un nuevo array con la cantidad exacta de casas encontradas
		Casa[] resultado = null;
		if (cantidadDeCasas > 0) {
			resultado = new Casa[cantidadDeCasas];
			for (int i = 0; i < cantidadDeCasas; i++) {
				resultado[i] = casasBuscadas[i];
			}
		}

		return resultado;
	}

	public Boolean agregarPropiedad(Propiedad nueva) {
		Boolean agregada = false;
		for (int i = 0; i < propiedades.length; i++) {
			if (propiedades[i] == null) {
				propiedades[i] = nueva;
				return agregada = Boolean.TRUE;
			}
		}

		return agregada;

	}

	public Boolean agregarCliente(Cliente nuevo) {
		Boolean agregado = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				clientes[i] = nuevo;
				return agregado = Boolean.TRUE;
			}
		}

		return agregado;
	}

	public Boolean modificarPrecioDeLaPropiedad(Integer codigo, Double precio) {
		Boolean modificado = false;
		for (int i = 0; i < propiedades.length; i++) {
			if (propiedades[i] != null && propiedades[i].getCodigo() == codigo) {
				propiedades[i].setPrecio(precio);
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

	public Propiedad[] ordenarPropiedadesPorUbicacion(Propiedad[] propiedades) {
		Propiedad aux = null;
		for (int i = 0; i < propiedades.length; i++) {
			for (int j = 0; j < propiedades.length - 1 - i; j++) {
				if (propiedades[j] != null && propiedades[j + 1] != null) {
					if (propiedades[j].getUbicacion().compareTo(propiedades[j + 1].getUbicacion()) > 0) {

						aux = propiedades[j];
						propiedades[j] = propiedades[j + 1];
						propiedades[j + 1] = aux;
					}
				}
			}
		}
		return propiedades;
	}

	public Propiedad buscarPropiedadPorPrecio(Double precio) {
		Propiedad propiedadBuscada = null;
		for (int i = 0; i < propiedades.length; i++) {
			if (propiedades[i] != null && propiedades[i].getPrecio() == precio) {
				propiedadBuscada = propiedades[i];
				return propiedadBuscada;
			}
		}

		return propiedadBuscada;
	}

	public Propiedad buscarPropiedadPorUbicacion(String ubicacion) {
		Propiedad propiedadBuscada = null;
		for (int i = 0; i < propiedades.length; i++) {
			if (propiedades[i] != null && propiedades[i].getUbicacion().equals(ubicacion)) {
				propiedadBuscada = propiedades[i];
				return propiedadBuscada;
			}
		}

		return propiedadBuscada;

	}

	public Boolean realizarVentaDePropiedad(String ubicacion, Double precio) {
		Boolean ventaRealizada = false;
		buscarPropiedadPorUbicacion(ubicacion);
		for (int i = 0; i < propiedades.length; i++) {
			if (propiedades[i] != null) {
				precio += this.cuenta;
				propiedades[i] = null;

				for (int j = 0; j < clientes.length; j++) {
					if (clientes[j] != null && clientes[j].getBilletera() >= precio) {
						precio -= clientes[j].getBilletera();
						return ventaRealizada = Boolean.TRUE;
					}
				}

			}
		}
		return ventaRealizada;
	}

	public Boolean realizarAlquilerDePropiedad(String ubicacion, Double precioPorDia, Integer cantidadDias) {
		Boolean alquilerRealizado = false;
		Double precioTotal = 0.0;
		buscarPropiedadPorUbicacion(ubicacion);

		for (int i = 0; i < propiedades.length; i++) {
			if (propiedades[i] != null) {
				precioTotal = precioPorDia * cantidadDias;
				precioTotal += this.cuenta;
				propiedades[i] = null;

				for (int j = 0; j < clientes.length; j++) {
					if (clientes[j] != null && clientes[j].getBilletera() >= precioPorDia) {
						precioPorDia -= clientes[j].getBilletera();
						return alquilerRealizado = Boolean.TRUE;
					}
				}
			}
		}
		return alquilerRealizado;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public Propiedad[] getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Propiedad[] propiedades) {
		this.propiedades = propiedades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Inmobiliaria [nombre=" + nombre + ", CANTIDAD_DE_PROPIEDADES=" + CANTIDAD_DE_PROPIEDADES + ", clientes="
				+ Arrays.toString(clientes) + ", propiedades=" + Arrays.toString(propiedades) + ", cuenta=" + cuenta
				+ "]";
	}

}
