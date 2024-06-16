package ar.edu.unlam.pb1;

public class NumeroNegativoException extends Exception {

	 private String mensaje;

	public NumeroNegativoException(String mensaje) {
		this.mensaje = mensaje;
	}
	 
}
