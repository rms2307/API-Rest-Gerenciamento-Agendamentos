package com.rms2307.testetripletech.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class CSVService {

	public void adicionarAgendamento() {

		try (BufferedReader br = new BufferedReader(new FileReader("AdicionarAgendamento.csv"))) {
			String line = br.readLine();

			System.out.println("Adicionar");
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public void atualizarAgendamento() {

		try (BufferedReader br = new BufferedReader(new FileReader("AtualizarAgendamento.csv"))) {
			String line = br.readLine();

			System.out.println("Atualizar");
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

}
