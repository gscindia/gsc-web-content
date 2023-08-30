package org.gsc.medha.service.impl;

import java.util.List;

import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.service.MedhaNotificationService;
import org.gsc.service.impl.DefaultNotificationService;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component("medhaNotificationService")
public class DefaultMedhaNotificationService extends DefaultNotificationService implements MedhaNotificationService {

	@Override
	public String sendWhatsAppNotification(List<TemplateMessage> notificationsDto) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		notificationsDto.forEach(notify-> {
			try {
				super.postWhatsAppNotification(ow.writeValueAsString(notify));
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
		});
		
		return "";
	}

	@Override
	public String postWhatsAppNotification(String message) {
		
		return null;
	}

	

}
