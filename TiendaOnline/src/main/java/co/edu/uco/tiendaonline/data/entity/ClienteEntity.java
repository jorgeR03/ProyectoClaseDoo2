package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilDate;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoEntity;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public class ClienteEntity {
	
	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroTelefono;
	private Date fechaNacimiento;


	private ClienteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompleto,
			CorreoElectronicoEntity correoElectronico, NumeroTelefonoMovilClienteEntity numeroTelefono, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefono(numeroTelefono);
		setFechaNacimiento(fechaNacimiento);
	}

	public static final ClienteEntity crear(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompleto,
			CorreoElectronicoEntity correoElectronico, NumeroTelefonoMovilClienteEntity numeroTelefono,final Date fecha) {
		return new ClienteEntity(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefono,fecha);
	}
	
	private final void setId(UUID id) {
		this.id = id;
	}
	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	private final void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
	}
	
	private final void setNombreCompleto(final NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = UtilObjeto.obtenerDefecto(nombreCompleto, new NombreCompletoClienteEntity());
	}
	
	private final void setCorreoElectronico(final CorreoElectronicoEntity correoElectronico) {
		this.correoElectronico = UtilObjeto.obtenerDefecto(correoElectronico, new CorreoElectronicoEntity());
	}
	
	private final void setNumeroTelefono(final NumeroTelefonoMovilClienteEntity numeroTelefono) {
		this.numeroTelefono = UtilObjeto.obtenerDefecto(numeroTelefono, new NumeroTelefonoMovilClienteEntity());
	}
	
	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = UtilObjeto.obtenerDefecto(fechaNacimiento, UtilDate.crearFechaPorDefecto());
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	
	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}
	
	public final CorreoElectronicoEntity getCorreoElectronico() {
		return correoElectronico;
	}
	
	public final NumeroTelefonoMovilClienteEntity getNumeroTelefono() {
		return numeroTelefono;
	}
	
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
		
	

}
