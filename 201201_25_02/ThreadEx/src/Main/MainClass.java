package Main;

public class MainClass {

	public static void main(String[] args) {
		
		Thread thread1 = new ThreadEx("퐁"); //생성하는것이 아니고 빌려오는 것
		Thread thread2 = new ThreadEx("당");
		Thread thread3 = new ThreadEx("!!");
		
		//멀티스레드는 동시다발로 실행함 - 공평하게 세번씩 출력됨
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("프로그램 종료");
	}

}
