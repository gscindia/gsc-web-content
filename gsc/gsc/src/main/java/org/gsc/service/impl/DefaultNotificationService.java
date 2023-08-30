package org.gsc.service.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.gsc.service.NotificationService;
import org.springframework.stereotype.Component;

@Component("notificationService")
public class DefaultNotificationService implements NotificationService {
	
	@Override
	public String postWhatsAppNotification(String message) {
		String token = "EAANjcvYOap8BO46V7did1wDrMl1t29ELvwSSLOSBz7ZBsOU6WbmIcEo9EJA8dSrip9GS6bDlL3pyuIodobarj10QQEsj2MwSZAKi0F0scyUUgtaizG5Qxc1Xd9JS1JzsvDAf3Sf21ZAL3aEjKksE7TyRvQC2LfSQ4zupQGJ6wjAqzZAFNWgaH0pJqy8Jh0TFGF9YiZBRMJXk2kt0hkKZAz";
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("https://graph.facebook.com/v13.0/108679655668715/messages"))
					.header("Authorization", "Bearer " + token).header("Content-Type", "application/json")
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
