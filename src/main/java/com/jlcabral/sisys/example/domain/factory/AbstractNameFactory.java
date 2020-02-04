package com.jlcabral.sisys.example.domain.factory;

import static com.jlcabral.core.constant.Caracteres.ESPACO;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNameFactory extends RandomFactory implements INameRandom {

	private static final String[] LASTNAME = { "Abreu", "Adães", "Adorno", "Aguiar", "Albuquerque", "Alcântara",
			"Alencar", "Almeida", "Altamirano", "Alvarenga", "Álvares", "Alves", "Alvim", "Amaral", "Amigo", "Amorim",
			"Anchieta", "Andrada", "Andrade", "Anes", "Antunes", "Aragão", "Araújo", "Arruda", "Assis", "Azeredo",
			"Azevedo", "Bandeira", "Barbosa", "Barros", "Barroso", "Bastos", "Batista", "Bernades", "Bernardes",
			"Bispo", "Bocaiuva", "Bolsonaro", "Borba", "Borges", "Borsoi", "Botelho", "Braga", "Bragança", "Brandão",
			"Bueno", "Cabral", "Camargo", "Caminha", "Camões", "Cardoso", "Carmo", "Carneiro", "Carvalho", "Castilho",
			"Castro", "Chaves", "Coelho", "Constante", "Cordeiro", "Costa", "Cotrim", "Couto", "Coutinho", "Cruz",
			"Cunha", "Curado", "Dias", "Diegues", "Dorneles", "Duarte", "Esteves", "Fagundes", "Faleiros", "Falqueto",
			"Faria", "Farias", "Faro", "Ferrão", "Ferraz", "Ferreira", "Ferrolho", "Fernandes", "Figueira",
			"Figueiredo", "Figueiroa", "Fioravante", "Fonseca", "Fontes", "Fortaleza", "França", "Freire", "Freitas",
			"Frota", "Furquim", "Furtado", "Galvão", "Garrastazu", "Gomes", "Gonçales", "Marques", "Martins", "Massa",
			"Matos", "Médici", "Meireles", "Mello", "Melo", "Mendes", "Mendonça", "Mesquita", "Miranda", "Moraes",
			"Morais", "Morato", "Moreira", "Moro", "Monteiro", "Muniz", "Nantes", "Nascimento", "Navarro", "Naves",
			"Negreiros", "Negrete", "Neves", "Nóbrega", "Nogueira", "Noronha", "Nunes", "Oliva", "Oliveira", "Outeiro",
			"Pacheco", "Padrão", "Paes", "Pais", "Paiva", "Paixão", "Parga", "Pascal", "Pascoal", "Pasquim", "Patriota",
			"Peçanha", "Pedrosa", "Pedroso", "Peixoto", "Pensamento", "Penteado", "Pereira", "Peres", "Pestana",
			"Pimenta", "Pimentel", "Pinheiro", "Pinto", "Pires", "Poeta", "Policarpo", "Prado", "Prudente", "Quaresma",
			"Queiroz", "Ramalhete", "Ramalho", "Ramires", "Ramos", "Rangel", "Reis", "Resende", "Ribeiro", "Rios",
			"Rodrigues", "Roma", "Romão", "Sá", "Sacramento", "Sampaio", "Sampaulo", "Sampedro", "Sanches", "Santacruz",
			"Santana", "Santander", "Santarrosa", "Santiago", "Santos", "Saragoça", "Saraiva", "Saramago", "Seixas",
			"Serra", "Serrano", "Silva", "Silveira", "Simões", "Siqueira", "Soares", "Soeiro" };

	@Override
	public String fullName() {
		return firstName().concat(ESPACO).concat(lastName());
	}

	@Override
	public String lastName() {
		return randomValue(LASTNAME, 2);
	}
	
	public List<String> listFullNames(Integer qtd) {
		List<String> lista = new ArrayList<>();
		for (int i = 0; i < qtd; i++) {
			lista.add(fullName());
		}
		return lista;
	}

}
