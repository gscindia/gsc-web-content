package org.gsc.service;

import org.json.JSONObject;

public interface NotificationService {

	JSONObject postWhatsAppNotification(String message);

}
