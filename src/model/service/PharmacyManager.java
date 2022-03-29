package model.service;

import java.sql.SQLException;
import java.util.List;

import model.PharmacyDTO;
import model.dao.PharmacyDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class PharmacyManager {
	private static PharmacyManager pharmacymanager = new PharmacyManager();
	private PharmacyDAO pharmacyDAO;
	private PharmacyManager() {
		try {
			pharmacyDAO = new PharmacyDAO();
			new PharmacyAnalysis(pharmacyDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static PharmacyManager getInstance() {
		return pharmacymanager;
	}
	
	public PharmacyDTO findPharmacy(String pharm_name)
			throws SQLException, PharmacyNotFoundException {
			PharmacyDTO pharmacy = PharmacyDAO.findPharmacy(pharm_name);
			
			if (pharmacy == null) {
				throw new PharmacyNotFoundException(pharm_name + "은/는 존재하지 않는 약국 이름입니다.");
			}		
			return pharmacy;
		}
	
	public PharmacyDTO createPharmacy(PharmacyDTO pharmacy) throws SQLException, ExistingPharmacyException {
		if (pharmacyDAO.existingPharmacyByPharm_name(pharmacy.getPharm_name()) == true) {
			throw new ExistingPharmacyException(pharmacy.getPharm_name() + "은/는 존재하는 약국 이름입니다.");
		}
		return pharmacyDAO.create(pharmacy);
	}

	public int remove(String delete_id) throws SQLException {
		return PharmacyDAO.remove(delete_id);	
	}
	
	public List<PharmacyDTO> findPharmacyList() throws SQLException {
		return PharmacyDAO.findPharmacyList();
	}

}
