package com.admin.admin_notification_service.repository.user;

import com.admin.admin_notification_service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

}