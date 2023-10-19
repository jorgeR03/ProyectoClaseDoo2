package co.edu.uco.tiendaonline.service.domain;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class ClienteDomain {
	
	private UUID id;
	private TipoIdentificacionDomain tipoidentificacion;
	private String identificacion;
	private nombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoDomain correoElectronico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	public ClienteDomain(UUID id, TipoIdentificacionDomain tipoidentificacion, String identificacion,
			nombreCompletoClienteDomain nombreCompleto, CorreoElectronicoDomain correoElectronico,
			NumeroTelefonoMovilClienteDomain numeroTelefonoMovil, Date fechaNacimiento) {
		setId (id);
		setTipoidentificacion (new TipoIdentificacionDomain());
		setIdentificacion (UtilTexto.VACIO);
		setNombreCompleto (new nombreCompletoClienteDomain());
		setCorreoElectronico (new CorreoElectronicoDomain());
		setNumeroTelefonoMovil (new NumeroTelefonoMovilClienteDomain());
		setFechaNacimiento (fechaNacimiento);
	}
	
	
	public ClienteDomain() {
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
	public final TipoIdentificacionDomain getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final void setTipoidentificacion(TipoIdentificacionDomain tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public final nombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}
	public final void setNombreCompleto(nombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public final CorreoElectronicoDomain getCorreoElectronico() {
		return correoElectronico;
	}
	public final void setCorreoElectronico(CorreoElectronicoDomain correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public final NumeroTelefonoMovilClienteDomain getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final void setNumeroTelefonoMovil(NumeroTelefonoMovilClienteDomain numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	

}
