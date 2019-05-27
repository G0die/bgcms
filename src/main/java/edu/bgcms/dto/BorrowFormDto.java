package edu.bgcms.dto;

import edu.bgcms.model.workFlow.BorrowForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowFormDto extends BorrowForm {
    private String bgName;

    private String curUserName;

    private String applicantName;
}
