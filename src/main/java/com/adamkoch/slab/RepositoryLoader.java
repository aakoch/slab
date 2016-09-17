package com.adamkoch.slab;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Created by aakoch on 9/11/16.
 */
public class RepositoryLoader {

    private static File defaultRepoFile = new File("repo.slab");

    public static Repository loadDefault() {
        try {
            return load(defaultRepoFile);
        } catch (IOException e) {
            throw new RuntimeException("Could not open default repo: " + e.getMessage(), e);
        }
    }

    public static Repository load(File file) throws IOException {
        try (FileInputStream fileInputStream = FileUtils.openInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Repository repository = (Repository) objectInputStream.readObject();
            return repository;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not load repo: " + e.getMessage(), e);
        }
    }

    public static void save(Repository repository, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(repository);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not save repo: " + e.getMessage(), e);
        }
    }

    static void init() {
        save(new InMemoryRepository(), defaultRepoFile);
    }

}
