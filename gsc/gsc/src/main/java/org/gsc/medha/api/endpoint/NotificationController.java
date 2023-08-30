package org.gsc.medha.api.endpoint;

import java.util.List;

import javax.annotation.Resource;

import org.gsc.medha.dto.notification.TemplateMessage;
import org.gsc.medha.facade.CandidateFacade;
import org.gsc.medha.service.ExamService;
import org.gsc.medha.service.MedhaNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {
	@Resource(name="medhaNotificationService")
	MedhaNotificationService medhaNotificationService;
	@Autowired
	CandidateFacade candidateFacade;
	@Autowired
	ExamService examService;

	@PostMapping("/whatsapp/reg-notification")
	@ResponseBody
	private String sendRegistrationNotification() {
		List<TemplateMessage> notifications = candidateFacade.getPendingNotification(examService.getActiveExam());
		medhaNotificationService.sendWhatsAppNotification(notifications);
		return "Done";
	}
}
