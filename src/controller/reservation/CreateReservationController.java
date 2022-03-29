package controller.reservation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.LineItem;
import model.Medicine;
import model.Reservation;
import model.service.MedicineManager;
import model.service.ReservationManager;

public class CreateReservationController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateReservationController.class);

	List<LineItem> lineitem_list = new ArrayList<LineItem>();
	LineItem lineitem;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
        Reservation reservation = new Reservation(
        	0,
        	request.getParameter("user_id"),
        	request.getParameter("med_id"),
        	request.getParameter("pharm_name"),
       		request.getParameter("reserv_date"),
       		request.getParameter("address"));
        
//        lineitem_list = request.getParameterValues("med_id");
        String[] checkbox = request.getParameterValues("med_id");
        String[] quantity = request.getParameterValues("quantity");
        String[] price = request.getParameterValues("price");
        ArrayList<Integer> qnt = new ArrayList<Integer>();
        
        for (int i = 0; i < quantity.length; i++) {
        	if(!quantity[i].isEmpty() || !quantity[i].contentEquals("")) {
        		qnt.add(Integer.parseInt(quantity[i]));
        		
        	}
        }
        System.out.println("xxxxxxxxxxxxxxxx");
        
        for (int i = 0; i < checkbox.length; i++) {
        	int qt = qnt.get(i);
        	int p = Integer.parseInt(price[i]);
        	lineitem = new LineItem(i+1, checkbox[i]);
			lineitem.setPrice(p);
			lineitem.setQuantity(qt);
			lineitem.setTotal_price(p*qt);
        	System.out.println(lineitem.getReserv_id());
        	lineitem_list.add(lineitem);
        	
        	String medId = checkbox[i];
        	MedicineManager medicineManager = MedicineManager.getInstance();
        	Medicine medicine = medicineManager.getMedicine(medId);
        	medicine.setQuantity(medicine.getQuantity() - qt);
			medicineManager.updateQuantity(medicine);
        	
        }
        
        reservation.setLineItems(lineitem_list);
        
		try {
			ReservationManager manager = ReservationManager.getInstance();
			manager.createReservation(reservation);

	    	log.debug("Create Reservation : {}", reservation);
	        return "redirect:/reservation/list";	// ���� �� Ŀ�´�Ƽ ����Ʈ ȭ������ redirect
	        
		} catch (Exception e) {		// ���� �߻� �� �Է� form���� forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("reserv", reservation);
			return "/reservation/createForm.jsp";
		}
    }
}

