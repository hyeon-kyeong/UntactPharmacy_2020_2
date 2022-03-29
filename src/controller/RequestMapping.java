package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.medicine.*;
import controller.post.*;
import controller.reservation.*;
import controller.user.*;
import controller.pharmacy.*;
import controller.user.LoginController;
import controller.user.LogoutController;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		// 각 uri에 대응되는 controller 객체를 생성 및 저장\

		///////////////////////////////
		mappings.put("/admin/login/form", new ForwardController("/admin/loginForm.jsp"));
		mappings.put("/admin/list", new AdminListUserController());
		mappings.put("/admin/login", new AdminLoginController());
		mappings.put("/admin/view", new AdminViewUserController());
		mappings.put("/admin/register/form", new ForwardController("/admin/registerForm.jsp"));
		mappings.put("/admin/registerUser", new AdminRegisterUserController());

		
		mappings.put("/search", new ForwardController("/search/medSearchForm.jsp"));
		mappings.put("/search/list", new SearchMedicineController());
		mappings.put("/search/symptomList", new SearchMedicineBySymptomController());
		
		
		mappings.put("/medicine/admin/list", new ListAdminMedicineController());
		mappings.put("/medicine/list", new ListMedicineController());
		mappings.put("/medicine/register/form", new ForwardController("/medicine/registerForm.jsp"));
		mappings.put("/medicine/update/form", new ForwardController("/medicine/updateForm.jsp"));
		mappings.put("/medicine/register", new RegisterMedicineController());
		mappings.put("/medicine/update", new UpdateMedicineController());
		mappings.put("/medicine/quantity/update", new UpdateMedicineQuantityController());
		mappings.put("/medicine/view", new ViewMedicineController());
		mappings.put("/medicine/delete", new DeleteMedicineController());
		mappings.put("/medicine/view/detail", new DetailViewMedicineController());
		

		mappings.put("/post/list", new ListPostController());
		mappings.put("/post/listMyPost", new ListMyPostController());
        mappings.put("/post/create/form", new ForwardController("/post/creationForm.jsp"));
        mappings.put("/post/update/form", new ForwardController("/post/updateForm.jsp"));
        mappings.put("/post/create", new CreatePostController());
        mappings.put("/post/update", new UpdatePostController());
        mappings.put("/post/delete", new DeletePostController());
        mappings.put("/post/view", new ViewPostController());
        
        mappings.put("/reservation/list", new ListReservationController());
        mappings.put("/reservation/create/form", new CreateFormReservationController());
        mappings.put("/reservation/listMyReservation", new ListMyReservationController());
   //     mappings.put("/reservation/create/form", new ForwardController("/reservation/creationForm.jsp"));
        mappings.put("/reservation/create", new CreateReservationController());
        mappings.put("/reservation/view", new ViewReservationController());
        mappings.put("/reservation/update", new UpdateReservationController());
        mappings.put("/reservation/delete", new DeleteReservationController());
        
        
        mappings.put("/pharmacy/search", new SearchPharmacyController());
        mappings.put("/pharmacy/search/form", new ForwardController("/pharmacy/searchForm.jsp"));
        mappings.put("/pharmacy/register", new CreatePharmacyController());
        mappings.put("/pharmacy/search", new SearchPharmacyController());
        mappings.put("/pharmacy/delete", new DeletePharmacyController());
        mappings.put("/pharmacy/list", new ListPharmacyController());
        mappings.put("/pharmacy/view", new ViewPharmacyController());
        mappings.put("/pharmacy/create/form", new ForwardController("/pharmacy/createForm.jsp"));
        mappings.put("/pharmacy/view/create", new ViewCreatePharmacyController());
        
		mappings.put("/", new ForwardController("index.jsp"));
		mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
		mappings.put("/user/login", new LoginController());
		mappings.put("/user/logout", new LogoutController());
		mappings.put("/user/list", new ListUserController());
		mappings.put("/user/view", new ViewUserController());
		mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
		mappings.put("/user/register", new RegisterUserController());

		// 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
		//      mappings.put("/user/update/form", new UpdateUserFormController());
		mappings.put("/user/update/form", new UpdateUserController());
		mappings.put("/user/update", new UpdateUserController());
		mappings.put("/user/update/admin/form", new UpdateUserAdminController());
		mappings.put("/user/update/admin", new UpdateUserAdminController());
		mappings.put("/user/delete", new DeleteUserController());
		mappings.put("/user/mypage", new MypageController());

		logger.info("Initialized Request Mapping!");




	}

	public Controller findController(String uri) {	
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}
