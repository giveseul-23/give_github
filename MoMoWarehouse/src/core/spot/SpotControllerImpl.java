package core.spot;

import java.util.ArrayList;
import java.util.List;

public class SpotControllerImpl implements SpotController{

	@Override
	public void spotMenu() {
		System.out.println("spot menu 입니다. 원래는 view로 출력되야함");
	}

	@Override
	public List<Spot> findAll() {
		 List<Spot> list = new ArrayList<>();
		 
        list.add(new Spot(1, "비트보관소", "서울"));
        list.add(new Spot(2, "제주다락", "제주"));
        list.add(new Spot(3, "기브", "성북"));

	      return list;
	}
	
}
