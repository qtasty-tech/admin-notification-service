package com.admin.admin_notification_service.model;

import com.admin.admin_notification_service.model.enums.UserRole;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private UserRole role = UserRole.customer;
    private boolean isVerified;
}