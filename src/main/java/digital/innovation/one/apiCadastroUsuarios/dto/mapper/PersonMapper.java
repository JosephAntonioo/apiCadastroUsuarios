package digital.innovation.one.apiCadastroUsuarios.dto.mapper;

import digital.innovation.one.apiCadastroUsuarios.dto.request.PersonDTO;
import digital.innovation.one.apiCadastroUsuarios.entity.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    PersonModel toModel(PersonDTO dto);

    PersonDTO toDTO(PersonModel dto);
}
