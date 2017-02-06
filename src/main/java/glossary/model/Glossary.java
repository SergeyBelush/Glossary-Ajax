package glossary.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "glossary")
public class Glossary {

	private String id;
	
	private String word;
	
	private String description;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
