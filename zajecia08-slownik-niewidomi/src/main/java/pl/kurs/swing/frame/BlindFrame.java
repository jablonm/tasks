package pl.kurs.swing.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlindFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	Map<String,Character> keysValue = new HashMap<String,Character>();

	public String checkValue(Set<Character> keys) {
		String value = "";
		for (Character character : keys) {
			if (keysValue.containsKey(character)) {
				value += keysValue.get(character);
			}
		}
		return value;
	}
	
	public BlindFrame() {

		Set<Character> keys = new TreeSet<>();
		Set<Character> keysFinal = new TreeSet<>();
		keysValue.put("s", 'a');
		keysValue.put("ds", 'b');
		keysValue.put("js", 'c');
		keysValue.put("jks", 'd');
		keysValue.put("ks", 'e');
		keysValue.put("djs", 'f');
		keysValue.put("djks", 'g');
		keysValue.put("dks", 'h');
		keysValue.put("dj", 'i');
		keysValue.put("djk", 'j');
		keysValue.put("fs", 'k');
		keysValue.put("dfs", 'l');
		keysValue.put("jfs", 'm');
		keysValue.put("fjks", 'n');
		keysValue.put("fks", 'o');
		keysValue.put("dfjs", 'p');
		keysValue.put("dfjks", 'q');
		keysValue.put("dfks", 'r');
		keysValue.put("dfj", 's');
		keysValue.put("dfjk", 't');
		keysValue.put("fls", 'u');
		keysValue.put("dfls", 'v');
		keysValue.put("djkl", 'w');
		keysValue.put("fjls", 'x');
		keysValue.put("fjkls", 'y');
		keysValue.put("fkls", 'z');
		
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
			@Override
			public void keyReleased(KeyEvent e) {
				if (keys.contains(e.getKeyChar())) {
					keys.remove(e.getKeyChar());
					System.out.println("puszczono: " + e.getKeyChar());
				}
				if (keys.isEmpty()) {
					System.out.println(checkValue(keysFinal));
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
				area.setText(area.getText()+e.getKeyChar());
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new BlindFrame());
	}

}
