package Frame;

import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextArea JArea;
	public Window() {
		super("Диспетчер потоков");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JArea = new JTextArea(20, 40);
		JArea.setLineWrap(true);
		JArea.setWrapStyleWord(true);
		JArea.setFont(new Font("Calibri", Font.PLAIN, 24));
		
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(JArea));
		setContentPane(panel);
		
		setSize(900,800);
		setLocation(650, 100);
		setVisible(true);
	}
	public void changeText(String text) {
		JArea.setText(text);
	}
}
