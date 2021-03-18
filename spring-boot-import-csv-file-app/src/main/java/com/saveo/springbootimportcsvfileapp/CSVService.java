package com.saveo.springbootimportcsvfileapp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class CSVService {
	@Autowired
	ProductListRepository repository;
	
	public void save(MultipartFile file) {
	    try {
	      List<ProductList>lists = CSVHelper.csvToList(file.getInputStream());
	      repository.saveAll(lists); 
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	public ByteArrayInputStream load() {
	    List<ProductList> pl = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(pl);
	    return in;
	  }

	  public List<ProductList> getAllLists() {
	    return repository.findAll();
	  }
	}

