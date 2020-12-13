package baseballmain;

import baseballclass.baseballclass;

public class baseballmain {

	public static void main(String[] args) {
		int rArr[];
		boolean clear = false;
		boolean gamereplay = false;
		
		//클래스 선언
		baseballclass bs = new baseballclass();
		while(true) {
			bs.init();	//초기화
			rArr = bs.random();	//랜덤수 배열받기
			clear = bs.gameloop(rArr);	//게임루프 - 10번 , 유저값 입력, 판정결과
			bs.gameResult(clear);//게임 승패 여부 출력
			gamereplay = bs.replaygame();
			
			if(gamereplay == true) {
				System.out.println("화이팅하세요!");
				continue;
			}else if(gamereplay == false) {
				System.out.println("고생하셨습니다. 안녕히가세요~");
				break;
			}
		}
	}

}
