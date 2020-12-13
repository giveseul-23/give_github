package Main;

public class ThreadEx extends Thread{
	
	String msg;
	
	public ThreadEx(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		super.run();
		
		//for for for 
		for (int i = 0; i < 10; i++) {
			System.out.println(msg);	//1초당 한 번씩 출력됨
			
			try {
				Thread.sleep(1000);		//.sleep(초) 정해진 초(seconds)만큼 돌아감
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
