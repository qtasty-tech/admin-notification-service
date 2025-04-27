package com.admin.admin_notification_service.dto;
import lombok.Data;
@Data
public class VerificationEmailRequest {
    private String userId;
    private String htmlContent;
    private String subject;
}
