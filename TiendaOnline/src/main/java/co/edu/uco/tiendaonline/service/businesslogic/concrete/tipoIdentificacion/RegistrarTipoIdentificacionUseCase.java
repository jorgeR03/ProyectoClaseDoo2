package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoIdentificacion;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.w3c.dom.Entity;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class RegistrarTipoIdentificacionUseCase implements UseCase <TipoIdentificacionDomain>{

	private DAOFactory factoria;
		
	
	public RegistrarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public final void execute(final TipoIdentificacionDomain domain) {
		// 1. Validar integridad de datos (Tipo de dato, longitud, obligatoriedad, formato, rango)
		// TODO: como lo hago 
		// 2. No debe existir otro tipo de identificacion con el mismo identificador 
		obtenerIdentificadorTipoIdentificacion(domain);
		// 3. No debe existir otro tipp de identificacion con el mismo codigo
		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getCodigo());
		
		// 4. No debe existir otro tipp de identificacion con el mismo nombre
		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		// 5. Registrar el nuevo tipo de identificacion
		registrarNuevoTipoIdentificacion(domain);
	}
	
	private void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoNombre(final String nombre) {
				var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
				var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
				var resultados = getTipoIdentificacionDAO().consultar(entity);
				
				
				if(!resultados.isEmpty()) {
					var mensajeUsuario = "ya existe un tipo de identificacion con el codigo" + codigo;
					throw ServiceTiendaOnlineException.crear(mensajeUsuario);
				}
		
	}
	
	private final TipoIdentificacionDomain obtenerIdentificadorTipoIdentificacion(TipoIdentificacionDomain domain) {
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		do {
			var uuid = UUID.randomUUID;
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(), domain.getNombre(), domain.isEstado());
	}
	
	
    private final DAOFactory getFactoria() {
		return factoria;
	}





	private final void setFactoria(final DAOFactory factoria) {
		
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cano el registro de la informacion del nuevo tipo de identificacion...";
			var mensajeTecnico = "Se ha presentado un problema en el metodo setFactorial de la case RegistrarUsuario";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);

		}
		
		this.factoria = factoria;
	}





	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().ObtenerTipoIdentificacionDAO();
	}
	
	

}
