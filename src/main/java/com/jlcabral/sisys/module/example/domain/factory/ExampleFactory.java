package com.jlcabral.sisys.module.example.domain.factory;

import java.util.Arrays;
import java.util.List;

import com.jlcabral.core.enumerated.TypeGenderEnum;
import com.jlcabral.sisys.module.example.domain.model.ExampleModel;

public class ExampleFactory {

	private ExampleFactory() {
	}

	public static List<ExampleModel> mockListExamples() {
		return Arrays.asList(mockExample());
	}

	public static ExampleModel mockExample() {
		return new ExampleModel(1L, "Name Example", 999, TypeGenderEnum.M);
	}
}
