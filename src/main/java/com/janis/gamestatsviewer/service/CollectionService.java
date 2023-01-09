package com.janis.gamestatsviewer.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.Table;

@Service
public interface CollectionService {

	void getNewestFile() throws IOException;

	Table sortData();
}
