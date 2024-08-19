package com.epam.codemastery.InterviewX.service;

import java.util.Date;

public interface Auditable {
    void setDateCreated(Date dateCreated);

    void setDateModified(Date dateModified);

    void setIsDeleted(Boolean isDeleted);
}