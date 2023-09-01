package org.gsc.medha.service;

import java.util.List;
import java.util.Map;

import org.gsc.medha.dto.notification.TemplateMessage;
import org.json.JSONObject;

public interface MedhaNotificationService {

	List<Map<Integer, JSONObject>> sendRegistrationWhatsAppNotification(List<Map<Integer,TemplateMessage>> notificationsDto);

	

}
