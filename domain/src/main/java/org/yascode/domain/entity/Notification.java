package org.yascode.domain.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.yascode.shared.enums.NotificationStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "notifications")
public class Notification extends AbstractEntity {
    private String message;
    private String email;
    private NotificationStatus status;
}
