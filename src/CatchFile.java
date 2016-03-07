import java.io.*;

public class CatchFile {

private InputStream inStream; //inputstream it just bytes
private FileOutputStream fos;
private boolean byteTransferMode = false;
private BufferedReader in;
private PrintWriter out;
private String file;
    
    CatchFile (InputStream _inStream) {
	file = "file";
	inStream = _inStream;
	try {
	    in = new BufferedReader(
        	new InputStreamReader(inStream));
	    out = new PrintWriter(
		new BufferedWriter(
	    new FileWriter(file)), true);//AutoFlush

    	    fos = new FileOutputStream(file);
	} catch (IOException e) {
	}

    }

   public void writeByChars() {
    try {
	char c;
	String inLine = new String();
	while(true) {
	    if(byteTransferMode) {
	    c = (char)inStream.read();
	    fos.write(c);
	    if(c == 'Q') break; //TODO get EOF 
	    } else {
		if((inLine = in.readLine()) == null) break;
		out.println(inLine);
	    }
	}
	out.close();
	fos.close();
    } catch (IOException e) {}
   }
}
