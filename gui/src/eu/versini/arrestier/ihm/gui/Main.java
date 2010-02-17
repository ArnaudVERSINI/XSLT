package eu.versini.arrestier.ihm.gui;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class Main {
	static {
		try {
			for (final LookAndFeelInfo info :
				UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		JFrame frame2 = new JFramePrincipale();
		frame2.pack();
		frame2.setVisible(true);
	}
}
