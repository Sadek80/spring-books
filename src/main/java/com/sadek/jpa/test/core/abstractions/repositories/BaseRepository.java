package com.sadek.jpa.test.core.abstractions.repositories;

import com.sadek.jpa.test.core.abstractions.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<TEntity extends BaseEntity<TID>, TID> extends JpaRepository<TEntity, TID> {
}
