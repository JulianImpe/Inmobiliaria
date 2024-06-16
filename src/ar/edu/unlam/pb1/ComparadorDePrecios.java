package ar.edu.unlam.pb1;

import java.util.Collection;
import java.util.Comparator;

public class ComparadorDePrecios implements Comparator<Propiedad> {

	@Override
	public int compare(Propiedad o1, Propiedad o2) {

		return o1.getPrecio().compareTo(o2.getPrecio());
	}

}
