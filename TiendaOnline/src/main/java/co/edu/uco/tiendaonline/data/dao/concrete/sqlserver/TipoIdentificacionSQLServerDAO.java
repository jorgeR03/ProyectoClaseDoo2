package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoIdentificacionEntity entity) {

		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO TipoIdentificacion(id, codigo, nombre, estado) ");
		sentencia.append("VALUES (?, ?, ?, ?)");
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
		
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3, entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion del nuevo Tipo de Identificacion...";
			var mensajeTecnico = "Se ha presentado problema de tipo SQLEXCEPTION en el metodo de la clase crear TipoIdentificacionSQLServer tratando de llevar a cabo el registro del nuevo Tipo de Identificacion, por favor revise la traza del problema presentado para asi poder identificar que sucedio..."; 
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			
		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion del nuevo Tipo de Identificacion...";
			var mensajeTecnico = "Se ha presentado problema de tipo EXCEPTION en el metodo de la clase crear TipoIdentificacionSQLServer tratando de llevar a cabo el registro del nuevo Tipo de Identificacion, por favor revise la traza del problema presentado para asi poder identificar que sucedio..."; 
			throw DataTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
		
		
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try(final var resultados = sentenciaPreparada.executeQuery()){
				
				if(resultados.next()) {
				   var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"), resultados.getString("nombre"), resultados.getBoolean("estado"));	
				   
				   resultado = Optional.of(tipoIdentificacionEntity);
				}
				
			}catch (final SQLException excepcion) {
				var mensajeUsuario = "Se ha presentado un problema tratando consultar la información del tipo de identificacion por el identificador deseado...";
				var mensajeTecnico = "Se ha presentado un problema de tipo SQLEXCEPTION en el metodo consultar por ID de clase, por favor revise la traza del problema presentado para asi poder identificar que sucedio..."; 
				throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			}
			
		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion; 
			
			
		}catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando consultar la información del tipo de identificacion por el identificador deseado...";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLEXCEPTION tratandod de preparar consultar por ID de clase, por favor revise la traza del problema presentado para asi poder identificar que sucedio..."; 
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
