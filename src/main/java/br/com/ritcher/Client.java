package br.com.ritcher;

import br.com.ritcher.ui.AppFrame;
import br.com.ritcher.ui.BottomPanel;
import br.com.ritcher.ui.Menu;
import br.com.ritcher.ui.MessageLinkFocusHandler;
import br.com.ritcher.ui.MessagesFrame;
import br.com.ritcher.ui.SplitPane;

public class Client {

	public static void main(String args[]) {
		new Client().run();
	}

	private void run() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				//Metal
				//GTK3+
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				}
			}
		} catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}

		PanelFactory panelFactory = new PanelFactory();
		Content content = new SplitPane();

		SearchProviderImpl impl = new SearchProviderImpl(panelFactory, content);


		java.awt.EventQueue.invokeLater(() -> 
			{
				MessageLinkFocusHandler linkFocusHandler = new MessageLinkFocusHandler(content, panelFactory, impl);
				AppFrame frame = new AppFrame(content, new Menu(content, panelFactory, impl), new BottomPanel(new MessagesFrame(linkFocusHandler), linkFocusHandler));
				frame.setVisible(true);
				frame.toFront();
				frame.requestFocus();
				return;
			});
	}
}
