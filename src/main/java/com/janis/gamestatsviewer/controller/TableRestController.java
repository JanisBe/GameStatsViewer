package com.janis.gamestatsviewer.controller;

import com.janis.gamestatsviewer.service.CollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.tablesaw.api.Table;

public class TableRestController {

	private final CollectionService collectionService;

	public TableRestController(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	@GetMapping("/collection")
	public ResponseEntity<Object> getListFiles() {
		Table table = collectionService.sortData();
		table.shape();
		return ResponseEntity.status(HttpStatus.OK).body(table.first(3).print());
	}

}
