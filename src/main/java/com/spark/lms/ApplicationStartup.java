package com.spark.lms;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.spark.lms.common.Constants;
import com.spark.lms.model.Member;
import com.spark.lms.model.User;
import com.spark.lms.service.MemberService;
import com.spark.lms.service.UserService;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initDatabaseEntities();
    }
   


    private void initDatabaseEntities() {

        if( userService.getAllUsers().size() == 0) {
           
            userService.addNew(new User("Mr. Librarian", "librarian", "librarian1", Constants.ROLE_LIBRARIAN,(long)1));
            memberService.addNew(new Member(Constants.ROLE_LIBRARIAN,"librarian","librarian","librarian","Male",new Date(),new Date(),(long)1));
            userService.addNew(new User("Rishika", "Rishika", "Rishika2", Constants.MEMBER_STUDENT,(long)2));
            memberService.addNew(new Member(Constants.MEMBER_STUDENT,"Rishika","Rishika","Rishika","Female",new Date(),new Date(),(long)2));
        }

    }
}
