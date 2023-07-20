package com.ust.consumer.repository;

import com.ust.consumer.dto.MessageDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<MessageDto,String> {
}
