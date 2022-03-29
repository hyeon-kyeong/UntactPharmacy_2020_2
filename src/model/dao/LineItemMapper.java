package model.dao;

import java.util.List;
import model.LineItem;



public interface LineItemMapper {

	  List<LineItem> getLineItemsByReservationId(int orderId);

	  void insertLineItem(LineItem lineitem);
	  
	  void deleteLineItem(LineItem lineitem);

	}
