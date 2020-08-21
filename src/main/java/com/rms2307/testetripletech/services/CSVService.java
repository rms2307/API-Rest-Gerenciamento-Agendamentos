package com.rms2307.testetripletech.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {

	public List<String> processarCSV(MultipartFile arquivo) {
		File arquivoConvertido = converterDeMultipartFileParaFile(arquivo);
		List<String> dados = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoConvertido))) {
			String line = br.readLine();
			while (line != null) {
				dados.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dados;
	}

	public File converterDeMultipartFileParaFile(MultipartFile arquivo) {
		File convArq = new File(System.getProperty("java.io.tmpdir") + arquivo.getOriginalFilename());
		System.out.println(System.getProperty("java.io.tmpdir"));
		try {
			convArq.createNewFile();
			FileOutputStream fos = new FileOutputStream(convArq);
			fos.write(arquivo.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convArq;
	}
}
