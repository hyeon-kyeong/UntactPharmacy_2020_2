package controller.pharmacy;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import pharmacyAPI.pharmacyParsing;
import model.PharmacyDTO;

public class SearchPharmacyController implements Controller {

	ArrayList<PharmacyDTO> pharmacy_list = new ArrayList<PharmacyDTO>();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		try {
			pharmacy_list = pharmacyParsing.find(province, city);
			request.setAttribute("pharmacy_list", pharmacy_list);
	        return "/pharmacy/searchForm.jsp";	// 성공 시 SearchForm.jsp로 forwarding
	        
		} catch (Exception e) {		// 예외 발생 
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			return "/pharmacy/createForm.jsp";
		}
		
	}

}
