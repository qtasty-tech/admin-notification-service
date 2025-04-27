package com.admin.admin_notification_service.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "notification_templates")
public class NotificationTemplate {
    @Id
    private String id;
    private String name;
    private String subject;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}