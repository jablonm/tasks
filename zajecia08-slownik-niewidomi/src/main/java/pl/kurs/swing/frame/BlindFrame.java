package pl.kurs.swing.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlindFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public BlindFrame() {
		LettersDirectory directory = new LettersDirectory();
		directory.generateBlindDirectory();

		Set<Character> keys = new TreeSet<>();
		Set<Character> keysFinal = new TreeSet<>();

		JPanel main = new JPanel(new BorderLayout());

		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setFocusable(false);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(500, 300));
		main.add(scroll, BorderLayout.CENTER);

		JPanel dictionaryPanel = new JPanel(new BorderLayout());
		dictionaryPanel.setPreferredSize(new Dimension(500, 100));
		dictionaryPanel.setFocusable(true);
		main.add(dictionaryPanel, BorderLayout.SOUTH);

		add(main);
		pack();
		setFocusable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		dictionaryPanel.addKeyListener(new KeyAdapter() {
			String writing = "";

			@Override
			public void keyReleased(KeyEvent e) {
				if (keys.contains(e.getKeyChar())) {
					keys.remove(e.getKeyChar());
					System.out.println("puszczono: " + e.getKeyChar());
				}
				if (keys.isEmpty()) {
					Optional<Character> letter = directory.findLetter(keysFinal);
					if (letter.isPresent()) {
						if (letter.get().equals('-')) {
							if (writing.length() > 0) {
								writing = writing.substring(0, writing.length() - 1);
							}
						} else {
							writing += letter.get().toString();
						}
					} else {
						java.awt.Toolkit.getDefaultToolkit().beep();
					}
					area.setText(writing);
					keysFinal.clear();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!keys.contains(e.getKeyChar())) {
					keys.add(e.getKeyChar());
					keysFinal.add(e.getKeyChar());
					System.out.println("wcisnieto: " + e.getKeyChar());
				}
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new BlindFrame());
	}

}
