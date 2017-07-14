package pl.kurs.spring.painter.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.painter.painter.Painter;

@Service
public class SquarePainterImpl implements Painter {

	@Override
	public void print(int x) {
		for(int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print("o");
			}
			System.out.println();
		}
	}
	 
	
}
