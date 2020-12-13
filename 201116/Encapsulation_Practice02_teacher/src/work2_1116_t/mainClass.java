package work2_1116_t;

import cls.myTv2;

public class mainClass {

	public static void main(String[] args) {
		
		myTv2 t = new myTv2();
		/*01
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());
		*/
		
		//02
		t.setChannel(10);	//prevChannel == 0	channel == 10
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);	//prevChannel == 10	channel == 20
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel(); 	//prevChannel == 20	channel == 10
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();	//prevChannel == 10	channel == 20
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		
	}

}
