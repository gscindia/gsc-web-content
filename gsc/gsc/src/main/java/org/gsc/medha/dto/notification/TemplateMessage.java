package org.gsc.medha.dto.notification;

public class TemplateMessage {
	private String messaging_product;
	private String to;
	private String type;
	private Template template;

	public TemplateMessage() {
		this.messaging_product = "whatsapp";
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getMessaging_product() {
		return messaging_product;
	}

	public void setMessaging_product(String messaging_product) {
		this.messaging_product = messaging_product;
	}

}
