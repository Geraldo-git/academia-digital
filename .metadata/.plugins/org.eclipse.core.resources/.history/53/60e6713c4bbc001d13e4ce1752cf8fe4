package dio.com.academia.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dio.com.academia.DTO.AvaliacaoFisicaDTO;
import dio.com.academia.entities.AvaliacaoFisica;
import dio.com.academia.repositories.AvaliacaoFisicaRepository;
import dio.com.academia.services.exceptions.ResourceNotFoundException;

@Service
public class AvaliacaoFisicaService {


    @Autowired
    private AvaliacaoFisicaRepository repository;

    @Transactional(readOnly = true)
    public AvaliacaoFisicaDTO findById(Long id) {
        AvaliacaoFisica matricula = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("AvaliacaoFisica não encontrada!"));
        return new AvaliacaoFisicaDTO(matricula);
    }

    @Transactional(readOnly = true)
    public Page<AvaliacaoFisicaDTO> findAll(Pageable pageable) {
        Page<AvaliacaoFisica> list = repository.findAll(pageable);
        //return list.stream().map(x -> new AvaliacaoFisicaDTO(x)).collect(Collectors.toList());
        return list.map(x -> new AvaliacaoFisicaDTO(x));
    }

    @Transactional
    public AvaliacaoFisicaDTO insert(AvaliacaoFisicaDTO dto) {

        AvaliacaoFisica entity = new AvaliacaoFisica();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        return new AvaliacaoFisicaDTO(entity);
    }

    @Transactional
    public AvaliacaoFisicaDTO update(Long id, AvaliacaoFisicaDTO dto) {
        try {
            AvaliacaoFisica entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AvaliacaoFisicaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Produto não encontrado!");
        }
    }

   /* @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado!");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade!");
        }
    }*/


    private void copyDtoToEntity(AvaliacaoFisicaDTO dto, AvaliacaoFisica entity) {

        entity.setAltura(dto.getAltura());
        entity.setPeso(dto.getPeso());
        entity.setDataDaAvaliacao(dto.getDataDaAvaliacao());
        
        
    }
}
