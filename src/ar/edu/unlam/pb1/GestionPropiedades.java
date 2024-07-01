package ar.edu.unlam.pb1;

import java.util.ArrayList;

public interface GestionPropiedades {
	Boolean agregarPropiedad(Propiedad nueva);

	Boolean modificarPrecioDeLaPropiedad(Integer codigo, Double precio);

	ArrayList<Propiedad> buscarPropiedadesPorRangoDePrecio(Double precioMinimo, Double precioMaximo)
			throws SinResultadosException;

	ArrayList<Propiedad> ordenarPropiedadesPorPrecio(ArrayList<Propiedad> propiedades);

	ArrayList<Propiedad> ordenarPropiedadesPorUbicacion(ArrayList<Propiedad> propiedades);

	Double obtenerValorPromedioDeLasCasas();

	Double obtenerValorPromedioDeLosDptos();

	ArrayList<Propiedad> buscarPropiedadesPorUbicacionYDevolverElResultadoOrdenado(String ubicacion);

	
}
