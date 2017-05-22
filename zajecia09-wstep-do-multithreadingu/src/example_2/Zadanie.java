package example_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Zadanie {
	/*
	 * Stworz klase FileFinder ktora bedzie jako argument pobierala sciezke do folderu z projektami eclipse
	 * zadaniem klasy bedzie wyszukanie wszystkich plikow java w podanej sciezkce
	 * i wypisanie ich na konsole.
	 * 
	 */

	//private static List<String> filesList = new ArrayList<>();
	private static BlockingQueue<String> filesList = new LinkedBlockingQueue<>();

	public static void main(String[] args) throws InterruptedException {
		FileFinder ff = new FileFinder("E:\\Eclipse_workspace\\EE\\", "java", filesList);
		ff.start();
		//ff.join();
		VoidFinder vf = new VoidFinder(filesList);
		vf.start();
		//drugi watek odpala sie kiedy ff sie skonczy
		//kiedy wszystkie ff sie skoncza 
	}

	public static class FileFinder extends Thread {
		private final String path;
		private final String ext;
		private BlockingQueue<String> filesList;

		public FileFinder(String path, String ext, BlockingQueue<String> filesList) {
			this.path = path;
			this.ext = ext;
			this.filesList = filesList;
		}

		private void getFilesRecursive(File pFile, String ext) {
			for (File files : pFile.listFiles()) {
				if (files.isDirectory()) {
					getFilesRecursive(files, ext);
				} else {
					if (files.getAbsolutePath().endsWith(ext)) {
						try {
							filesList.put(files.getAbsolutePath());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
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
		private final String SEARCHTEXT = "String";
		private BlockingQueue<String> filesList;
			
		public VoidFinder(BlockingQueue<String> filesList) {
			this.filesList = filesList;
		}

		@Override
		public void run() {
			Boolean searchText;
			for (String file : filesList) {
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
