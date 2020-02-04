package com.jlcabral.core.factory;

import static com.jlcabral.core.constant.Caracteres.ESPACO;
import static com.jlcabral.core.constant.Caracteres.VAZIO;

import java.util.Random;

public class RandomFactory {

	public static Integer randomLimit(Integer limit) {
		return new Random().nextInt(limit);
	}

	public static String randomValue(String[] values) {
		return values[randomLimit(values.length - 1)];
	}

	public static String randomValue(String[] values, Integer qtd) {
		String value = VAZIO;
		for (int i = 0; i < qtd; i++) {
			value = value.concat(randomValue(values)).concat((i < qtd - 1) ? ESPACO : VAZIO);
		}
		return value;
	}
}
