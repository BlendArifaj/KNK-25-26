package services;

import models.dto.IRequestDto;
import models.mappers.Mapper;
import repository.IRepository;

abstract public class BaseModelService<T> {
    private IRepository<T> repository;
    private Mapper<T> mapper;

    public T save(IRequestDto dto){
        this.validate(dto);
        T obj = this.mapper.fromDto(dto);
        return this.repository.create(obj);
    }

    abstract void validate(IRequestDto dto);
}
