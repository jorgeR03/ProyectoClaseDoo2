package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.nombreCompletoClienteEntity;

public class ClienteEntity {
	
	private UUID id;
	private TipoIdentificacionEntity tipoidentificacion;
	private String identificacion;
	private nombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	public ClienteEntity(UUID id, TipoIdentificacionEntity tipoidentificacion, String identificacion,
			nombreCompletoClienteEntity nombreCompleto, CorreoElectronicoEntity correoElectronico,
			NumeroTelefonoMovilClienteEntity numeroTelefonoMovil, Date fechaNacimiento) {
		setId (id);
		setTipoidentificacion (new TipoIdentificacionEntity());
		setIdentificacion (UtilTexto.VACIO);
		setNombreCompleto (new nombreCompletoClienteEntity());
		setCorreoElectronico (new CorreoElectronicoEntity());
		setNumeroTelefonoMovil (new NumeroTelefonoMovilClienteEntity());
		setFechaNacimiento (fechaNacimiento);
	}
	
	
	public ClienteEntity() {
		setId (id);
		setTipoidentificacion (tipoidentificacion);
		setIdentificacion (identificacion);
		setNombreCompleto (nombreCompleto);
		setCorreoElectronico (correoElectronico);
		setNumeroTelefonoMovil (numeroTelefonoMovil);
		setFechaNacimiento (fechaNacimiento);
	}
	
	
	
	public final UUID getId() {
		return id;
	}
	public final void setId(UUID id) {
		this.id = id;
	}
	public final TipoIdentificacionEntity getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final void setTipoidentificacion(TipoIdentificacionEntity tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public final nombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}
	public final void setNombreCompleto(nombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public final CorreoElectronicoEntity getCorreoElectronico() {
		return correoElectronico;
	}
	public final void setCorreoElectronico(CorreoElectronicoEntity correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public final NumeroTelefonoMovilClienteEntity getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final void setNumeroTelefonoMovil(NumeroTelefonoMovilClienteEntity numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	

}
