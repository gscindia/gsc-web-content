package org.gsc.medha.populator;

import java.util.ArrayList;
import java.util.List;

import org.gsc.medha.dto.notification.Language;
import org.gsc.medha.dto.notification.Parameter;
import org.gsc.medha.dto.notification.Template;
import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.entity.Candidate;
import org.gsc.populator.Populator;
import org.springframework.stereotype.Component;

@Component("medhaRegistrationConfirmationWhatsAppMsgPopulator")
public class WhatsAppTemplateNotificationPopulator implements Populator<Candidate, TemplateMessage> {
	private String NAMESPACE = "1615b18d_9095_4e62_b644_370a0e00e92e";
	private String TEMPLATE = "registration_medha";

	@Override
	public void populate(Candidate source, TemplateMessage target) {

		target.setTo(source.getContact());
		target.setType("template");
		Template template = new Template();
		template.setNamespace(NAMESPACE);
		template.setName(TEMPLATE);
		Language lang = new Language();
		lang.setCode("en_US");
		lang.setPolicy("deterministic");
		template.setLanguage(lang);
		List<org.gsc.medha.dto.notification.Component> comps = new ArrayList<org.gsc.medha.dto.notification.Component>();

		org.gsc.medha.dto.notification.Component body = new org.gsc.medha.dto.notification.Component();
		body.setType("body");
		List<Parameter> bodyParams = new ArrayList<Parameter>();
		Parameter param1 = new Parameter();
		param1.setType("text");
		param1.setText(source.getExam().getDate().toString());
		bodyParams.add(param1);
		Parameter param2 = new Parameter();
		param2.setType("text");
		param2.setText(source.getSection() > 4 ? "11 AM" : "2 PM");
		bodyParams.add(param2);
		Parameter param3 = new Parameter();
		param3.setType("text");
		param3.setText(source.getName().toUpperCase());
		bodyParams.add(param3);
		body.setParameters(bodyParams);
		comps.add(body);

		org.gsc.medha.dto.notification.Component header = new org.gsc.medha.dto.notification.Component();
		header.setType("header");
		List<Parameter> headerParams = new ArrayList<Parameter>();
		param1.setText(source.getExam().getName());
		headerParams.add(param1);
		header.setParameters(headerParams);
		comps.add(header);

		template.setComponents(comps);
		target.setTemplate(template);

	}

	@Override
	public void populateAll(List<Candidate> source, List<TemplateMessage> target) {
		source.forEach(s -> {
			if (s.getContact() != null) {
				TemplateMessage msg = new TemplateMessage();
				this.populate(s, msg);
				target.add(msg);
			}
		});

	}

}
