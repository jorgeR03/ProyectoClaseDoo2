package co.edu.uco.tiendaonline.crosscutting.messages;

import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public final class Mensaje {
	
	private CodigoMensaje codigo;
	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String contenido;
	
	
	private Mensaje(final CodigoMensaje codigo,final TipoMensaje tipo,final CategoriaMensaje categoria,final String contenido) {
		setCategoria(categoria);
		setCodigo(codigo);
		setContenido(contenido);
		setTipo(tipo);

	}
	
	public static final Mensaje crear (final CodigoMensaje codigo,final TipoMensaje tipo,final CategoriaMensaje categoria,final String contenido) {
		return new Mensaje(codigo, tipo, categoria, contenido);
	}


	private final void setCodigo(final CodigoMensaje codigo) {
		this.codigo = UtilObjeto.obtenerDefecto(null, null);
	}


	private final void setTipo(TipoMensaje tipo) {
		this.tipo = UtilObjeto.obtenerDefecto(tipo, TipoMensaje.USUARIO);
	}


	private final void setCategoria(CategoriaMensaje categoria) {
		this.categoria = UtilObjeto.obtenerDefecto(categoria, CategoriaMensaje.FATAL);
	}


	private final void setContenido(String contenido) {
		this.contenido=UtilTexto.aplicarTrim(contenido);
	}


	public final CodigoMensaje getCodigo() {
		return codigo;
	}


	public final TipoMensaje getTipo() {
		return tipo;
	}


	public final CategoriaMensaje getCategoria() {
		return categoria;
	}


	public final String getContenido() {
		return contenido;
	}
	
	
	
	
	
	

}
