package com.admin.admin_notification_service.service;

import com.admin.admin_notification_service.client.UserClient;
import com.admin.admin_notification_service.dto.UserDTO;
import com.admin.admin_notification_service.model.NotificationTemplate;
import com.admin.admin_notification_service.model.User;
import com.admin.admin_notification_service.repository.admin.NotificationTemplateRepository;
import com.admin.admin_notification_service.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final UserRepository userRepository;
    private final NotificationTemplateRepository templateRepository;
    private final EmailService emailService;
    private final UserClient userClient;

    public void sendNotifications(String templateId) {
        NotificationTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        List<UserDTO> users = userClient.getAllUsers();

        for (UserDTO user : users) {
            if (user.getEmail() != null && user.isVerified()) {
                System.out.println("Sending email to: " + user.getEmail());
                emailService.sendHtmlEmail(user.getEmail(), template.getSubject(), template.getContent());
            }
        }
    }

    public void sendTransactionEmail(String userId, String htmlContent) {
        UserDTO user = userClient.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        if (user.getEmail() == null) {
            throw new RuntimeException("User email not found for id: " + userId);
        }

        System.out.println("Sending -----------------------------------------------------------------------------------email to: " + user.getEmail());
        emailService.sendHtmlEmail(
               "thisarajayas2@gmail.com",
                "Your Transaction Receipt",
                htmlContent
        );
    }

    public void sendVerificationEmail(String userId, String htmlContent, String subject) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        System.out.println("Sending -----------------------------------------------------------------------verify------------email to: " + user.getEmail());
        emailService.sendHtmlEmail("thisarajayas2@gmail.com", subject, htmlContent);
    }
}