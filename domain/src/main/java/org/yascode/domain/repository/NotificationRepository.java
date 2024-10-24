package org.yascode.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yascode.domain.entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
