package org.gsc.medha.api.endpoint;

import java.util.List;
import java.util.Map;


import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.MedhaNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/notify")
public class NotificationController {
	@Resource(name="medhaRegNotificationService")
	MedhaNotificationService medhaNotificationService;
	@Autowired
	CandidateFacade candidateFacade;
	@Autowired
	ExamService examService;

	@PostMapping("/whatsapp/reg-notification")
	@ResponseBody
	private String sendRegistrationNotification() {
		List<Map<Integer,TemplateMessage>> notifications = candidateFacade.getPendingRegistrationNotification(examService.getActiveExam());
		medhaNotificationService.sendRegistrationWhatsAppNotification(notifications);
		return "Done";
	}
}
