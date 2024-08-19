package com.epam.codemastery.InterviewX.utils;

import com.epam.codemastery.InterviewX.service.Auditable;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Utility {

    public static <T extends Auditable> void setDefaultFields(T entity) {
        entity.setDateCreated(new Date());
        entity.setDateModified(new Date());
        entity.setIsDeleted(false);
    }
}

