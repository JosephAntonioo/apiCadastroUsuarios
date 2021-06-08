package digital.innovation.one.apiCadastroUsuarios.service;

import digital.innovation.one.apiCadastroUsuarios.dto.mapper.PersonMapper;
import digital.innovation.one.apiCadastroUsuarios.dto.request.PersonDTO;
import digital.innovation.one.apiCadastroUsuarios.dto.response.MessageResponseDTO;
import digital.innovation.one.apiCadastroUsuarios.entity.PersonModel;
import digital.innovation.one.apiCadastroUsuarios.exception.PersonNotFoundException;
import digital.innovation.one.apiCadastroUsuarios.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO){
        PersonModel person = personMapper.toModel(personDTO);
        PersonModel savedPerson = personRepository.save(person);

        return createMessageResponse("Congratulations, person created with ID ", savedPerson.getId());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll(){
        List<PersonModel> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) throws PersonNotFoundException{
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException{
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        PersonModel updatedPerson = personMapper.toModel(personDTO);
        PersonModel savedPerson = personRepository.save(updatedPerson);
        return createMessageResponse("Congratulations, person updated with ID ", savedPerson.getId());
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2){
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
