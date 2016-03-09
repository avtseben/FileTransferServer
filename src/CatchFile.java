import java.io.*;

public class CatchFile {

private InputStream inStream; //inputstream it just bytes
private OutputStream outStream; //inputstream it just bytes
private String fileName;
    
    CatchFile (InputStream _inStream, OutputStream _outStream) {
	fileName = new String();
	inStream = _inStream;
	outStream = _outStream;
    }
    public void transferManager() {
	try (
	     PrintWriter out = new PrintWriter(outStream, true);
	     BufferedReader in = new BufferedReader(
		   new InputStreamReader(inStream));
		       
	) {
	    out.println("sayFileName");
	    if(in.readLine().equals("fileNameIs")) 
		//fileName = "file";
		fileName = in.readLine();
	    out.println("youCanStartTransfer");
	    writeToFileFromSocket(in); 
	} catch (IOException e) {
	    System.err.println(e);	
	}
    }

   public void writeToFileFromSocket(BufferedReader _in) {
    try (
	    PrintWriter outFile = new PrintWriter(
		new BufferedWriter(
	            new FileWriter(fileName)), true);//AutoFlush
	) {
	String inLine = new String();
	while(true) {
	    if((inLine = _in.readLine()) == null) break;
	    outFile.println(inLine);
	}
    } catch (IOException e) {}
   }
}
