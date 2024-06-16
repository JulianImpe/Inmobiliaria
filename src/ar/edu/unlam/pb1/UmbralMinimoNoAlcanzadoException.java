package ar.edu.unlam.pb1;

public class UmbralMinimoNoAlcanzadoException extends Exception {

	private String mensaje;

	public UmbralMinimoNoAlcanzadoException(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
