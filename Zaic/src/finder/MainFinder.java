package finder;

import java.awt.EventQueue;

public class MainFinder {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{				
				FrameWindow frameWindow = new FrameWindow();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});

	}

}
