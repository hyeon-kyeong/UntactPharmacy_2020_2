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

	/* ��������Ÿ����(http://www.data.go.kr) ���� API �̿�
	 - ���񽺸� : ���� �౹���� ��ȸ ����
	 -province: �˻��� �౹�� ��/��
	 -city: �˻��� �౹�� ��/��/��
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
							+ "?ServiceKey=" + serviceKey// API ���� ���� Ű
							+ "&Q0=" + URLEncoder.encode(province,"UTF-8") // �˻���(��,��)
							+ "&Q1=" + URLEncoder.encode(city, "UTF-8") // �˻���(��/��/��)
							+ "&numOfRows=20"// �������� ��µ� ������ ����(���Ƿ� 20���� ����)
					);

			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Accept-language", "ko");

			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = fac.newDocumentBuilder();
			Document doc = db.parse(con.getInputStream());

			Element el = doc.getDocumentElement();

			NodeList itemList = el.getElementsByTagName("item");

			for(int i = 0 ; i < itemList.getLength() ; i++){
				// <item> ~ </item> ��带 �ϳ��� �о��
				Node itemNode = itemList.item(i);
				// <item> ~ </item> ������ �±׵�� ��� ����Ʈ�� ����
				NodeList subList = itemNode.getChildNodes();

				String address = "";
				String pharmName = "";

				// <item> ~ </item> ������ �±׸� �ϳ��� �о�� �ش� �±׿� ��ġ�� ��� ������ ����
				for(int j = 0 ; j < subList.getLength() ; j++){
					Node subNode = subList.item(j);
					if(subNode.getNodeName().equals("dutyAddr")) // �౹ �ּ�
						address = subNode.getTextContent();
					if(subNode.getNodeName().equals("dutyName")) // �౹ �̸�
						pharmName = subNode.getTextContent();
				}
				pharm = new PharmacyDTO(pharmName, address);
				pharmList.add(pharm);
				System.out.println("�౹ �̸�: " + pharm.getPharm_name());
				System.out.println("�౹ �ּ�: " + pharm.getPosition());
			
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
