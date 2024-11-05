package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
public class SampleHotel {
	
	
	private Chef chef;
	
	//ctrl + spacebar + enter 기본 생성자 단축키
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
	
}
