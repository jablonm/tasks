package pl.kurs.spring.painter.painter;

public interface Painter {
	void print(int x);
	default void print() {
	}
}
