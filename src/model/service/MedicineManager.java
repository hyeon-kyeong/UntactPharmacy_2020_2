package model.service;

import java.sql.SQLException;
import java.util.List;
import model.Medicine;
import model.dao.MedicineDAO;

public class MedicineManager {
	private static MedicineManager medicineManager = new MedicineManager();
	private MedicineDAO medicineDAO;
	private MedicineManager() {
		try {
			medicineDAO = new MedicineDAO();
			new MedicineAnalysis(medicineDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MedicineManager getInstance() {
		return medicineManager;
	}
	
	public Medicine create(Medicine medicine) throws SQLException, ExistingMedicineException, Exception {
		if (!medicineDAO.existingMedicine(medicine.getMed_id())) {
			throw new ExistingUserException(medicine.getMed_id() + "�� �̹� �߰��� ��ǰ�Դϴ�.");
		}
		return medicineDAO.create(medicine);
	}

	public int update(Medicine medicine) throws SQLException, MedicineNotFoundException  {
	    return medicineDAO.update(medicine);
			}
	
	public int updateQuantity(Medicine medicine) throws SQLException, MedicineNotFoundException  {
	    return medicineDAO.updateQuantity(medicine);
			}

	public int remove(String med_id) throws SQLException, MedicineNotFoundException {
		return MedicineDAO.remove(med_id);
	}

	public Medicine getMedicine(String med_id) throws Exception {
			Medicine medicine = MedicineDAO.getMedicine(med_id);
			if (medicine == null) {
				throw new Exception(med_id + "�� �������� �ʴ� ��ǰ�Դϴ�.");
			}		
			return medicine;
	}
	
	public List<Medicine> findMedicine(String med_id)
		throws Exception {
		List<Medicine> medicine_list = medicineDAO.findMedicine(med_id);
		if (medicine_list.isEmpty()) {
			throw new Exception(med_id + "�� �������� �ʴ� ��ǰ�Դϴ�.");
		}		
		return medicine_list;
	}

	public List<Medicine> findMedicineList() throws SQLException {
			return medicineDAO.findMedicineList();
	}
	
	public List<Medicine> findMedicineListById(String med_id) throws Exception {
		List<Medicine> medicine_list = medicineDAO.findMedicine(med_id);
		if (medicine_list.isEmpty()) {
			throw new Exception(med_id + "�� �������� �ʴ� ��ǰ�Դϴ�.");
		}		
		return medicine_list;
}
	public List<Medicine> findMedicineListByName(String med_name) throws Exception {
		List<Medicine> medicine_list = medicineDAO.findMedicineListByMed_name(med_name);
		if (medicine_list.isEmpty()) {
			throw new Exception(med_name + "�� �������� �ʴ� ��ǰ�Դϴ�.");
		}		
		return medicine_list;
}
	public List<Medicine> findMedicineListBySymptom(String symptom) throws Exception {
		List<Medicine> medicine_list = medicineDAO.findMedicineListBySymptom(symptom);
		if (medicine_list.isEmpty()) {
			throw new Exception(symptom + "�� ���õ� ��ǰ�� �������� �ʽ��ϴ�.");
		}		
		return medicine_list;
}
	public List<Medicine> findMedicineListByCategory(String med_category) throws Exception {
		List<Medicine> medicine_list = medicineDAO.findMedicineListByMed_category(med_category);
		if (medicine_list.isEmpty()) {
			throw new Exception(med_category + "�� ���õ� ��ǰ�� �������� �ʽ��ϴ�.");}
		
		return medicine_list;
}
	

	public MedicineDAO getMedicineDAO() {
		return this.medicineDAO;
	}
}
