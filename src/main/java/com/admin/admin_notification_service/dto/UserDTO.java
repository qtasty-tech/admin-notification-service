package com.admin.admin_notification_service.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
//    private UserRole role = UserRole.customer;
    private boolean isVerified;
}
