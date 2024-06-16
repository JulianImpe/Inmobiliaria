package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Inmobiliaria implements GestionPropiedades {

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

	public Boolean agregarCliente(Cliente nuevo) {
		return this.clientes.add(nuevo);
	}

	public Boolean agregarCasa(Casa nueva) {
		return this.casas.add(nueva);
	}

	public Boolean agregarDepartamento(Departamento nuevo) {
		return departamentos.add(nuevo);
	}

	public Boolean darDeAltaPropiedad(Propiedad casita) {
		return propiedades.remove(casita);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public Boolean darDeAlta2Propiedades(Propiedad casita1, Propiedad casita2) {
		Boolean darDeAlta = Boolean.FALSE;
		if (darDeAlta == Boolean.FALSE && !casita1.getLocalidad().equals(casita2.getLocalidad())
				&& casita1.getNumero() != casita2.getNumero()) {
			propiedades.remove(casita1);
			propiedades.remove(casita2);
			darDeAlta = Boolean.TRUE;
			return darDeAlta;
		}
		return darDeAlta;
	}

	public Boolean darDeAlta2Dptos(Propiedad dpto1, Propiedad dpto2) {
		Boolean dadaDeAlta = false;
		if (dpto1 != null && dpto2 != null
				&& !(dpto1.getCalle().equals(dpto2.getCalle()) && dpto1.getLocalidad().equals(dpto2.getLocalidad())
						&& dpto1.getNumero().equals(dpto2.getNumero())
						&& ((Departamento) dpto1).getPiso().equals(((Departamento) dpto2).getPiso())
						&& ((Departamento) dpto1).getDepartamento().equals(((Departamento) dpto2).getDepartamento()))) {
			dpto1 = null;
			dpto2 = null;
			return dadaDeAlta = Boolean.TRUE;
		}
		return dadaDeAlta;
	}

	@Override
	public Double obtenerValorPromedioDeLasCasas() {
		Double precioTotal = 0.0;
		Integer cantidadDeCasas = 0;
		Double promedio = 0.0;
		for (Propiedad casas : this.propiedades) {
			precioTotal += casas.getPrecio();
			cantidadDeCasas++;
		}
		promedio = precioTotal / cantidadDeCasas;
		return promedio;
	}

	@Override
	public Double obtenerValorPromedioDeLosDptos() {
		Double precio = 0.0;
		Integer cantidadDeDptos = 0;
		Double promedio = 0.0;
		for (Propiedad deptos : this.propiedades) {
			if (deptos != null) {
				precio += deptos.getPrecio();
				cantidadDeDptos++;
			}
		}
		promedio = precio / cantidadDeDptos;
		return promedio;
	}

	@Override
	public ArrayList<Propiedad> buscarPropiedadesPorRangoDePrecio(Double precioMinimo, Double precioMaximo)
			throws SinResultadosException {
		ArrayList<Propiedad> casasBuscadas = new ArrayList<Propiedad>();
		for (Propiedad i : this.propiedades) {
			if (i.getPrecio() >= precioMinimo && i.getPrecio() <= precioMaximo) {
				casasBuscadas.add(i);
			}
		}
		if (casasBuscadas.isEmpty()) {
			throw new SinResultadosException("No se encuentra ninguna propiedad");
		}
		return casasBuscadas;
	}

	@Override
	public Boolean agregarPropiedad(Propiedad nueva) {
		return this.propiedades.add(nueva);
	}

	@Override
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

	@Override
	public ArrayList<Propiedad> ordenarPropiedadesPorPrecio(ArrayList<Propiedad> propiedades) {
		Collections.sort(propiedades, new ComparadorDePrecios());
		return propiedades;
	}

	@Override
	public ArrayList<Propiedad> ordenarPropiedadesPorUbicacion(ArrayList<Propiedad> propiedades) {
		Collections.sort(propiedades);
		return propiedades;
	}

	@Override
	public ArrayList<Propiedad> buscarPropiedadesPorUbicacion(String ubicacion) {
		ArrayList<Propiedad> propiedadesBuscadas = new ArrayList<Propiedad>();
		for (Propiedad i : this.propiedades) {
			if (i.getLocalidad().equals(ubicacion)) {
				propiedadesBuscadas.add(i);
			}
		}
		return propiedadesBuscadas;
	}

	// Métodos adicionales de la clase Inmobiliaria...

	public Boolean realizarVentaDePropiedad(Propiedad propiedad, Cliente cliente) {
		Boolean ventaRealizada = false;
		if (propiedad != null && propiedad.acciones.equals(AccionesParaLasPropiedades.VENTA)) {
			propiedad.setPrecio(propiedad.getPrecio() + this.cuenta);
			propiedades.remove(propiedad);

			if (cliente != null && cliente.getBilletera() >= propiedad.getPrecio()) {
				cliente.setBilletera(cliente.getBilletera() - propiedad.getPrecio());
				ventaRealizada = true;
			}
		}
		return ventaRealizada;
	}

	public Boolean realizarAlquilerDePropiedad(Propiedad propiedad, Cliente cliente, Double precioPorDia,
			Integer cantidadDias) {
		Boolean alquilerRealizado = false;
		Double precioTotal = 0.0;
		if (propiedad != null && propiedad.acciones.equals(AccionesParaLasPropiedades.ALQUILER)) {
			precioTotal = precioPorDia * cantidadDias;
			precioTotal += this.cuenta;
			propiedades.remove(propiedad);

			if (cliente != null && cliente.getBilletera() >= precioTotal) {
				cliente.setBilletera(cliente.getBilletera() - precioTotal);
				alquilerRealizado = true;
			}
		}
		return alquilerRealizado;
	}

	public Boolean realizarPermutaDe2Propiedades(Cliente cliente, Cliente cliente2) {
		Boolean permutaRealizada = Boolean.FALSE;
		Double diferenciaDePrecioEnLasPropiedades = 0.0;
		if (cliente.getPropiedad().acciones.equals(AccionesParaLasPropiedades.PERMUTA)
				&& cliente2.getPropiedad().acciones.equals(AccionesParaLasPropiedades.PERMUTA)) {
			Propiedad tempPropiedad = cliente.getPropiedad();
			cliente.setPropiedad(cliente2.getPropiedad());
			cliente2.setPropiedad(tempPropiedad);
			permutaRealizada = Boolean.TRUE;

			double precioPropiedadCliente1 = cliente.getPropiedad().getPrecio();
			double precioPropiedadCliente2 = cliente2.getPropiedad().getPrecio();

			if (precioPropiedadCliente2 > precioPropiedadCliente1) {
				diferenciaDePrecioEnLasPropiedades = precioPropiedadCliente2 - precioPropiedadCliente1;
				cliente.setBilletera(cliente.getBilletera() - diferenciaDePrecioEnLasPropiedades);
				cliente2.setBilletera(cliente2.getBilletera() + diferenciaDePrecioEnLasPropiedades);
			} else if (precioPropiedadCliente1 > precioPropiedadCliente2) {
				diferenciaDePrecioEnLasPropiedades = precioPropiedadCliente1 - precioPropiedadCliente2;
				cliente.setBilletera(cliente.getBilletera() + diferenciaDePrecioEnLasPropiedades);
				cliente2.setBilletera(cliente2.getBilletera() - diferenciaDePrecioEnLasPropiedades);
			}
		}
		return permutaRealizada;
	}

	public ArrayList<Propiedad> queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista()
	        throws UmbralMinimoNoAlcanzadoException {
	    ArrayList<Propiedad> propiedadesParaVenta = new ArrayList<>();
	    for (Propiedad propiedad : propiedades) {
	        if (propiedad.getAcciones().equals(AccionesParaLasPropiedades.VENTA) && propiedad.getPrecio() > 10000.0) {
	            propiedadesParaVenta.add(propiedad);
	        }
	    }
	    
	    if (propiedadesParaVenta.isEmpty()) {
	        throw new UmbralMinimoNoAlcanzadoException("No se encontraron propiedades que cumplan con el umbral mínimo");
	    }

	    return propiedadesParaVenta;
	}


	// Getters y Setters...

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
