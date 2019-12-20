package fil.coo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import plugin.Plugin;

public class PluginMenuItem extends JMenuItem {

	public class ContentTransformer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			editor.setText(plugin.transform(editor.getText()));
		}

	}

	private static final long serialVersionUID = 7300623070280311525L;
	
	private Plugin plugin;
	
	private Editor editor;
	
	private ContentTransformer contentTransformer;

	public PluginMenuItem(Plugin plugin, Editor editor) {
		super(plugin.getLabel());
		this.editor = editor;
		this.plugin = plugin;
		this.contentTransformer = new ContentTransformer();
		this.addActionListener(contentTransformer);
	}
	

	

}
