package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public class UtilSQL {
	
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		
		
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = "No es posible validar"+"si una conexion esta abierta si esta nula..."; 
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		
		try {
			return !UtilObjeto.esNulo(conexion)&& !conexion.isClosed();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000005);;
			throw CrosscuttingTiendaOnlineException.crear(excepcion, null, null);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000006);;
			throw CrosscuttingTiendaOnlineException.crear(excepcion, null, null);
		}
	}
	
	public static final void cerrarConexion (final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = "No es posible cerrar una conexion que esta nula"; 
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try{
		if(!conexionAbierta(conexion)) {
			//lanzar excepcion
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = "No es posible cerrar una conexion que ya fue cerrada"; 
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		conexion.close();
	} catch (final CrosscuttingTiendaOnlineException excepcion) {
		throw excepcion;
	}catch (final SQLException excepcion) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
		var mensajeTecnico = "Se ha presentado un problema tratando de cerrar una conexion SQL";
		throw CrosscuttingTiendaOnlineException.crear(excepcion, mensajeTecnico, mensajeUsuario);
	}catch (final Exception excepcion) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000004);
		var mensajeTecnico = "Se ha presentado un problema inesperado tratando de cerrar una conexion SQL";
			throw CrosscuttingTiendaOnlineException.crear(excepcion, mensajeTecnico, mensajeUsuario);
					
		}
	}
}