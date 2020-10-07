package com.cyoung90.bookcase.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KakaoAPI {
	private static String KAKAO_APP_KEY = "KakaoAK f8e150f7de34021bb2884d5fac9e3d3f";
	private static String KAKAO_API_BOOK_URL = "https://dapi.kakao.com/v3/search/book?query=";

	private RestTemplateService<Object> restTemplateService;
	 
    @Autowired
    public void RestTemplateTestService(RestTemplateService<Object> apiService) {
        this.restTemplateService = apiService;
    }
    
    @GetMapping("/kakao/books")
	public ResponseEntity<?> searchBook(
			@RequestParam("title") String title
			, @RequestParam(value="page", defaultValue = "1") int page
			, @RequestParam(value="size", defaultValue = "12") int size) {
    	HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", KAKAO_APP_KEY);
		String url = KAKAO_API_BOOK_URL + title 
				+ "&page=" + page
				+ "&size=" + size;
		return ResponseEntity.ok(restTemplateService.get(url, headers, Object.class).getBody());
	}
    
}
