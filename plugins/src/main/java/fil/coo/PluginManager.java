package fil.coo;

import java.util.HashMap;

import javax.swing.JMenu;

import plugin.Plugin;

public class PluginManager implements FileListener {
	
	private JMenu menu;
	
	private Editor editor;
	
	private HashMap<String, PluginMenuItem> filenameMenuItemMap;

	public PluginManager(JMenu menu, FileChecker fileChecker,Editor editor) {
		this.menu = menu;
		this.filenameMenuItemMap = new HashMap<String, PluginMenuItem>();
		this.editor = editor;
		fileChecker.addFileListener(this);
		// If the file checker is launched from the start we might miss the first files
		fileChecker.startChecking();
		
	}

	@Override
	public void fileAdded(FileEvent event) {
		PluginMenuItem pluginItem = fileToPluginMenuItem(event.getFileName());
		this.filenameMenuItemMap.put(event.getFileName(), pluginItem);
		this.menu.add(pluginItem);
	}

	@Override
	public void fileRemoved(FileEvent event) {
		PluginMenuItem pluginItem = this.filenameMenuItemMap.get(event.getFileName());
		this.menu.remove(pluginItem);
	}
	
	public PluginMenuItem fileToPluginMenuItem(String filename) {
		Class<?> pluginClass;
		Plugin plugin = null;
		PluginMenuItem pluginMenuItem = null;
		try {
			String filename2 = filename.replaceAll(".class", "");
			pluginClass = Class.forName("plugin."+filename2);
			//if(pluginClass.isAssignableFrom(Plugin.class)) {
				plugin = (Plugin) pluginClass.getConstructor().newInstance();
				pluginMenuItem = new PluginMenuItem(plugin, this.editor);
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return pluginMenuItem;
	}

}
