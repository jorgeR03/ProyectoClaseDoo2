package co.edu.uco.tiendaonline.service.domain.cliente.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public final class CorreoElectronicoDomain {
	private String correoElectronico;
	private  boolean correoElectronicoConfirmado;
	
	public CorreoElectronicoDomain() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
	}
	
	private CorreoElectronicoDomain(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoDomain crear(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoDomain(correoElectronico, correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoDomain crear() {
		return new CorreoElectronicoDomain();
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}
}
