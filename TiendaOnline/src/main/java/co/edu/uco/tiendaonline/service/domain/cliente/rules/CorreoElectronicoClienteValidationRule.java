package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoDomain;

public final class CorreoElectronicoClienteValidationRule implements ValidatorRule<CorreoElectronicoDomain> {
	
	private static final ValidatorRule<CorreoElectronicoDomain> instancia = new CorreoElectronicoClienteValidationRule();
	
	private   CorreoElectronicoClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CorreoElectronicoDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final CorreoElectronicoDomain dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarLongitud(final CorreoElectronicoDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getCorreoElectronico(), 40)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000046);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final CorreoElectronicoDomain dato) {
		if(UtilTexto.estaVacio(dato.getCorreoElectronico())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000047);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final CorreoElectronicoDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosArrobaDominio(dato.getCorreoElectronico())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000048);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

}
