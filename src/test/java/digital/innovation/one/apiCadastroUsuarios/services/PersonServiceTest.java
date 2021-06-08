package digital.innovation.one.apiCadastroUsuarios.services;


import digital.innovation.one.apiCadastroUsuarios.dto.mapper.PersonMapper;
import digital.innovation.one.apiCadastroUsuarios.dto.request.PersonDTO;
import digital.innovation.one.apiCadastroUsuarios.dto.response.MessageResponseDTO;
import digital.innovation.one.apiCadastroUsuarios.entity.PersonModel;
import digital.innovation.one.apiCadastroUsuarios.repository.PersonRepository;
import digital.innovation.one.apiCadastroUsuarios.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static digital.innovation.one.apiCadastroUsuarios.utils.PersonUtils.createFakeDTO;
import static digital.innovation.one.apiCadastroUsuarios.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        PersonModel expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(PersonModel.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Congratulations, person created with ID " + savedPersonId)
                .build();
    }

}
