package org.gsc.medha.dto.notification;
import java.util.List;


public class Template {
    private String namespace;
    private String name;
    private Language language;
    private List<Component> components;
    
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}

    
}

