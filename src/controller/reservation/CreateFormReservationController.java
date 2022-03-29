package controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.medicine.UserSessionUtils;
import model.Medicine;
import model.PharmacyDTO;
import model.Reservation;
import model.service.MedicineManager;
import model.service.PharmacyManager;

public class CreateFormReservationController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       PharmacyManager pharmacyManager = PharmacyManager.getInstance();
       MedicineManager medicineManager = MedicineManager.getInstance();
       
      List<PharmacyDTO> pharmacy_list = pharmacyManager.findPharmacyList();
      
      List<Medicine> medicine_list = medicineManager.findMedicineList();
      
      Reservation reservation = new Reservation(
       0,
       request.getParameter("user_id"),
       request.getParameter("med_id"),
       request.getParameter("pharm_name"),
       request.getParameter("position"),
       request.getParameter("reserv_date"));
      
      request.setAttribute("pharmacy_list", pharmacy_list); // pharmacyList ��ü�� request�� �����Ͽ� Ŀ�´�Ƽ ����Ʈ ȭ������ �̵�(forwarding)   
      request.setAttribute("medicine_list",  medicine_list);
      
      request.setAttribute("curUserId", 
            UserSessionUtils.getLoginUserId(request.getSession()));      
      
      try {
         request.setAttribute("reservation", reservation);

           return "/reservation/creationForm.jsp";   // ���� �� Ŀ�´�Ƽ ����Ʈ ȭ������ redirect
           
      } catch (Exception e) {      // ���� �߻� �� �Է� form���� forwarding
           request.setAttribute("creationFailed", true);
         request.setAttribute("exception", e);
         return "redirect:/reservation/list";
      }
  
    }
}