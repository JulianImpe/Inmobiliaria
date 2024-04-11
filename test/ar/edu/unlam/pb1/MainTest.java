package ar.edu.unlam.pb1;

import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
	private static final int SALIR = 99;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;
		
		Inmobiliaria inmobiliaria = new Inmobiliaria();

		do {

			mostrarPorPantalla("\n\n##############\nInmobiliaria " + inmobiliaria.getNombre());
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");

			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {

			case AGREGAR_PROPIEDADES:
				if (inmobiliaria.agregarPropiedad(agregarPropiedad())) {
					mostrarPorPantalla("Propiedad agregada exitosamente");
				} else {
					mostrarPorPantalla("No se pudo agregar la propiedad");
				}

				break;
			case MODIFICAR_PROPIEDADES:
				Integer codigo = ingresarNumeroEntero("Ingrese el codigo de la propiedad que desea modificar: ");
				Double precio = ingresarDouble("Ingrese el precio a modificar: ");
				if (inmobiliaria.modificarPrecioDeLaPropiedad(codigo, precio)) {
					mostrarPorPantalla("Precio modificado exitosamente");
				} else {
					mostrarPorPantalla("No se pudo modificar el precio");
				}
				break;
			case AGREGAR_CLIENTE:
				if (inmobiliaria.agregarCliente(agregarCliente())) {
					mostrarPorPantalla("Cliente agregado exitosamente");
				} else {
					mostrarPorPantalla("No se pudo agregar el cliente");
				}

				break;
			case OBTENER_PROPIEDADES_ORDENADAS_POR_PRECIO:
				mostrarPorPantalla(Arrays.toString(inmobiliaria.ordenarPropiedadesPorPrecio(inmobiliaria.getPropiedades())));
				break;
			case OBTENER_PROPIEDADES_ORDENADAS_POR_UBICACION:
				mostrarPorPantalla(Arrays.toString(inmobiliaria.ordenarPropiedadesPorUbicacion(inmobiliaria.getPropiedades()))); 
				
				break;
			case BUSCAR_PROPIEDADES_POR_PRECIO:
				Double precioB = ingresarDouble("Ingrese el precio de la propiedad que busca: ");
				if (inmobiliaria.buscarPropiedadPorPrecio(precioB) != null) {
					mostrarPorPantalla("Propiedad encontrada exitosamente");
					mostrarPorPantalla(inmobiliaria.buscarPropiedadPorPrecio(precioB).toString());
				} else {
					mostrarPorPantalla("No se encontro la propiedad");
				}
				break;
			case BUSCAR_PROPIEDADES_POR_UBICACION:
				String ubicacion = ingresarString("Ingrese la ciudad donde se ubica la propiedad: ");
				if (inmobiliaria.buscarPropiedadPorUbicacion(ubicacion) != null) {
					mostrarPorPantalla("Propiedad encontrada exitosamente");
					mostrarPorPantalla(inmobiliaria.buscarPropiedadPorUbicacion(ubicacion).toString());
				} else {
					mostrarPorPantalla("No se encontro la propiedad");
				}

				break;
			case REALIZAR_VENTA:
				String ubicacionV = ingresarString("Ingrese la ciudad donde se ubica la propiedad para vender: ");
				Double precioVenta = ingresarDouble("Ingrese el precio al que desea vender la propiedad: ");
				if (inmobiliaria.realizarVentaDePropiedad(ubicacionV, precioVenta)) {
					mostrarPorPantalla("Propiedad vendida exitosamente");
				} else {
					mostrarPorPantalla("No se pudo vender la propiedad");
				}

				break;
			case REALIZAR_ALQUILER:
				String ubicacionA = ingresarString("Ingrese la ciudad donde se ubica la propiedad para vender: ");
				Double precioA = ingresarDouble("Ingrese el precio al que desea alquilar la propiedad: ");
				Integer cantidadDeDias = ingresarNumeroEntero(
						"Ingrese la cantidad de dias que desea alquilar la propiedad: ");
				if (inmobiliaria.realizarAlquilerDePropiedad(ubicacionA, precioA, cantidadDeDias)) {
					mostrarPorPantalla("Propiedad alquilada exitosamente");
				} else {
					mostrarPorPantalla("No se pudo alquilar la propiedad");
				}

				break;
			case SALIR:

				break;

			default:
				break;
			}
		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla(
				"\n\n1) AGREGAR_PROPIEDADES\n2) MODIFICAR_PROPIEDADES\n3)AGREGAR_CLIENTE\n4) OBTENER_PROPIEDADES_ORDENADAS_POR_PRECIO"
						+ "\n5) OBTENER_PROPIEDADES_ORDENADAS_POR_UBICACION\n6) BUSCAR_PROPIEDADES_POR_PRECIO\n7)BUSCAR_PROPIEDADES_POR_UBICACION\n8)REALIZAR_VENTA\n9)REALIZAR_ALQUILER\n99) Salir");
	}

	private static Cliente agregarCliente() {
//		private Integer Dni;
//		private String nombre;
//		private Double billetera;
		Integer dni = ingresarNumeroEntero("Ingrese su DNI: ");
		String nombre = ingresarString("Ingrese su nombre: ");
		Cliente cliente = new Cliente(dni, nombre);
		return cliente;

	}

	private static Propiedad agregarPropiedad() {

		String ubicacion = ingresarString("Ingrese la ciudad donde se ubica la propiedad: ");
		Double precio = ingresarDouble("Ingrese el precio de la propiedad");
		TiposDePropiedades tipos = ingresarTipoDePropiedad("Ingrese el tipo de propiedad que desea: ");
		Integer precioAlquilerXDia = ingresarNumeroEntero("Ingrese el precio del alquiler por dia: ");
		Integer codigo = ingresarNumeroEntero("Ingrese el codigo de la propiedad: ");
		Propiedad propiedad = new Propiedad(ubicacion, precio, tipos, precioAlquilerXDia, codigo);
		return propiedad;

	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		if (numeroIngresado == 99) {
			return MenuPrincipal.SALIR;
		}
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static TiposDePropiedades ingresarTipoDePropiedad(String mensaje) {
		mostrarPorPantalla("1-CASA, 2-DEPARTAMENTO, 3-PH, 4-TERRENO, 5-CAMPO");
		String tipo = ingresarString(mensaje);
		
		
		return TiposDePropiedades.valueOf(tipo.toUpperCase());
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.next();
	}

	private static double ingresarDouble(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.nextDouble();
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
