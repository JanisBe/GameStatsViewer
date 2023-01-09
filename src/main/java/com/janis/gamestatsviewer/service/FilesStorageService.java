package com.janis.gamestatsviewer.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

	void deleteAll();

	Path findNewest() throws IOException;

	void init();

	Resource load(String filename);

	Stream<Path> loadAll();

	void save(MultipartFile file);
}
