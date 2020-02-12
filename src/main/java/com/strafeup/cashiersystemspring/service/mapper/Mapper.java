package com.strafeup.cashiersystemspring.service.mapper;

public interface Mapper<E, D> {

    E mapDomainToEntity(D domain);

    D mapEntityToDomain(E entity);
}
