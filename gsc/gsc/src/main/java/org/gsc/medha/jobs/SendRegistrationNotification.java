package org.gsc.medha.jobs;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.MedhaNotificationService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendRegistrationNotification {
	@Resource(name = "medhaRegNotificationService")
	MedhaNotificationService medhaNotificationService;
	@Autowired
	CandidateFacade candidateFacade;
	@Autowired
	ExamService examService;
	@Value("${gsc.medha.meta.whatsapp.enabled}")
	Boolean settingsLookup;
	private static final Logger LOGGER = LoggerFactory.getLogger(SendRegistrationNotification.class);

	@Scheduled(fixedDelay = 10, initialDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void scheduledOnEveryTwentySeconds() {
		if (settingsLookup) {
			LOGGER.info("Starting Registration Notification Batch on : " + new Date().toString());
			List<Map<Integer, TemplateMessage>> notifications = candidateFacade
					.getPendingRegistrationNotification(examService.getActiveExam());
			List<Map<Integer, JSONObject>> responses = medhaNotificationService
					.sendRegistrationWhatsAppNotification(notifications);
			candidateFacade.updateRegistrationNotificationStatus(responses);
			LOGGER.info("Registration Notification Batch has Finished on : " + new Date().toString());

		} else {
			LOGGER.info("Registration Notification is disabled - " + new Date().toString());

		}

	}
}
