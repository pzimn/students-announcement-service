package com.student.service.web.repository;

import com.student.service.web.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
