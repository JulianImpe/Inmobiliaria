package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Inmobiliaria {

	private String nombre;
	private final Integer CANTIDAD_DE_PROPIEDADES = 100;
	private ArrayList<Propiedad> propiedades;
	private HashSet<Cliente> clientes;
	private ArrayList<Casa> casas;
	private ArrayList<Departamento> departamentos;
	private ArrayList<PH> phs;
	private ArrayList<Terreno> terrenos;
	private ArrayList<Campo> campos;
	private Double cuenta;

	public Inmobiliaria() {
		this.clientes = new HashSet<>();
		this.casas = new ArrayList<Casa>();
		this.departamentos = new ArrayList<Departamento>();
		this.phs = new ArrayList<PH>();
		this.terrenos = new ArrayList<Terreno>();
		this.campos = new ArrayList<Campo>();
		this.propiedades = new ArrayList<>();
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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	public Boolean darDeAlta2Casas(Casa casita1, Casa casita2) {
		Boolean darDeAlta = Boolean.FALSE;
		if (darDeAlta == Boolean.FALSE && !casita1.getLocalidad()
				.equals(casita2.getLocalidad())
				&& casita1.getNumero() != casita2.getNumero()) {
			casas.remove(casita1);
			casas.remove(casita2);
			darDeAlta = Boolean.TRUE;
			return darDeAlta;
		}

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

	public ArrayList<Propiedad> ordenarPropiedadesPorPrecio(ArrayList<Propiedad> propiedades) {
		Propiedad aux = null;
		for (int i = 0; i < propiedades.size(); i++) {
			for (int j = 0; j < propiedades.size() - 1 - i; j++) {
				if (propiedades.get(j) != null && propiedades.get(j + 1) != null) {
					if (propiedades.get(j).getPrecio() > propiedades.get(j + 1).getPrecio()) {
						aux = propiedades.get(j);
						propiedades.set(j, propiedades.get(j + 1));
						propiedades.set(j + 1, aux);
					}
				}
			}
		}
		return propiedades;
	}

	public ArrayList<Propiedad> ordenarPropiedadesPorUbicacion(ArrayList<Propiedad> propiedades) {
		Propiedad aux = null;
		for (int i = 0; i < propiedades.size(); i++) {
			for (int j = 0; j < propiedades.size() - 1 - i; j++) {
				if (propiedades.get(j) != null && propiedades.get(j + 1) != null) {
					if (propiedades.get(j).getLocalidad().compareTo(propiedades.get(j + 1).getLocalidad()) > 0) {
						aux = propiedades.get(j);
						propiedades.set(j, propiedades.get(j + 1));
						propiedades.set(j + 1, aux);
					}
				}
			}
		}
		return propiedades;
	}

	public Propiedad buscarPropiedadPorPrecio(ArrayList<Propiedad> propiedades, Double precio) {
		for (Propiedad propiedad : propiedades) {
			if (propiedad != null && propiedad.getPrecio().equals(precio)) {
				return propiedad;
			}
		}
		return null;
	}

	public Propiedad buscarPropiedadPorUbicacion(ArrayList<Propiedad> propiedades, String ubicacion) {
		for (Propiedad propiedad : propiedades) {
			if (propiedad != null && propiedad.getLocalidad().equals(ubicacion)) {
				return propiedad;
			}
		}
		return null;
	}

	public Boolean realizarVentaDePropiedad(ArrayList<Propiedad> propiedades, ArrayList<Cliente> clientes,
			String ubicacion, Double precio) {
		Boolean ventaRealizada = false;
		Propiedad propiedad = buscarPropiedadPorUbicacion(propiedades, ubicacion);
		if (propiedad != null && propiedad.acciones.equals(AccionesParaLasPropiedades.VENTA)) {
			precio += this.cuenta;
			propiedades.remove(propiedad);

			for (Cliente cliente : clientes) {
				if (cliente != null && cliente.getBilletera() >= precio) {
					cliente.setBilletera(cliente.getBilletera() - precio);
					ventaRealizada = true;
					break;
				}
			}
		}
		return ventaRealizada;
	}

	public Boolean realizarAlquilerDePropiedad(ArrayList<Propiedad> propiedades, ArrayList<Cliente> clientes,
			String ubicacion, Double precioPorDia, Integer cantidadDias) {
		Boolean alquilerRealizado = false;
		Double precioTotal = 0.0;
		Propiedad propiedad = buscarPropiedadPorUbicacion(propiedades, ubicacion);
		if (propiedad != null && propiedad.acciones.equals(AccionesParaLasPropiedades.ALQUILER)) {
			precioTotal = precioPorDia * cantidadDias;
			precioTotal += this.cuenta;
			propiedades.remove(propiedad);

			for (Cliente cliente : clientes) {
				if (cliente != null && cliente.getBilletera() >= precioTotal) {
					cliente.setBilletera(cliente.getBilletera() - precioTotal);
					alquilerRealizado = true;
					break;
				}
			}
		}
		return alquilerRealizado;
	}

	public ArrayList<Propiedad> queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
	    ArrayList<Propiedad> propiedadesParaVenta = new ArrayList<>();
	    for (Propiedad propiedad : propiedades) {
	        if (propiedad.acciones.equals(AccionesParaLasPropiedades.VENTA)) {
	            propiedadesParaVenta.add(propiedad); 
	        }
	    }

	    return propiedadesParaVenta;
	}


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

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
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
