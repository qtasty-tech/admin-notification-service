package com.admin.admin_notification_service.dto;

import lombok.Data;

@Data
public class TransactionEmailRequest {
    private String userId;
    private String htmlContent;
}
