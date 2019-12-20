package fil.coo;

import java.util.EventListener;

public interface FileListener extends EventListener {
	public abstract void fileAdded(FileEvent event);
	public abstract void fileRemoved(FileEvent event);
}
