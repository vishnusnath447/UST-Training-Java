package com.ust.consumer.messaging;

import com.ust.consumer.dto.MessageDto;
import com.ust.consumer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

//    @Autowired
//    private BookRepository bookRepository;
    public void receiveMessage(MessageDto messageDto){
//        bookRepository.save(messageDto);
        System.out.println(messageDto);
    }
}
