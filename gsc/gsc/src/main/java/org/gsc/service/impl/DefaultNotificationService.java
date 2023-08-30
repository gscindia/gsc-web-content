package org.gsc.service.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.gsc.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component("notificationService")
public class DefaultNotificationService implements NotificationService {
	@Value("${gsc.medha.meta.whatsapp.accesstoken}")
	String token;
	@Value("${gsc.medha.meta.whatsapp.uri}")
	String URI;
	@Override
	public String postWhatsAppNotification(String message) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(URI))
					.header("Authorization", "Bearer " + token).header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					.POST(HttpRequest.BodyPublishers.ofString(
							message))
					.build();
			HttpClient http = HttpClient.newHttpClient();
			HttpResponse<String> response = http.send(request, BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	

}
