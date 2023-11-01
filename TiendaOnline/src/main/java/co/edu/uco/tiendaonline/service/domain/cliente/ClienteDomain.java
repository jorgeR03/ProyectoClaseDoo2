package co.edu.uco.tiendaonline.service.domain.cliente;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class ClienteDomain {
	
	private UUID id;
	private TipoIdentificacionDomain tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoDomain correoElectronico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	private ClienteDomain(UUID id, TipoIdentificacionDomain tipoidentificacion, String identificacion,
			NombreCompletoClienteDomain nombreCompleto, CorreoElectronicoDomain correoElectronico,
			NumeroTelefonoMovilClienteDomain numeroTelefonoMovil, Date fechaNacimiento) {
		super();
		this.id = id;
		this.tipoidentificacion = tipoidentificacion;
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
		this.correoElectronico = correoElectronico;
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
