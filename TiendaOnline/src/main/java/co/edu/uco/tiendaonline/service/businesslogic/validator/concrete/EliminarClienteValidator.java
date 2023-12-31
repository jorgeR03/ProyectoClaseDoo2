package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdClienteValidationRule;

public final class EliminarClienteValidator implements Validator<ClienteDomain> {

	private static final Validator<ClienteDomain> instancia = new EliminarClienteValidator();
	
	private  EliminarClienteValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final ClienteDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(ClienteDomain data) {
		ClienteValidationRule.ejecutarValidacion(data);
		IdClienteValidationRule.ejecutarValidacion(data.getId());
	}

}
