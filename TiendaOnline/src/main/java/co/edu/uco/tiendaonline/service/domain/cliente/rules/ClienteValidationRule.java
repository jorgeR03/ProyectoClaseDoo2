package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;


public final class ClienteValidationRule implements ValidatorRule<ClienteDomain> {
	
	private static final ValidatorRule<ClienteDomain> instancia = new ClienteValidationRule();
	
	private  ClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final ClienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000043);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

}
