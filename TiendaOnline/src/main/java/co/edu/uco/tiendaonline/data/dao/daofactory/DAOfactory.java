package co.edu.uco.tiendaonline.data.dao.daofactory;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.SQLserverDAOFactory;


public abstract class DAOfactory {
	
	public static final DAOfactory obtenerDAOFactory(final TipoDAOFactory factoria) {
		
		switch (factoria) {
		case SQlSERVER: {
			return new SQLserverDAOFactory();
		}
		case POSTGRESQL: {
			throw new RuntimeException ("Factoria no soportada");
		}
		case MYSQL: { 
			throw new RuntimeException("Factoria no soportada");
		}
		case ORACLE: {
			throw new RuntimeException("Factoria no soportada");
		}
	}
		return null;
}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();	
	
	public abstract ClienteDAO obtenerCLienteDAO();
	
	public abstract TipoIdentificacionDAO ObtenerTipoIdentificacionDAO();
	

}
