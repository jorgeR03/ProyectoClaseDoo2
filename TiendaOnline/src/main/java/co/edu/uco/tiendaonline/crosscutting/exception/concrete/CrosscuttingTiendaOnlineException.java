package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class CrosscuttingTiendaOnlineException extends TiendaOnlineException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CrosscuttingTiendaOnlineException(Throwable exceptionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.CROSSCUTTING ,exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}
	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new CrosscuttingTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
		
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new CrosscuttingTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
		
	}
	
	public static final TiendaOnlineException crear(final Throwable exceptionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new CrosscuttingTiendaOnlineException(exceptionRaiz, mensajeUsuario, mensajeTecnico);
		
	}
	
	
	

}
