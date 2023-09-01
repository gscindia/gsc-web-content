package org.gsc.medha.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.service.MedhaNotificationService;
import org.gsc.service.NotificationService;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component("medhaRegNotificationService")
public class DefaultMedhaRegistrationNotificationService implements MedhaNotificationService {
	@Resource(name = "notificationService")
	NotificationService notificationService;

	@Override
	public List<Map<Integer, JSONObject>> sendRegistrationWhatsAppNotification(
			List<Map<Integer, TemplateMessage>> notificationsDto) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		List<Map<Integer, JSONObject>> response = new ArrayList<Map<Integer, JSONObject>>();

		notificationsDto.forEach(notify -> {
			try {
				JSONObject resp = notificationService
						.postWhatsAppNotification(ow.writeValueAsString(notify.get(notify.keySet().toArray()[0])));
				
				Map<Integer, JSONObject> responseMap = new LinkedHashMap<Integer, JSONObject>();
				responseMap.put((Integer) notify.keySet().toArray()[0], resp);
				response.add( responseMap);
			} catch (JsonProcessingException e) {

				e.printStackTrace();
			}
		});

		return response;
	}

}
