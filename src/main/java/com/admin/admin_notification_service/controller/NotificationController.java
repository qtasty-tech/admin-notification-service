package com.admin.admin_notification_service.controller;

import com.admin.admin_notification_service.dto.TransactionEmailRequest;
import com.admin.admin_notification_service.dto.VerificationEmailRequest;
import com.admin.admin_notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotifications(@RequestParam String templateId) {
        System.out.println("TemplateId"+templateId);
        notificationService.sendNotifications(templateId);
        return "Notifications sent successfully!";
    }
    @PostMapping("/send-transaction")
    public ResponseEntity<String> sendTransactionEmail(@RequestBody TransactionEmailRequest request) {
        try {
            notificationService.sendTransactionEmail(request.getUserId(), request.getHtmlContent());
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending email: " + e.getMessage());
        }
    }
    @PostMapping("/send-verification")
    public ResponseEntity<String> sendVerificationEmail(@RequestBody VerificationEmailRequest request) {
        try {
            notificationService.sendVerificationEmail(
                    request.getUserId(),
                    request.getHtmlContent(),
                    request.getSubject()
            );
            return ResponseEntity.ok("Verification email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending verification email: " + e.getMessage());
        }
    }
}