package cls;

public class myTv2 {
	
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel; //이전채널저장공간
	
	public myTv2() {
	}

	public boolean isPowerOn() {
		return isPowerOn;
	}

	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		prevChannel = this.channel; //기존 셋팅 채널 저장, 10
		this.channel = channel;	//20
		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
	}
	
}
