package com.sadek.jpa.test.core.abstractions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
public abstract class BaseEntity<TID>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TID id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private  Date createdAt;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private  Date lastModifiedAt;

    private boolean isDeleted;
}
