package ar.edu.unlam.pb1;

public class SinResultadosException extends Exception {

	private String mensaje;

	public SinResultadosException(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
