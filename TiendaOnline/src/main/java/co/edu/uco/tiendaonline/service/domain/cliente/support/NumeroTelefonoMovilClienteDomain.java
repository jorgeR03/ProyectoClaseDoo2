package co.edu.uco.tiendaonline.service.domain.cliente.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NumeroTelefonoMovilClienteDomain {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoMovilClienteDomain() {
		setNumeroTelefono(UtilTexto.VACIO);
		setNumeroTelefonoConfirmado(false);

	}
	
	private NumeroTelefonoMovilClienteDomain(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoMovilClienteDomain crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoMovilClienteDomain(numeroTelefono, numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoMovilClienteDomain crear() {
		return new NumeroTelefonoMovilClienteDomain();
	}
	public final String getNumeroTelefono() {
		return numeroTelefono;
	}

	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	private final void setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	private final void setNumeroTelefonoConfirmado(final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = numeroTelefonoConfirmado;
	}
}
