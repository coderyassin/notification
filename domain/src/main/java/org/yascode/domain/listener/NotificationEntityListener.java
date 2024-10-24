package org.yascode.domain.listener;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.yascode.domain.entity.Notification;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
public class NotificationEntityListener extends AbstractMongoEventListener<Notification> {
    public void onBeforeConvert(BeforeConvertEvent<Notification> event) {
        Notification notification = event.getSource();

        if (Objects.isNull(notification.getId()) || notification.getId().equals("0")) {
            notification.setId(UUID.randomUUID().toString());
        }

        if (Objects.isNull(notification.getCreatedAt())) {
            notification.setCreatedAt(LocalDateTime.now());
        }
        notification.setUpdatedAt(LocalDateTime.now());
    }
}
