package write;

public abstract class Writer {
	
	public abstract void write();
	//미리 추상만 해놓고 상속해서 상속받은 클래스에서 override해서 처리해줌
	//어떻게 작성할지 나중에 결정할때 사용됨
	
	public void erase() {
		System.out.println("기록을 지웁니다.");
	}
	
}
