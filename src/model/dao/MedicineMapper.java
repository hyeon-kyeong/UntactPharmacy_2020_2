package model.dao;

import java.util.List;

import model.Medicine;

public interface MedicineMapper {
	
	public int createMedicine(Medicine medicine);
	
	public int deleteMedicine(String med_id);
	
	public Medicine findMedicine(String med_id);
	
	public List<Medicine> searchMedicineByPrimaryKey(String med_id);
	
	public List<Medicine> searchMedicineByMed_name(String med_name);
	
	public List<Medicine> searchMedicineListBySymptom(String symptom);

	public List<Medicine> searchMedicineListByMed_category(String med_category);
	
	public List<Medicine> ListAllMedicine();

	public int updateMedicine(Medicine medicine);
	
	public int updateMedicineQuantity(Medicine medicine);
}
