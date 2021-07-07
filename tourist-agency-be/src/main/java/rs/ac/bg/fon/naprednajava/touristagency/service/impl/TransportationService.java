package rs.ac.bg.fon.naprednajava.touristagency.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.naprednajava.touristagency.dto.TransportationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.TransportationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyExists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.DestinationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.TransportationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.DestinationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.TransportationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.MyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Transportation Service
 *
 * @author mdjukanovic
 */
@Service
public class TransportationService implements MyService<TransportationDto, Long> {

    /** Transportation Repository **/
    private final TransportationRepository transportationRepository;

    /** Destination entity **/
    private final DestinationRepository destinationRepository;

    /** Transportation Mapper **/
    private final TransportationMapper transportationMapper;

    /** Destination Mapper **/
    private final DestinationMapper destinationMapper;

    public TransportationService(TransportationRepository transportationRepository, DestinationRepository destinationRepository, TransportationMapper transportationMapper, DestinationMapper destinationMapper) {
        this.transportationRepository = transportationRepository;
        this.destinationRepository = destinationRepository;
        this.transportationMapper = transportationMapper;
        this.destinationMapper = destinationMapper;
    }

    @Override
    public Optional<TransportationDto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<TransportationDto> getAll() {
        List<TransportationEntity> transportationEntities = this.transportationRepository.findAll();
        return transportationEntities.stream().map(this.transportationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TransportationDto save(TransportationDto dto) throws MyEntityAlreadyExists, MyEntityDoesntExist {
        DestinationEntity startDestination = this.destinationRepository.findById(dto.getStart().getId()).orElse(null);
        DestinationEntity endDestination = this.destinationRepository.findById(dto.getEnd().getId()).orElse(null);

        if(startDestination == null || endDestination == null) {
            throw  new MyEntityDoesntExist("Given destinations can not be found");
        } else {
            dto.setStart(this.destinationMapper.toDto(startDestination));
            dto.setEnd(this.destinationMapper.toDto(endDestination));
            TransportationEntity transportationEntity = this.transportationMapper.toEntity(dto);
            this.transportationRepository.save(this.transportationMapper.toEntity(dto));
            return dto;
        }
    }

    @Override
    public void delete(Long aLong) throws MyEntityDoesntExist {

    }

    @Override
    public Optional<TransportationDto> update(TransportationDto dto) throws MyEntityDoesntExist, MyEntityAlreadyExists {
        return Optional.empty();
    }

    @Override
    public Page<TransportationDto> findByPage(Pageable pageable) {
        return null;
    }
}
