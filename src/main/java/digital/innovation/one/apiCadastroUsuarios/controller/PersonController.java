package digital.innovation.one.apiCadastroUsuarios.controller;

import digital.innovation.one.apiCadastroUsuarios.dto.request.PersonDTO;
import digital.innovation.one.apiCadastroUsuarios.dto.response.MessageResponseDTO;
import digital.innovation.one.apiCadastroUsuarios.exception.PersonNotFoundException;
import digital.innovation.one.apiCadastroUsuarios.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
    private final PersonService personService;

    @ApiOperation(value = "Cadastra uma nova pessoa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO){
        return personService.create(personDTO);
    }

    @ApiOperation(value = "Busca uma pessoa pelo id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{return personService.findById(id);}

    @ApiOperation(value = "Lista todas as pessoas cadastradas")
    @GetMapping
    public List<PersonDTO> listAll(){return personService.listAll();}

    @ApiOperation(value = "Atualiza os dados de uma pessoa pelo id")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException{
        return personService.update(id, personDTO);
    }

    @ApiOperation(value = "Deleta uma pessoa pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException{
        personService.delete(id);
    }
}
