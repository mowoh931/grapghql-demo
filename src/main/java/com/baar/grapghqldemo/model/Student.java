package com.baar.grapghqldemo.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	Integer studentId;
	String lastname;
	String firstname;
	String address;

}
