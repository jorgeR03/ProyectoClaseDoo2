package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOfactory;

public final class SQLserverDAOFactory extends DAOfactory {

	private Connection conexion;

	public SQLserverDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		// TODO your homework will be to obtain connection with SQL server
		conexion = null;

	}

	@Override
	public final void cerrarConexion() {
		// TODO Your homework will be to close connection

	}

	@Override
	public void iniciarTransaccion() {
		// TODO Auto-generated method stub

	}

	@Override
	public final void confirmarTransaccion() {
		// TODO Your homework will be to init transaction

	}

	@Override
	public final void cancelarTransaccion() {
		// TODO Your homework will be to commit transaction

	}

	@Override
	public ClienteDAO obtenerCLienteDAO() {
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO ObtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionSQLServerDAO(conexion);
	}

}
