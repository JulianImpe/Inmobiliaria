package ar.edu.unlam.pb1;

public class CasaInexistenteException extends Exception {

	private String mensaje;

	public CasaInexistenteException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
