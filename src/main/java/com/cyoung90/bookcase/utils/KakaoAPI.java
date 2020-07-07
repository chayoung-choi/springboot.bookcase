package com.cyoung90.bookcase.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Service
@RestController
public class KakaoAPI {
	private static String KAKAO_APP_KEY = "KakaoAK f8e150f7de34021bb2884d5fac9e3d3f";

	@GetMapping("/testCall/{text}")
	public String searchBook(@PathVariable("text") String searchText) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", KAKAO_APP_KEY);
		
		System.out.println("KAKAO_APP_KEY > " + KAKAO_APP_KEY);
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		RestTemplate template = new RestTemplate();
//		String response = template.getForObject("https://dapi.kakao.com/v3/search/book?query={searchText}",
//				String.class, searchText);
		String url = "https://dapi.kakao.com/v3/search/book?query=" + searchText;
		ResponseEntity<String> res = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
		System.out.println(res);
		System.out.println(res.getBody());
		return res.getBody();
	}
	
//	public static String search(String whereRest, String searchValue, int page, int size) throws IOException {
//		String encodeValue = URLEncoder.encode(searchValue,"UTF-8");
//		
//		String requestURL = "https://dapi.kakao.com/v2/search/"+ whereRest +"?page="+page+"&size="+size+"&query=" + encodeValue;
//		URL url = new URL(requestURL);
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.addRequestProperty("Authorization", "KakaoAK " + "KaKaoRestKey");
//		con.setRequestProperty("X-Requested-With", "curl");
//		con.setRequestMethod("GET");
//		
//		InputStream in = con.getInputStream();
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//			byte[] buf = new byte[1024 * 8];
//			int length = 0;
//			while ((length = in.read(buf)) != -1) {
//				out.write(buf, 0, length);
//		}
//		String searchJson = new String(out.toByteArray(), "UTF-8");	
//		
//		con.disconnect();
//
//		return searchJson;
//	}

}
