package fil.coo;

import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Editor {

	private JFrame frame;
	private JEditorPane editor;
	private PluginManager pluginManager;
	private JMenu menu;
	private JMenuBar menuBar;

	public Editor(String defaultText, FileChecker fileChecker) {
		this.frame = new JFrame();
		this.frame.setTitle("Plugins");
		this.frame.setSize(600, 600);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.editor = new JEditorPane();
		this.editor.setText(defaultText);
		this.menu = new JMenu("Menu");
		this.menuBar = new JMenuBar();
		this.menuBar.add(this.menu);
		this.pluginManager = new PluginManager(this.menu, fileChecker, this);
		this.frame.setJMenuBar(menuBar);
		this.frame.add(editor, BorderLayout.CENTER);
		this.frame.setLocationRelativeTo(null);  
		this.frame.setVisible(true);
	}
	
	public void setText(String text) {
		this.editor.setText(text);
	}
	
	public String getText() {
		return this.editor.getText();
	}
	
	
	
}
