package at.stringpaster;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;

public class mainScript {

	private static String password;
	private static Integer passCount = 0;
	
	public static void main(String[] args) {
		// Random String hotkey
		Provider provider = Provider.getCurrentProvider(false);
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomString(50));
						pasteFromClipboard();
					}
				});
		// Random Language hotkey
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomLanguage());
						pasteFromClipboard();
					}
				});
		// Random XSS hotkey
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomXss());
						pasteFromClipboard();
					}
				});

		// Random SQLi hotkey
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomSQL());
						pasteFromClipboard();
					}
				});
		// Exit hotkey
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						System.exit(0);
					}
				});
		// Name
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomName());
						pasteFromClipboard();
					}
				});
		// Family name
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomFamilyName());
						pasteFromClipboard();
					}
				});
		// E-mail
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						setClipboardContent(stringGenerator.getRandomEmail());
						pasteFromClipboard();
					}
				});
		// Password
		provider.register(
				KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK),
				new HotKeyListener() {
					public void onHotKey(HotKey hotKey) {
						if (passCount%2 != 0) {
							password = stringGenerator.getRandomPassword();
						}
						setClipboardContent(password);
						pasteFromClipboard();
						passCount++;
					}
				});
	}

	public static void pasteFromClipboard() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void setClipboardContent(String content) {
		StringSelection selection = new StringSelection(content);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}
}
