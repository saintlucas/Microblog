package com.microblog.Microblog.model.repository;

import com.microblog.Microblog.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}