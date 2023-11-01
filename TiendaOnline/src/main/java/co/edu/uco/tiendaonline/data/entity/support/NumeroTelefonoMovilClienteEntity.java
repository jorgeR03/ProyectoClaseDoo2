package co.edu.uco.tiendaonline.data.entity.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NumeroTelefonoMovilClienteEntity {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoMovilClienteEntity() {
		setNumeroTelefono(UtilTexto.VACIO);
		setNumeroTelefonoConfirmado(false);
	}
	
	private NumeroTelefonoMovilClienteEntity(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoMovilClienteEntity crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoMovilClienteEntity(numeroTelefono, numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoMovilClienteEntity crear() {
		return new NumeroTelefonoMovilClienteEntity();
	}

	public final String getNumeroTelefono() {
		return numeroTelefono;
	}

	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	private final void setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = UtilTexto.obtenerValorDefecto(numeroTelefono);
	}

	private final void setNumeroTelefonoConfirmado(final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = UtilObjeto.obtenerDefecto(numeroTelefonoConfirmado, false);
	}
}
