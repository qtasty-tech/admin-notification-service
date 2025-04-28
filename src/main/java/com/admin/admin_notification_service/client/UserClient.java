package com.admin.admin_notification_service.client;

import com.admin.admin_notification_service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserClient {

    private final RestTemplate restTemplate;

    //private static final String ADMIN_SERVICE_URL = "http://admin-service:8084"; // Docker container name or use http://localhost:8084 if running locally
    private static final String ADMIN_SERVICE_URL = "http://admin-service:8084";
    public UserDTO getUserById(String userId) {
        return restTemplate.getForObject(ADMIN_SERVICE_URL + "/api/admin/users/" + userId, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        UserDTO[] users = restTemplate.getForObject(ADMIN_SERVICE_URL + "/api/admin/users", UserDTO[].class);
        return Arrays.asList(users);
    }
}
