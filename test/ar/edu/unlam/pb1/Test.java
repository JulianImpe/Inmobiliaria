package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import junit.framework.Assert;

public class Test {
	// Preparacion de datos
	Inmobiliaria actual = new Inmobiliaria();

	String calle = "RamonFalcon";
	Integer numero = 144;
	String localidad = "SanJusturro";
	String calle2 = "Arieta";
	Integer numero2 = 584;
	String localidad2 = "Moron";
	Integer piso = 2;
	String dpto = "A";
	Integer piso2 = 3;
	String dpto2 = "B";
	Double precio = 100.000;
	Double precio2 = 200.000;
	Casa casa1 = new Casa(calle, numero, localidad, precio);
	Casa casa2 = new Casa(calle2, numero2, localidad2, precio2);
	Casa casaCopiaDeLa1 = new Casa(calle, numero, localidad, precio);
	Departamento dpto1 = new Departamento(calle, numero, piso, dpto, localidad, precio);
	Departamento dpto3 = new Departamento(calle2, numero2, piso2, dpto2, localidad2, precio2);
	Departamento copiaDpto1 = new Departamento(calle, numero, piso, dpto, localidad, precio);

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
		;
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
		Casa[] casitas = actual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);
		assertNotNull(casitas);
		//La cantidad de casas que espero / La cantidad de casas que puede haber.
		assertEquals(2, casitas.length);
	}
	@org.junit.Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados() {
		// Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		Double precioMinimo = 80.000;
		Double precioMaximo = 90.000;
		Casa[] casitas = actual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);
		assertNull(casitas);
		//La cantidad de casas que espero / La cantidad de casas que puede haber.
		//assertEquals(0, casitas.length);
		
		//no puedo abrir el microfono :(
	}
}