import java.io.File;


public class log_analyzer 
{
	public static String LOGS = "./logs/";
	public static int question;

	
	public static void main(String[] args) 
	{
		try{
			if(!args[0].equals("-q")){
				System.out.println("Invalid argument. Expected -q...");
			}
			question = Integer.parseInt(args[1]);
		} catch(Exception e){
			System.out.println("Insufficient arguments!");
		}
		if(args.length < 3){
			System.out.println("Insufficient arguments!");
		}		
		readFileFromArgs(args);
		
	}	
	
	public static void readFileFromArgs(String [] args){
		File source;
		for(int i = 2; i < args.length;i++){
			source = new File(LOGS + args[i]);
			if(source.exists() && source.isDirectory()){
				readFilesForFolder(source);
			}
		}
	}	
	public static void readFilesForFolder(final File source) {
	    for (final File fileEntry : source.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	readFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

}
