package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage, endPage;
	private boolean prev,next;
	
	private int total;
	private Criterial cri;
	
	public PageDTO(Criterial cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
	    // 현재 페이지와 항목 수를 기반으로 endPage 계산
	    this.endPage = (int)(Math.ceil(cri.getPageNum() / (double) cri.getAmount()) * cri.getAmount());
	    startPage = this.endPage - 9;

	    // 실제 마지막 페이지 번호 계산
	    int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
	    
	    // 실제 마지막 페이지가 endPage보다 작으면 endPage를 수정
	    if (realEnd < endPage) {
	        this.endPage = realEnd;
	    }
	    
	    // 이전 페이지 버튼 활성화 여부
	    this.prev = startPage > 1;
	    // 다음 페이지 버튼 활성화 여부
	    this.next = this.endPage < realEnd;
	}
}
