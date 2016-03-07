import java.io.*;

public class CatchFile {

    private InputStream inStream; //inputstream it just bytes
    private FileOutputStream fos;

    CatchFile (InputStream _inStream) {
	inStream = _inStream;
	try {
	    fos = new FileOutputStream("file");
	} catch (IOException e) {
	}

    }

   public void writeByChars() {
    try {
	char c;
	while(true) {
	    c = (char)inStream.read();
	    fos.write(c);
	    if(c == 'Q') break; //TODO get EOF 
	}
	fos.close();
    } catch (IOException e) {}
   }
}
