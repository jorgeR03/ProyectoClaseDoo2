package co.edu.uco.tiendaonline.service.facade.concrete.tipoIdentificacion;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion.concrete.tipoidentificacion.RegistrarTipoIdentificacionUseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public class RegistrarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO>{

	@Override
	public void execute(TipoIdentificacionDTO dto) {
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertirToDomain(dto);
		RegistrarTipoIdentificacionValidator.ejecutar(domain);
		
		
		final DAOFactory daoFactory =DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQlSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarTipoIdentificacionUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
			
		}catch (final TiendaOnlineException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario ="Se ha presentado un error inesperado tratando de registrar un nuevo tipo de identificacion";
			var mensajeTecnico = "Se ha presentado un error inesperado tratando de registrar un nuevo tipo de identificacion. verigue la trasa completa ";
			throw ServiceTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}
	

}
