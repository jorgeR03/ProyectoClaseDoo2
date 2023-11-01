package co.edu.uco.tiendaonline.data.entity.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class CorreoElectronicoEntity {
	private String correoElectronico;
	private  boolean correoElectronicoConfirmado;
	
	
	public CorreoElectronicoEntity() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
	}
	
	private CorreoElectronicoEntity(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		}
	
	public static final CorreoElectronicoEntity crear(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoEntity(correoElectronico, correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoEntity crear() {
		return new CorreoElectronicoEntity();
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = UtilTexto.obtenerValorDefecto(correoElectronico);
	}

	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = UtilObjeto.obtenerDefecto(correoElectronicoConfirmado,false);
	}

}
