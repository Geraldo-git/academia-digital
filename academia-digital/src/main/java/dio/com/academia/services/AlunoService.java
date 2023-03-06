package dio.com.academia.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dio.com.academia.DTO.AlunoDTO;
import dio.com.academia.entities.Aluno;
import dio.com.academia.repositories.AlunoRepository;
import dio.com.academia.services.exceptions.DatabaseException;
import dio.com.academia.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {


    @Autowired
    AlunoRepository repository;

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Aluno product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto não encontrado!"));
        return new AlunoDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<AlunoDTO> findAll(Pageable pageable) {
        Page<Aluno> list = repository.findAll(pageable);
        //return list.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
        return list.map(x -> new AlunoDTO(x));
    }

    @Transactional
    public AlunoDTO insert(AlunoDTO dto) {

        Aluno entity = new Aluno();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        return new AlunoDTO(entity);
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        try {
            Aluno entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AlunoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Produto não encontrado!");
        }
    }

   @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado!");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade!");
        }
    }


    private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {

        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setBairro(dto.getBairro());
        entity.setDataDeNascimento(dto.getDataDeNascimento());
    }
}
