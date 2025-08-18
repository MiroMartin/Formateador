package miromartin.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {
	JButton button;
	JButton button2;
	JButton button3;

	JTextField txt1;
	JTextField txt2;

	public Ventana() {
		super();
		setSize(210, 300);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		addComponent();
	}

	public void addComponent() {

		button = new JButton("Elija el video");
		button.setBounds(30, 30, 150, 30);
		add(button);
		button.addActionListener(this);

		button2 = new JButton("formato elegido");
		button2.setBounds(30, 110, 150, 30);
		add(button2);
		button2.addActionListener(this);

		button3 = new JButton("Formatear");
		button3.setBounds(30, 200, 150, 30);
		add(button3);
		button3.addActionListener(this);

		txt1 = new JTextField();
		txt1.setBounds(30, 65, 150, 30);
		add(txt1);

		txt2 = new JTextField();
		txt2.setBounds(30, 145, 150, 30);
		add(txt2);

	}

	public String elegirVideo() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Elija el video");

		int userSelection = fileChooser.showOpenDialog(button);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Video seleccionado: " + selectedFile.getAbsolutePath());
			return selectedFile.toString();
		}
		return null;
	}

	public String elegirFormato() {
		String format = JOptionPane.showInputDialog("Ingrese el nuevo nombre del video con el formato deseado");
		System.out.println("Nuevo nombre y formato seleccionado");
		return format;
	}

	public void formatearVideo() {

		String osName = System.getProperty("os.name").toLowerCase();

		if (osName.contains("win")) {
			try {
				ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "ffmpeg", "-i", txt1.getText(),
						txt2.getText());
				Path path = Paths.get(txt1.getText());
				String directorio = path.getParent().toString();
				System.out.println(directorio);
				processBuilder.directory(new File(directorio));
				Process process = processBuilder.start();

				process.waitFor();
				System.out.println("Comando ejecutado exitosamente");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
			try {
				ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i", txt1.getText(), txt2.getText());
				Path path = Paths.get(txt1.getText());
				String directorio = path.getParent().toString();
				System.out.println(directorio);
				processBuilder.directory(new File(directorio));
				Process process = processBuilder.start();

				process.waitFor();
				System.out.println("Comando ejecutado exitosamente");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			txt1.setText(elegirVideo());
		} else if (e.getSource() == button2) {
			txt2.setText(elegirFormato());
		} else if (e.getSource() == button3) {
			formatearVideo();
		}
	}

}
