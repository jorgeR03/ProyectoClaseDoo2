package co.edu.uco.tiendaonline.crosscutting.exception;

import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public class TiendaOnlineException extends RuntimeException {

	
	private static final long serialVersionUID = -551425372694998396L;
	private LugarException lugar;
	private Throwable exceptionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean existeExcepcionRaiz;
	
	
	
	
	protected TiendaOnlineException(final LugarException lugar, final Throwable exceptionRaiz,final  String mensajeUsuario,
			final String mensajeTecnico) {
		setLugar(lugar);
		setExceptionRaiz(exceptionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
	}
	
	
	private final void setLugar(LugarException lugar) {
		this.lugar = UtilObjeto.obtenerDefecto(lugar, LugarException.GENERAL);

	}
	
	
	private final void setExceptionRaiz(final Throwable exceptionRaiz) {
		setExisteExcepcionRaiz(!UtilObjeto.esNulo(exceptionRaiz));
		this.exceptionRaiz = UtilObjeto.obtenerDefecto(exceptionRaiz, new Exception());
	}
	
	
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	public final LugarException getLugar() {
		return lugar;
	}
	public final Throwable getExeptionRaiz() {
		return exceptionRaiz;
	}
	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}


	private final void setExisteExcepcionRaiz(boolean existeExcepcionRaiz) {
		this.existeExcepcionRaiz = existeExcepcionRaiz;
	}


	public final Throwable getExceptionRaiz() {
		return exceptionRaiz;
	}


	public final boolean isExisteExcepcionRaiz() {
		return existeExcepcionRaiz;
	}
	
	
	

	
	

}
