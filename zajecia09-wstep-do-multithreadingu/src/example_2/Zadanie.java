package example_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Zadanie {
	/*
	 * Stworz klase FileFinder ktora bedzie jako argument pobierala sciezke do folderu z projektami eclipse
	 * zadaniem klasy bedzie wyszukanie wszystkich plikow java w podanej sciezkce
	 * i wypisanie ich na konsole.
	 * 
	 */

	private static List<String> filesList = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		FileFinder ff = new FileFinder("E:\\Eclipse_workspace\\EE", "java");
		ff.start();
		ff.join();
		VoidFinder vf = new VoidFinder(filesList);
		vf.start();
		//drugi watek odpala sie kiedy ff sie skonczy
		//kiedy wszystkie ff sie skoncza 
	}

	public static class FileFinder extends Thread {
		private final String path;
		private final String ext;

		public FileFinder(String path, String ext) {
			this.path = path;
			this.ext = ext;
		}

		private static void getFilesRecursive(File pFile, String ext) {
			for (File files : pFile.listFiles()) {
				if (files.isDirectory()) {
					getFilesRecursive(files, ext);
				} else {
					if (files.getAbsolutePath().endsWith(ext)) {
						filesList.add(files.getAbsolutePath());
						//System.out.println(files);
					}
				}
			}
		}

		@Override
		public void run() {
			File root = new File(path);
			for (File file : root.listFiles()) {
				getFilesRecursive(file, ext);
			}
		}
	}

	public static class VoidFinder extends Thread {
		private final String SEARCHTEXT = "public static void main";
		private List<String> files = new ArrayList<>();

		public VoidFinder(List<String> files) {
			this.files = files;
		}

		@Override
		public void run() {
			Boolean searchText;
			for (String file : files) {
				searchText = false;
				try (BufferedReader in = new BufferedReader(new FileReader(file))) {
					String line = null;
					while ((line = in.readLine()) != null) {
						if (line.contains(SEARCHTEXT)) {
							searchText = true;
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (searchText) {
					System.out.println(file);
				}
			}
		}

	}

}
