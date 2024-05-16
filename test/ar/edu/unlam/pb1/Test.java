package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import junit.framework.Assert;

public class Test {
	// Preparacion de datos
	Inmobiliaria actual = new Inmobiliaria();

	String calle = "RamonFalcon";
	Integer numero = 144;
	String localidad = "SanJusturro";
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
	Casa casa1 = new Casa(localidad, precio, codigo, calle, numero, venta);
	Casa casa2 = new Casa(localidad2, precio2, codigo2, calle2, numero2, alquiler);
	Casa casaCopiaDeLa1 = new Casa(localidad, precio, codigo, calle, numero, venta);
	// String localidad, Double precio, Integer codigo, String calle, Integer
	// numero,
	// Integer numero2, Integer piso, String departamento
	Departamento dpto1 = new Departamento(localidad, precio, codigo, calle, numero, alquiler, piso, dpto);
	Departamento dpto3 = new Departamento(localidad2, precio2, codigo2, calle2, numero2, venta, piso2, dpto2);
	Departamento copiaDpto1 = new Departamento(localidad, precio, codigo, calle, numero, alquiler, piso, dpto);

	@org.junit.Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {

		// Ejecucion
		actual.agregarCasa(casa1);
		Boolean deAlta = actual.darDeAltaLaCasa(casa1);
		// Validacion
		assertTrue(deAlta);

	}

	@org.junit.Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		// Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		Boolean deAlta = actual.darDeAlta2Casas(casa2, casa1);

		// Validacion
		assertTrue(deAlta);

	}

	@org.junit.Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
		// Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casaCopiaDeLa1);
		Boolean deAlta = actual.darDeAlta2Casas(casaCopiaDeLa1, casa1);

		// Validacion

		assertFalse(deAlta);

	}

	@org.junit.Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		// Ejecucion
		actual.agregarDepartamento(dpto1);
		Boolean deAlta = actual.darDeAltaElDepartamento(dpto1);
		// Validacion
		assertTrue(deAlta);
	}

	@org.junit.Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		// Ejecucion
		actual.agregarDepartamento(dpto1);
		actual.agregarDepartamento(dpto3);
		Boolean deAlta = actual.darDeAlta2Dptos(dpto1, dpto3);
		// Validacion
		assertTrue(deAlta);
	}

	@org.junit.Test
	public void queNoSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		// Ejecucion
		actual.agregarDepartamento(dpto1);
		actual.agregarDepartamento(copiaDpto1);
		Boolean deAlta = actual.darDeAlta2Dptos(dpto1, copiaDpto1);
		// Validacion
		assertFalse(deAlta);
	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		// Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		Double promedio = actual.obtenerValorPromedioDeLasCasas();
		Double resultadoEsperado = 150.000;
		// Validacion
		assertEquals(resultadoEsperado, promedio);

	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		// Ejecucion
		actual.agregarDepartamento(dpto1);
		actual.agregarDepartamento(dpto3);
		Double promedio = actual.obtenerValorPromedioDeLosDptos();
		Double resultadoEsperado = 150.000;
		// Validacion
		assertEquals(resultadoEsperado, promedio);

	}

	@org.junit.Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNoNuloSiAplicanResultados() {
		// Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		Double precioMinimo = 80.000;
		Double precioMaximo = 200.000;
		ArrayList<Casa> casitas = actual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);
		assertNotNull(casitas);
		// La cantidad de casas que espero / La cantidad de casas que puede haber.
		assertEquals(2, casitas.size());
	}

	@org.junit.Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados() {
		// Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		Double precioMinimo = 60.000;
		Double precioMaximo = 90.000;
		ArrayList<Casa> casitas = actual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);

		assertEquals(0, casitas.size());
		// La cantidad de casas que espero / La cantidad de casas que puede haber.
		// assertEquals(0, casitas.length);

	}

	@org.junit.Test
	public void agregarUnaCasaConElMenorEspacioEnMemoriaPosibleSinLimiteEnElArray() {
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);

//	assertEquals(2, actual.getCasas().length);
	}

	@org.junit.Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
		// Crear una lista de propiedades
		ArrayList<Propiedad> propiedades = new ArrayList<>();

		actual.agregarPropiedad(casa1);// venta
		actual.agregarPropiedad(casa2);// alquiler
		actual.agregarPropiedad(casaCopiaDeLa1);// venta

		propiedades = actual.queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista();

		Double cantidadDePropiedadesEsperada = 2.0;
		Double cantidadDePropiedadesTotal = (double) propiedades.size();
		assertNotNull(propiedades);
		assertEquals(cantidadDePropiedadesEsperada, cantidadDePropiedadesTotal);
	}

	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados() {
		ArrayList<Propiedad> propiedades = new ArrayList<>();

		actual.agregarPropiedad(casa2);

		propiedades = actual.queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista();

		assertNull(propiedades);

	}

}