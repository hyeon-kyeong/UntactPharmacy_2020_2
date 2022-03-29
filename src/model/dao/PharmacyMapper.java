package model.dao;

import java.util.List;

import model.PharmacyDTO;

public interface PharmacyMapper {

	public int createPharmacy(PharmacyDTO pharmacy);
	
	public int deletePharmacy(String pharm_name);
	
	public PharmacyDTO searchPharmacyByPrimaryKey(String pharm_name);
	
	public List<PharmacyDTO> ListAllPharmacy();

}
