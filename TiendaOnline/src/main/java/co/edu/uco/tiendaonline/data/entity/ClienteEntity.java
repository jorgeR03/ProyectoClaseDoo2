package co.edu.uco.tiendaonline.data.entity;

import java.util.UUID;

public class ClienteEntity {
	
	public static class NombreCompletoClienteEntityData {
		private String primerNombre;
		private String SegundoNombre;
		private String primerApellido;
		private String segundoApellido;

		public NombreCompletoClienteEntityData() {
		}

		public String getPrimerNombre() {
			return primerNombre;
		}

		public void setPrimerNombre(final String primerNombre) {
			this.primerNombre = primerNombre;
		}

		public String getSegundoNombre() {
			return SegundoNombre;
		}

		public void setSegundoNombre(final String segundoNombre) {
			SegundoNombre = segundoNombre;
		}

		public String getPrimerApellido() {
			return primerApellido;
		}

		public void setPrimerApellido(final String primerApellido) {
			this.primerApellido = primerApellido;
		}

		public String getSegundoApellido() {
			return segundoApellido;
		}

		public void setSegundoApellido(final String segundoApellido) {
			this.segundoApellido = segundoApellido;
		}
	}


	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private String Identificacion; 
	private NombreCompletoClienteEntityData data = new NombreCompletoClienteEntityData();
	private String correoElectronico; 
	private boolean correoElectronicoConfirmado; 
	private String numeroTelefonoMovil; 
	private boolean numeroTelefonoMOvilConfirmado;
	
	
	
		
		
	


	public final UUID getId() {
		return id;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	private final void setIdentificacion(final String identificacion) {
		Identificacion = identificacion;
	}


	private final void setPrimerNombre(final String primerNombre) {
		this.data.setPrimerNombre(primerNombre);
	}


	private final void setSegundoNombre(final String segundoNombre) {
		data.setSegundoNombre(segundoNombre);
	}


	private final void setPrimerApellido(final String primerApellido) {
		this.data.setPrimerApellido(primerApellido);
	}


	private final void setSegundoApellido(final String segundoApellido) {
		this.data.setSegundoApellido(segundoApellido);
	}


	private final void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}


	private final void setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}


	private final void setNumeroTelefonoMOvilConfirmado(boolean numeroTelefonoMOvilConfirmado) {
		this.numeroTelefonoMOvilConfirmado = numeroTelefonoMOvilConfirmado;
	}


	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public final String getIdentificacion() {
		return Identificacion;
	}


	public final String getPrimerNombre() {
		return data.getPrimerNombre();
	}


	public final String getSegundoNombre() {
		return data.getSegundoNombre();
	}


	public final String getPrimerApellido() {
		return data.getPrimerApellido();
	}


	public final String getSegundoApellido() {
		return data.getSegundoApellido();
	}


	public final String getCorreoElectronico() {
		return correoElectronico;
	}


	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}


	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}


	public final boolean isNumeroTelefonoMOvilConfirmado() {
		return numeroTelefonoMOvilConfirmado;
	}
	
	

}
