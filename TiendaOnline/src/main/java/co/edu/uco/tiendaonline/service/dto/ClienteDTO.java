package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class ClienteDTO {
	
	private UUID id;
	private TipoIdentificacionDTO tipoidentificacion;
	private String identificacion;
	private nombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoDTO correoElectronico;
	private NumeroTelefonoMovilClienteDTO numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	public ClienteDTO(UUID id, TipoIdentificacionDTO tipoidentificacion, String identificacion,
			nombreCompletoClienteDTO nombreCompleto, CorreoElectronicoDTO correoElectronico,
			NumeroTelefonoMovilClienteDTO numeroTelefonoMovil, Date fechaNacimiento) {
		setId (id);
		setTipoidentificacion (new TipoIdentificacionDTO());
		setIdentificacion (UtilTexto.VACIO);
		setNombreCompleto (new nombreCompletoClienteDTO());
		setCorreoElectronico (new CorreoElectronicoDTO());
		setNumeroTelefonoMovil (new NumeroTelefonoMovilClienteDTO());
		setFechaNacimiento (fechaNacimiento);
	}
	
	
	public ClienteDTO() {
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
	public final TipoIdentificacionDTO getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final void setTipoidentificacion(TipoIdentificacionDTO tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public final nombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final void setNombreCompleto(nombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public final CorreoElectronicoDTO getCorreoElectronico() {
		return correoElectronico;
	}
	public final void setCorreoElectronico(CorreoElectronicoDTO correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public final NumeroTelefonoMovilClienteDTO getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final void setNumeroTelefonoMovil(NumeroTelefonoMovilClienteDTO numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	

}
