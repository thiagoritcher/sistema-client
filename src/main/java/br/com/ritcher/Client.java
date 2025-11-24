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

		SearchProviderImpl impl = new SearchProviderImpl();
		Content content = new Content(new PanelFactory(impl));

		java.awt.EventQueue.invokeLater(() -> 
			new AppFrame(content, new Menu(content)).setVisible(true));
	}
}
