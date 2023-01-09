package com.janis.gamestatsviewer.service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.Table;

@Service
public class CollectionServiceImpl implements CollectionService {

	private final FilesStorageService filesService;
	private Path csv;

	public CollectionServiceImpl(FilesStorageService filesService) {
		this.filesService = filesService;
	}

	@PostConstruct
	public void applyNewestPath() {
		try {
			getNewestFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void getNewestFile() throws IOException {
		this.csv = filesService.findNewest();
	}

	@Override
	public Table sortData() {
		Table csv1 = Table.read().csv(this.csv.toFile());
		csv1.rejectColumns("numplays", "weight", "own", "fortrade", "want", "wanttobuy",
			"wanttoplay", "prevowned", "preordered", "wishlist", "wishlistpriority",
			"wishlistcomment",
			"conditiontext", "haspartslist", "wantpartslist", "collid", "objecttype", "publisherid",
			"imageid", "year", "language", "other", "barcode", "pricepaid", "pp_currency",
			"currvalue",
			"cv_currency", "acquisitiondate", "acquiredfrom", "quantity", "privatecomment",
			"invlocation", "invdate", "version_languages", "version_yearpublished",
			"version_nickname");
		return csv1;
	}
}
