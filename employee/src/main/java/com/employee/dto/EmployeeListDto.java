package com.employee.dto;

import com.employee.model.Address;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeListDto {
  private int EmployeeId;
  private String Name;
  private String EmailId;
  private Address Address;
  private Date DOB;
}
