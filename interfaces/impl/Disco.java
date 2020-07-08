package br.com.imepac.site.interfaces.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disco {
	
	
	private String raiz ="C:\\" ;
	
	
	private String diretorioFotos = "tmp";
	
	public void salvarFoto(MultipartFile foto) {
		this.salvar(diretorioFotos,foto);
		}

	
	public void salvar(String diretorio,MultipartFile arquivo) {
		
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		try {
			
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo");
		}
		
	}
}
