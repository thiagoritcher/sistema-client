package br.com.ritcher;

import br.com.ritcher.ui.AppFrame;
import br.com.ritcher.ui.Menu;

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
		Content content = new ContentImpl();

		SearchProviderImpl impl = new SearchProviderImpl(panelFactory, content);


		java.awt.EventQueue.invokeLater(() -> 
			new AppFrame(content, new Menu(content, panelFactory, impl)).setVisible(true));
	}
}
