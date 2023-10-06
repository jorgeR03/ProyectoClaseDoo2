package co.edu.uco.tiendaonline.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "no se recibio el mensaje" + "codigo del mensaje que se queria crear. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "no existe un mensaje con el codigo indicado" + "No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "no es posible obtener un mensaje con un codigo vacio o nulo" + "No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema inesperado intentando realizar la operacion deseada" + "Si el problema persiste contactarse con el administrador"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000005, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "Se ha presentado un problema tratando de validar si la" + "conexion SQL estaba abierta, se presento una excepcion de" +"tipo SQLException"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000006, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "Se presento un problema tratando de validar si la conexion SQL estaba abierta" + "por favor verifica la traza para asi poder diagnosticar con mayor certeza que sucedio"));


	}
	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M000000001);
			throw CrosscuttingTiendaOnlineException.crear(mensajeTecnico,mensajeUsuario);
		}
		
		if(!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M000000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M000000001);
			throw CrosscuttingTiendaOnlineException.crear(mensajeTecnico,mensajeUsuario);
	}
		return MENSAJES.get(codigo);
	

	}
	
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	
	}
}