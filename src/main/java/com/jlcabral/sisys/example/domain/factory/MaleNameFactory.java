package com.jlcabral.sisys.example.domain.factory;

public class MaleNameFactory extends AbstractNameFactory {

	private static final String[] FIRSTNAME = { "Miguel", "Arthur", "Bernardo", "Heitor", "Davi", "Lorenzo", "Théo",
			"Pedro", "Gabriel", "Enzo", "Matheus", "Lucas", "Benjamin", "Nicolas", "Guilherme", "Rafael", "Joaquim",
			"Samuel", "Enzo Gabriel", "João Miguel", "Henrique", "Gustavo", "Murilo", "Pedro Henrique", "Pietro",
			"Lucca", "Felipe", "João Pedro", "Isaac", "Benício", "Daniel", "Anthony", "Leonardo", "Davi Lucca", "Bryan",
			"Eduardo", "João Lucas", "Victor", "João", "Cauã", "Antônio", "Vicente", "Caleb", "Gael", "Bento", "Caio",
			"Emanuel", "Vinícius", "João Guilherme", "Davi Lucas", "Noah", "João Gabriel", "João Victor", "Luiz Miguel",
			"Francisco", "Kaique", "Otávio", "Augusto", "Levi", "Yuri", "Enrico", "Thiago", "Ian", "Victor Hugo",
			"Thomas", "Henry", "Luiz Felipe", "Ryan", "Arthur Miguel", "Davi Luiz", "Nathan", "Pedro Lucas",
			"Davi Miguel", "Raul", "Pedro Miguel", "Luiz Henrique", "Luan", "Erick", "Martin", "Bruno", "Rodrigo",
			"Luiz Gustavo", "Arthur Gabriel", "Breno", "Kauê", "Enzo Miguel", "Fernando", "Arthur Henrique",
			"Luiz Otávio", "Carlos Eduardo", "Tomás", "Lucas Gabriel", "André", "José", "Yago", "Danilo",
			"Anthony Gabriel", "Ruan", "Miguel Henrique", "Oliver" };

	@Override
	public String firstName() {
		return randomValue(FIRSTNAME);
	}

}
