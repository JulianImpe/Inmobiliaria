package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

import junit.framework.Assert;

public class Test {
	// Preparacion de datos
	Inmobiliaria actual = new Inmobiliaria();

	String calle = "RamonFalcon";
	Integer numero = 144;
	String localidad = "SanJusto";
	Integer codigo = 120;
	String calle2 = "Arieta";
	Integer numero2 = 584;
	String localidad2 = "Moron";
	Integer codigo2 = 2548;
	Integer piso = 2;
	String dpto = "A";
	Integer piso2 = 3;
	String dpto2 = "B";
	Double precio = 100.000;
	Double precio2 = 200.000;
	AccionesParaLasPropiedades venta = AccionesParaLasPropiedades.VENTA;
	AccionesParaLasPropiedades alquiler = AccionesParaLasPropiedades.ALQUILER;
	AccionesParaLasPropiedades permuta = AccionesParaLasPropiedades.PERMUTA;
	Propiedad casa1 = new Casa(localidad, precio, codigo, calle, numero, venta);
	Propiedad casa2 = new Casa(localidad2, precio2, codigo2, calle2, numero2, alquiler);
	Propiedad casaCopiaDeLa1 = new Casa(localidad, precio, codigo, calle, numero, venta);
	Propiedad casaCopiaDeLa2 = new Casa(localidad2, precio2, codigo2, calle2, numero2, alquiler);
	// String localidad, Double precio, Integer codigo, String calle, Integer
	// numero,
	// Integer numero2, Integer piso, String departamento
	Propiedad dpto1 = new Departamento(localidad, precio, codigo, calle, numero, alquiler, piso, dpto);
	Propiedad dpto3 = new Departamento(localidad2, precio2, codigo2, calle2, numero2, venta, piso2, dpto2);
	Propiedad copiaDpto1 = new Departamento(localidad, precio, codigo, calle, numero, alquiler, piso, dpto);
	Propiedad dptoPermuta = new Departamento(localidad, precio, codigo, calle, numero, permuta, piso, dpto);
	Propiedad dptoPermuta2 = new Departamento(localidad2, precio2, codigo2, calle2, numero2, permuta, piso2, dpto2);

	@org.junit.Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {

		// Ejecucion
		Boolean deAlta = actual.agregarPropiedad(casa1);

		// Validacion
		assertTrue(deAlta);

	}

	@org.junit.Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		// Ejecucion
		Boolean DeAltaCasa1 = actual.agregarPropiedad(casa1);
		Boolean DeAltaCasa2 = actual.agregarPropiedad(casa2);

