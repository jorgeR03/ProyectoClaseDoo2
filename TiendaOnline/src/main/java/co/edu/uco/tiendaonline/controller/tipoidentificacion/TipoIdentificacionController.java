package co.edu.uco.tiendaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.ConsultarPorIdTipoIdentificacionFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.EliminarTipoIdentificacionFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.ModificarTipoIdentificacionFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public class TipoIdentificacionController {
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDummy() {
		return TipoIdentificacionDTO.crear();
	}

	@GetMapping
	public final TipoIdentificacionDTO consultar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping("/{id}")
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultarPorId(@PathVariable("id") UUID id) {
		
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		
		try {
			
			var domain =  TipoIdentificacionDomain.crear(id, null, null, false);
			TipoIdentificacionDTO dto = TipoIdentificacionDTOMapper.convertToDTO(domain);
			
			ConsultarPorIdTipoIdentificacionFacade facade = new ConsultarPorIdTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación se ha consultado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de consultar el tipo de identificacion");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	

	@PostMapping()
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación se ha registrado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de resgistrar el tipo de identificacion");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@PutMapping("{id}")
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			ModificarTipoIdentificacionFacade facade = new ModificarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación se ha modificado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de modificar el tipo de identificacion");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@DeleteMapping("/{id}")
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable("id") UUID id) {
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			var domain =  TipoIdentificacionDomain.crear(id, null, null, false);
			TipoIdentificacionDTO dto = TipoIdentificacionDTOMapper.convertToDTO(domain);
			
			EliminarTipoIdentificacionFacade facade = new EliminarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificación se ha eliminado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de eliminar el tipo de identificacion");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}

	


}
