package aplicacao;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Arquivo {
private String path;
	public Arquivo() {
		
	}
	public String selecionarArquivo(int tipo){
		JFileChooser jfc = new JFileChooser("/home");
		FileNameExtensionFilter hex = new FileNameExtensionFilter("Arquivo hex", "hex");
		FileNameExtensionFilter eep = new FileNameExtensionFilter("Arquivo eep", "eep");
		jfc.addChoosableFileFilter(hex);
		jfc.addChoosableFileFilter(eep);
		switch (tipo) {
		case 1:
		{
			jfc.setFileFilter(hex);
			break;
		}
		case 2:
		{
			jfc.setFileFilter(eep);
			break;
		}
		}
			
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			path = selectedFile.getAbsolutePath();
			
			
			//System.out.println(selectedFile.getAbsolutePath());
		}else if (returnValue == JFileChooser.CANCEL_OPTION) {
		    
		    path="";
		}
		jfc.setVisible(false);
		return path;
	}
}
