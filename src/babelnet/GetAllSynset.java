package babelnet;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import it.uniroma1.lcl.babelnet.BabelNet;

public class GetAllSynset {

	public static void main(String[] args) {
		BabelNet bn = BabelNet.getInstance();
		String output_filename = "synset.txt";
		try
		{
			FileWriter filewriter = new FileWriter(output_filename);
			bn.offsetStream().forEach(offset->{
				try {
					filewriter.write(offset+"\n");
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			});
		}
		catch(FileNotFoundException ex)
       	{
			System.out.println("Unable to open file " + " or writing file"+ output_filename);
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file '" + " or writing file"+ output_filename);
			ex.printStackTrace();
		}

	}

}
