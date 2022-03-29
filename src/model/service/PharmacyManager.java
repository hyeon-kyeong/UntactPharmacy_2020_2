package model.service;

import java.sql.SQLException;
import java.util.List;

import model.PharmacyDTO;
import model.dao.PharmacyDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
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
				throw new PharmacyNotFoundException(pharm_name + "��/�� �������� �ʴ� �౹ �̸��Դϴ�.");
			}		
			return pharmacy;
		}
	
	public PharmacyDTO createPharmacy(PharmacyDTO pharmacy) throws SQLException, ExistingPharmacyException {
		if (pharmacyDAO.existingPharmacyByPharm_name(pharmacy.getPharm_name()) == true) {
			throw new ExistingPharmacyException(pharmacy.getPharm_name() + "��/�� �����ϴ� �౹ �̸��Դϴ�.");
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
