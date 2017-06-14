package maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LoadForMulti {
	private int [][] firstLayer , secondLayer;
	public LoadForMulti(){
		
		String filename;
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fileChooser.getSelectedFile();
			filename = selectedFile.getAbsolutePath();

			try
			{
				FileInputStream reader = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(reader);
				firstLayer = (int[][]) in.readObject();
				secondLayer = (int[][]) in.readObject();
				in.close();
				reader.close();
			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(null,"Not File Exist");
				System.out.println(e.getMessage());
			}
		}
	}   
	
	public int[][] getFirstLayer() {
		return firstLayer;
	}
	
	public int[][] getSecondLayer() {
		return secondLayer;
	}

}
