package org.gsc.medha.service;

import java.util.List;

import org.gsc.medha.dto.notification.TemplateMessage;

public interface MedhaNotificationService {

	String sendWhatsAppNotification(List<TemplateMessage> notificationsDto);

}
