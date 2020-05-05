package io.pivotal.example.clipper.clipperclient;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardUtil {

	public static void copyToClipboard(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	public static String getFromClipboard() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		DataFlavor dataFlavor = DataFlavor.stringFlavor;

		try {

			if (clipboard.isDataFlavorAvailable(dataFlavor)) {
				Object text;

				text = clipboard.getData(dataFlavor);

				return (String) text;
			}
		} catch (UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	

}
