package pl.kurs.spring.painter.impl;

import org.springframework.stereotype.Service;

@Service
public class SquarePainterDefaultImpl extends SquarePainterImpl {
	@Override
	public void print() {
		super.print(10);
	}

}