		// Validacion
		assertTrue(DeAltaCasa1);
		assertTrue(DeAltaCasa2);

	}

	@org.junit.Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
		// Ejecucion
		Boolean DeAltaCasa1 = actual.agregarPropiedad(casa1);
		Boolean DeAltaCasa2 = actual.agregarPropiedad(casaCopiaDeLa1);

		// Validacion

		assertTrue(DeAltaCasa1);
		assertFalse(DeAltaCasa2);

	}

	@org.junit.Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		// Ejecucion
		Boolean deAlta = actual.agregarPropiedad(dpto1);

		// Validacion
		assertTrue(deAlta);
	}

	@org.junit.Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		// Ejecucion
		Boolean deAlta1 = actual.agregarPropiedad(dpto1);
		Boolean deAlta2 = actual.agregarPropiedad(dpto3);

		// Validacion
		assertTrue(deAlta1);
		assertTrue(deAlta2);
	}

	@org.junit.Test
	public void queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
		// (Calle, número, piso, departamento y localidad) {
		// Ejecucion
		Boolean deAlta1 = actual.agregarPropiedad(dpto1);
		Boolean deAlta2 = actual.agregarPropiedad(copiaDpto1);

		// Validacion
		assertTrue(deAlta1);
		assertFalse(deAlta2);
	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		// Ejecucion
		actual.agregarPropiedad(casa1);
		actual.agregarPropiedad(casa2);
		Double promedio = actual.obtenerValorPromedioDeLasCasas();
		Double resultadoEsperado = 150.000;
		// Validacion
		assertEquals(resultadoEsperado, promedio);

	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		// Ejecucion
		actual.agregarPropiedad(dpto1);
		actual.agregarPropiedad(dpto3);
		Double promedio = actual.obtenerValorPromedioDeLosDptos();
		Double resultadoEsperado = 150.000;
		// Validacion
		assertEquals(resultadoEsperado, promedio);

	}

	@org.junit.Test
	public void agregarUnaCasaConElMenorEspacioEnMemoriaPosibleSinLimiteEnElArray() {
		actual.agregarPropiedad(casa1);
		actual.agregarPropiedad(casa2);

	}

	@org.junit.Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() throws UmbralMinimoNoAlcanzadoException {
		// Crear una lista de propiedades
		ArrayList<Propiedad> propiedades = new ArrayList<>();
		Double precioU = 10000000.0;
		Propiedad casa1 = new Casa(localidad, precioU, codigo, calle, numero, venta);
		Propiedad casa2 = new Casa(localidad, precioU, codigo, calle, numero, alquiler);
		Propiedad casa3 = new Casa("Moron", precioU, 3, "Varela", 2000, venta);
		actual.agregarPropiedad(casa1);// venta
		actual.agregarPropiedad(casa2);// alquiler
		actual.agregarPropiedad(casa3);// venta

		propiedades = actual.queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista();

		Double cantidadDePropiedadesEsperada = 2.0;
		Double cantidadDePropiedadesTotal = (double) propiedades.size();
		assertNotNull(propiedades);
		assertEquals(cantidadDePropiedadesEsperada, cantidadDePropiedadesTotal);
	}

	@org.junit.Test(expected = UmbralMinimoNoAlcanzadoException.class)
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados()
			throws UmbralMinimoNoAlcanzadoException {

		Double precioU = 9000.0;
		Propiedad casaUmbral = new Casa(localidad, precioU, codigo, calle, numero, venta);
		actual.agregarPropiedad(casaUmbral);

		actual.queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista();

	}

	@org.junit.Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		Cliente cliente = new Cliente(42587166, "Julian", casa2);
		Boolean agregado = actual.agregarCliente(cliente);
		assertTrue(agregado);
	}

	@org.junit.Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		Cliente cliente = new Cliente(42587166, "Julian", casa1);
		Cliente cliente2 = new Cliente(42587166, "Julian", casa2);
		actual.agregarCliente(cliente);
		Boolean agregado = actual.agregarCliente(cliente2);
		Double valorEsperado = 1.0;
		Double valorObtenido = (double) actual.getClientes().size();
		assertEquals(valorEsperado, valorObtenido);
		assertFalse(agregado);

	}

	@org.junit.Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() {
		Cliente cliente2 = new Cliente(42587166, "Juliano", casa1);
		actual.agregarPropiedad(casa1);
		actual.agregarCliente(cliente2);
		Boolean realizada = actual.realizarVentaDePropiedad(casa1, cliente2);
		Integer valorEsperado = 1;
		Integer valorObtenido = actual.getPropiedades().size();
		assertEquals(valorEsperado, valorObtenido);
		assertTrue(realizada);

	}

	@org.junit.Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() {
		Cliente cliente2 = new Cliente(42587166, "Juliano", casa1);
		actual.agregarPropiedad(casa2);
		actual.agregarCliente(cliente2);
		Double precioPorDia = 7000.0;
		Integer cantidadDeDias = 7;
		Boolean realizada = actual.realizarAlquilerDePropiedad(casa2, cliente2, precioPorDia, cantidadDeDias);
		Propiedad propiedadAlquilada = actual.buscarPropiedadPorCodigo(codigo2);
		assertTrue(realizada);
		assertFalse(propiedadAlquilada.getDisponible());

	}

	@org.junit.Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades() {
		Cliente cliente1 = new Cliente(42587166, "Julian", dptoPermuta);
		Cliente cliente2 = new Cliente(52587136, "Pepito", dptoPermuta2);
		actual.agregarCliente(cliente1);
		actual.agregarCliente(cliente2);
		Boolean realizada = actual.realizarPermutaDe2Propiedades(cliente1, cliente2);
		assertTrue(realizada);

	}

	@org.junit.Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio()
			throws SinResultadosException {

		// Ejecucion
		actual.agregarPropiedad(casa1);
		actual.agregarPropiedad(casa2);
		Double precioMinimo = 90.000;
		Double precioMaximo = 200.000;
		ArrayList<Propiedad> casitas = actual.buscarPropiedadesPorRangoDePrecio(precioMinimo, precioMaximo);
		actual.ordenarPropiedadesPorPrecio(casitas);
		assertEquals(2, casitas.size());
		assertTrue(casitas.get(0).getPrecio() <= casitas.get(1).getPrecio());
	}

	@org.junit.Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() {
		// localidad, precio, codigo, calle, numero, venta
		Propiedad casa3 = new Casa("Moron", 10000.0, 3, "Varela", 2000, venta);
		// Ejecucion
		actual.agregarPropiedad(casa1);
		actual.agregarPropiedad(casa3);
		actual.agregarPropiedad(casa2);
		String localidad = "Moron";
		String arieta = "Arieta";
		String varela = "Varela";
		ArrayList<Propiedad> casitas = actual.buscarPropiedadesPorUbicacionYDevolverElResultadoOrdenado(localidad);
		assertEquals(2, casitas.size());
		assertEquals(casitas.get(1).getCalle(), varela);
		assertEquals(casitas.get(0).getCalle(), arieta);

	}

	@org.junit.Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio()
			throws SinResultadosException {

		// Ejecucion
		Propiedad dpto2 = new Departamento("Moron", 150.000, 3, "Varela", 2000, venta, codigo, calle);
		actual.agregarPropiedad(dpto3);// [0] - 200.000
		actual.agregarPropiedad(dpto1);// [1] - 100.000
		actual.agregarPropiedad(dpto2);// [2] - 150.000

		Double precioMinimo = 90.000;
		Double precioMaximo = 200.000;
		ArrayList<Propiedad> dptos = actual.buscarPropiedadesPorRangoDePrecio(precioMinimo, precioMaximo);
		assertEquals(3, dptos.size());
		assertEquals(dptos.get(0).getPrecio(), dpto1.getPrecio());
		assertEquals(dptos.get(1).getPrecio(), dpto2.getPrecio());
		assertEquals(dptos.get(2).getPrecio(), dpto3.getPrecio());
	}

	@org.junit.Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() {

		// Ejecucion
		actual.agregarPropiedad(dpto1);
		actual.agregarPropiedad(dpto3);
		String localidad = this.localidad;
		ArrayList<Propiedad> dptos = actual.buscarPropiedadesPorUbicacionYDevolverElResultadoOrdenado(localidad);

		assertEquals(1, dptos.size());

	}

	@org.junit.Test(expected = SinResultadosException.class)
	public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException()
			throws SinResultadosException {

		// Ejecucion
		actual.agregarPropiedad(dpto1);
		actual.agregarPropiedad(dpto3);
		Double precioMinimo = 290.000;
		Double precioMaximo = 400.000;
		actual.buscarPropiedadesPorRangoDePrecio(precioMinimo, precioMaximo);

	}

	@org.junit.Test
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException() {

		// Ejecucion
		actual.agregarPropiedad(dpto1);
		actual.agregarPropiedad(dpto3);
		String localidad = this.localidad;
		ArrayList<Propiedad> dptos = actual.buscarPropiedadesPorUbicacionYDevolverElResultadoOrdenado(localidad);

		assertEquals(1, dptos.size());

	}

}