package org.yascode.domain.entity;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.yascode.domain.listener.NotificationEntityListener;
import org.yascode.shared.enums.NotificationStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "notifications")
@EntityListeners(NotificationEntityListener.class)
public class Notification extends AbstractEntity {
    private String message;
    private String email;
    private NotificationStatus status;
}
