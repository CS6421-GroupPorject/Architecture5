package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class RomLoader {
	private ControlPanel mControlPanel;
	
	private boolean mStopFlag=false;
	
	/**
	 * boot reserved memory address 512 ~ 512+limit
	 */
	public static final int BOOT_ADD_LIMIT=512;
	private int InstructCount=0;
	
	
	
	/**
	 * constructor of the bootloader 
	 * @param processor 
	 */
	public RomLoader(ControlPanel mainPanel) {
		mControlPanel=mainPanel;
	}
	
	
	/**
	 * @return all read instruction count 
	 */
	public int getInstructCount() {
		return InstructCount;
	}

	/**
	 * reset bootloader 
	 * @param the file name boot from
	 */
	public void resetLoader(String bootFrom) {
		mStopFlag=false;
		mControlPanel.startRunning(bootFrom);
		InstructCount=0;
	}
	
	/**
	 * restarting , load all instructions from the virtual cardreader, which is a txt file specified
	 * after all instructions are load into the memory , tell the processor to execute them in order
	 * @param fileName or path
	 * @throws Exception :stop if errors are encountered reading all instructions into memory
	 */
	public void readCard(String pfilePath) throws Exception {
         
//        URL Url = getClass().getResource(sfilePath); 
//        String pfilePath = "/" + Url.getPath();
        
        InputStream stream  = ClassLoader.getSystemResourceAsStream(pfilePath);
                		
        InputStreamReader reader = new InputStreamReader(stream); 
               // new FileInputStream(pfilePath)); 
        BufferedReader br = new BufferedReader(reader);  
        String line = "";  
        line = br.readLine(); 
        resetLoader(pfilePath);
        while (line != null && !mStopFlag) { 
        	InstructCount++;
        	decodeInstruction(line);
                //ControlPanel.jMessages.append("Read instruction from file"+pfilePath+":"+line+"\n");
                line = br.readLine(); 
        }
        if (line==null) {
            if (mControlPanel.runType == 1) {
                        mControlPanel.programInstructionThread = new Instruction(mControlPanel);
                        mControlPanel.programInstructionThread.setPfileName(pfilePath);
			mControlPanel.programInstructionThread.start();
            }
            else{
                        mControlPanel.instructionThread = new Instruction(mControlPanel);
                        mControlPanel.instructionThread.setPfileName(pfilePath);
			mControlPanel.instructionThread.start();
            }
                       
		}
	}
	
	/**
	 * decode machine instructions to 20bits binary code
	 * @param a line in the txt file,which is the instruction to be decoded
	 */
	private void decodeInstruction(String pOneInst) {
		String binaryInst="";
		
                Decoder decoder = new Decoder();
//                
		binaryInst = decoder.toBinary(pOneInst);
//                
//              binaryInst = pOneInst;
        
                    
		if (binaryInst.isEmpty()) {
			stopRunning("Loading unknown Instruction..."+pOneInst);
			
		}
		//if the binary instuction are successfullly decoded ,then store/load it into the corresponding memory bank
		else {
			
			storeInstruction(binaryInst);
		}
		
	}
	
	/**
	 * store the current read instruction into the memory bank
	 * @param the binary instruction to be stored into the memory bank
	 */
	private void storeInstruction(String pBineryInst) {
		if (InstructCount>BOOT_ADD_LIMIT) {
			ControlPanel.jMessages.append("Too Many Instructions for this Program! Booting stopped.\n");
		}
		else {
			
			String sAddr;
			sAddr = Long.toBinaryString(512+InstructCount-1);
			sAddr = String.format("%0" + (20-sAddr.length())+ "d", 0) + sAddr;
			
			ControlPanel.MEMORY.setDirect(pBineryInst,sAddr);
		}
		
		
		
	}
	
	/**
	 * stop reading file and tell the processor to stop running
	 * @param stopping reason to display
	 * 
	 */
	public void stopRunning(String msg) {
		mControlPanel.stopRunning(msg);
		mStopFlag=true;
	}
	
	
		/**
		 * method to get num digits of binary string from a integer string with leading 0s
		 * @param num :number of digits need for the binary string
		 * @param val:original integer string without leading 0s
		 * @return num digits of binary string with necessary leading 0s 
		 */
		private String getBinaryStrfromIntString(int num,String val) {
			return String.format(
					"%"+num+"s",
					Integer.toBinaryString(Integer.parseInt(val))
					).replace(' ', '0');
		}
}
