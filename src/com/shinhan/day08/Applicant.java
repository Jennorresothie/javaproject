package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Applicant<T> {
	T kind;
}
