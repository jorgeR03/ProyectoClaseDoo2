package co.edu.uco.tiendaonline.service.mapper.entity;

import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;

public interface EntityMapper<E, D> {
	
	D toDomain(TipoIdentificacionDomain domain);
	
	E toEntity(D entity);

	TipoIdentificacionDomain toDomain(TipoIdentificacionEntity entity);

}
