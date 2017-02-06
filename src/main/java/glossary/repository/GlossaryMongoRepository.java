package glossary.repository;

import glossary.model.Glossary;
import org.springframework.data.repository.CrudRepository;

public interface GlossaryMongoRepository extends

        CrudRepository<Glossary, String>{
}