package glossary.repository;

import glossary.model.Glossary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class GlosarrySearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Glossary> searchGlossary(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("description").regex(text, "i"),
							Criteria.where("word").regex(text, "i"))
		), Glossary.class);
	}
	
}
