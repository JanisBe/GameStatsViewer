package com.janis.gamestatsviewer.service;

import java.io.IOException;
import tech.tablesaw.api.Table;


public interface CollectionService {

	void getNewestFile() throws IOException;

	Table sortData();
}
