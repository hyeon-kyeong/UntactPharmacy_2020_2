package pharmacyAPI;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.PharmacyDTO;

public class pharmacyParsing implements Serializable{

	/* 공공데이타포털(http://www.data.go.kr) 오픈 API 이용
	 - 서비스명 : 전국 약국정보 조회 서비스
	 -province: 검색할 약국의 시/도
	 -city: 검색할 약국의 시/군/구
	 */
	private static String serviceKey = "dE0j11jK19PVLzsZ1FBtPxazd7LhfaO23MJ2f6HIg91ChowxCcaoPk%2FmkVsXctQ%2F5mFhGF1zzYizNt8XqTSBSA%3D%3D&Q0=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C";
	
	public static ArrayList<PharmacyDTO> find(String province, String city)
	{
		HttpURLConnection con = null;
		PharmacyDTO pharm = new PharmacyDTO();
		ArrayList<PharmacyDTO> pharmList = new ArrayList<PharmacyDTO>();

		try
		{
			URL url = new URL(
					"http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire"
							+ "?ServiceKey=" + serviceKey// API 서비스 인증 키
							+ "&Q0=" + URLEncoder.encode(province,"UTF-8") // 검색어(시,도)
							+ "&Q1=" + URLEncoder.encode(city, "UTF-8") // 검색어(시/군/구)
							+ "&numOfRows=20"// 페이지당 출력될 개수를 지정(임의로 20개로 정함)
					);

			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Accept-language", "ko");

			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = fac.newDocumentBuilder();
			Document doc = db.parse(con.getInputStream());

			Element el = doc.getDocumentElement();

			NodeList itemList = el.getElementsByTagName("item");

			for(int i = 0 ; i < itemList.getLength() ; i++){
				// <item> ~ </item> 노드를 하나씩 읽어옴
				Node itemNode = itemList.item(i);
				// <item> ~ </item> 사이의 태그들로 노드 리스트를 만듬
				NodeList subList = itemNode.getChildNodes();

				String address = "";
				String pharmName = "";

				// <item> ~ </item> 사이의 태그를 하나씩 읽어와 해당 태그와 일치할 경우 변수에 저장
				for(int j = 0 ; j < subList.getLength() ; j++){
					Node subNode = subList.item(j);
					if(subNode.getNodeName().equals("dutyAddr")) // 약국 주소
						address = subNode.getTextContent();
					if(subNode.getNodeName().equals("dutyName")) // 약국 이름
						pharmName = subNode.getTextContent();
				}
				pharm = new PharmacyDTO(pharmName, address);
				pharmList.add(pharm);
				System.out.println("약국 이름: " + pharm.getPharm_name());
				System.out.println("약국 주소: " + pharm.getPosition());
			
			}
			return pharmList;

		} catch(Exception e) {
			e.printStackTrace();
		}

		if (con != null) {
			con.disconnect();
		}
		
		return pharmList;
	}
}
