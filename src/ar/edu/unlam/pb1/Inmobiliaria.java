package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.hamcrest.core.IsInstanceOf;

public class Inmobiliaria implements GestionPropiedades {

	private String nombre;
	private final Integer CANTIDAD_DE_PROPIEDADES = 100;
	private ArrayList<Propiedad> propiedades;
	private HashSet<Cliente> clientes;
	private Double cuenta;

	public Inmobiliaria() {
		this.clientes = new HashSet<>();
		this.propiedades = new ArrayList<>();
		this.cuenta = (double) 100000;
		this.nombre = "Julian";
	}

	public Boolean agregarCliente(Cliente nuevo) {
		return this.clientes.add(nuevo);
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
		return ordenarPropiedadesPorPrecio(casasBuscadas);
	}

	@Override
	public Boolean agregarPropiedad(Propiedad nueva) {
		for (Propiedad i : this.propiedades) {
			if (nueva instanceof Casa) {
				if (i.getCalle().equals(nueva.getCalle()) && i.getNumero().equals(nueva.getNumero())
						&& i.getLocalidad().equals(nueva.getLocalidad())) {
					return false;
				}

			}
			// (Calle, número, piso, departamento y localidad)
			if (nueva instanceof Departamento) {
				if (i.getCalle().equals(nueva.getCalle()) && i.getNumero().equals(nueva.getNumero())
						&& i.getLocalidad().equals(nueva.getLocalidad())
						&& ((Departamento) i).getPiso().equals(((Departamento) nueva).getPiso())
						&& ((Departamento) i).getDepartamento().equals(((Departamento) nueva).getDepartamento())) {
					return false;
				}
			}
		}
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
		Collections.sort(propiedades, new ComparadorDeUbicacion());
		return propiedades;
	}

	@Override
	public ArrayList<Propiedad> buscarPropiedadesPorUbicacionYDevolverElResultadoOrdenado(String localidad) {
		ArrayList<Propiedad> propiedadesBuscadas = new ArrayList<Propiedad>();
		for (Propiedad i : this.propiedades) {
			if (i.getLocalidad().equals(localidad)) {
				propiedadesBuscadas.add(i);
			}
		}
		return ordenarPropiedadesPorUbicacion(propiedadesBuscadas);
	}

	// Métodos adicionales de la clase Inmobiliaria...

	public Propiedad buscarPropiedadPorCodigo(Integer codigo) {
		for (Propiedad p : propiedades) {
			if (p.getCodigo().equals(codigo)) {
				return p;
			}
		}
		return null;

	}

	public Boolean realizarVentaDePropiedad(Propiedad propiedad, Cliente cliente) {
		Boolean ventaRealizada = false;
		Propiedad propi = buscarPropiedadPorCodigo(propiedad.getCodigo());
		Cliente c = buscarClientePorId(cliente.getDni());
		if (propi == null || c == null) {
			return false;
		}
		if (propi.getDisponible() == Boolean.TRUE && propi.acciones.equals(AccionesParaLasPropiedades.VENTA)) {
			propi.setPrecio(propi.getPrecio() + this.cuenta);
			propi.setDisponible(Boolean.FALSE);

			if (c.getBilletera() >= propi.getPrecio()) {
				c.setBilletera(c.getBilletera() - propi.getPrecio());
				ventaRealizada = true;
			}
		}
		return ventaRealizada;
	}

	public Boolean realizarAlquilerDePropiedad(Propiedad propiedad, Cliente cliente, Double precioPorDia,
			Integer cantidadDias) {
		Boolean alquilerRealizado = Boolean.FALSE;
		Double precioTotal = 0.0;
		for (Propiedad p : propiedades) {
			if (p.equals(propiedad) && p.getDisponible() == Boolean.TRUE
					&& p.acciones.equals(AccionesParaLasPropiedades.ALQUILER)) {
				precioTotal = precioPorDia * cantidadDias;
				precioTotal += this.cuenta;
				p.setDisponible(Boolean.FALSE);

				if (cliente != null && cliente.getBilletera() >= precioTotal) {
					cliente.setBilletera(cliente.getBilletera() - precioTotal);
					alquilerRealizado = Boolean.TRUE;
				}
			}
		}

		return alquilerRealizado;
	}

	public Cliente buscarClientePorId(Integer dni) {
		for (Cliente c : clientes) {
			if (c.getDni().equals(dni)) {
				return c;
			}
		}
		return null;

	}

	public Boolean realizarPermutaDe2Propiedades(Cliente cliente, Cliente cliente2) {
		Boolean permutaRealizada = Boolean.FALSE;
		Double diferenciaDePrecioEnLasPropiedades = 0.0;
		Cliente c1 = buscarClientePorId(cliente.getDni());
		Cliente c2 = buscarClientePorId(cliente2.getDni());
		if (c1 == null || c2 == null) {
			return false;
		}
		if (c1.getPropiedad().acciones.equals(AccionesParaLasPropiedades.PERMUTA)
				&& c2.getPropiedad().acciones.equals(AccionesParaLasPropiedades.PERMUTA)) {
			Propiedad tempPropiedad = c1.getPropiedad();
			c1.setPropiedad(c2.getPropiedad());
			c2.setPropiedad(tempPropiedad);
			permutaRealizada = Boolean.TRUE;

			Double precioPropiedadCliente1 = c1.getPropiedad().getPrecio();
			Double precioPropiedadCliente2 = c2.getPropiedad().getPrecio();

			if (precioPropiedadCliente2 > precioPropiedadCliente1) {

				diferenciaDePrecioEnLasPropiedades = precioPropiedadCliente2 - precioPropiedadCliente1;
				c1.setBilletera(c1.getBilletera() - diferenciaDePrecioEnLasPropiedades);
				c2.setBilletera(c2.getBilletera() + diferenciaDePrecioEnLasPropiedades);

			} else if (precioPropiedadCliente1 > precioPropiedadCliente2) {

				diferenciaDePrecioEnLasPropiedades = precioPropiedadCliente1 - precioPropiedadCliente2;
				c1.setBilletera(c1.getBilletera() + diferenciaDePrecioEnLasPropiedades);
				c2.setBilletera(c2.getBilletera() - diferenciaDePrecioEnLasPropiedades);
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
			throw new UmbralMinimoNoAlcanzadoException(
					"No se encontraron propiedades que cumplan con el umbral mínimo");
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
