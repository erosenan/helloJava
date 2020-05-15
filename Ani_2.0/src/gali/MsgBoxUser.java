package gali;

import javax.swing.JOptionPane;

public class MsgBoxUser implements IUser {

	@Override
	public boolean askb(String string) {
		int ret = JOptionPane.showConfirmDialog(null, string);
		return ret == JOptionPane.YES_OPTION;
	}

	@Override
	public void print(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

}
