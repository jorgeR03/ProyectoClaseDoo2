package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;

public final class IdClienteValidationRule implements ValidatorRule<UUID>{
	

	private static final ValidatorRule<UUID> instancia = new IdClienteValidationRule();
	
	private IdClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(UUID dato) {
		validarIdPorDefecto(dato);
		
	}
	private final void validarIdPorDefecto(final UUID id) {
		if(UtilUUID.valorDefecto(id)) {
			var mensajeUsuario = "El id del cliente es el valor por defecto";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}	

}
