package digital.innovation.one.apiCadastroUsuarios.repository;

import digital.innovation.one.apiCadastroUsuarios.entity.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
