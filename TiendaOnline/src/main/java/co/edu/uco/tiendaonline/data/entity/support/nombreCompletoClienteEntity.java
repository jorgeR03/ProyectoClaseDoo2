package co.edu.uco.tiendaonline.data.entity.support;

public class nombreCompletoClienteEntity {
	private String primerNombre;
	private String SegundoNombre;
	public String primerApellido;
	public String segundoApellido;

	public nombreCompletoClienteEntity() {
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return SegundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		SegundoNombre = segundoNombre;
	}
}