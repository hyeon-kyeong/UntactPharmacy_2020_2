package controller.medicine;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Medicine;
import model.service.ExistingUserException;
import model.service.MedicineManager;

public class RegisterMedicineController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterMedicineController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String med_id = null;
      String med_name = null;
      String symptom = null;
      String co_name = null;
      String med_category = null;
      String price = null;
      String quantity = null;
      String filename = null;
      Medicine medicine = new Medicine();
      
      boolean check = ServletFileUpload.isMultipartContent(request);
      
      if(check) {
         ServletContext context = request.getServletContext();
         String path = context.getRealPath("/upload");
         File dir = new File(path);
         
         if(!dir.exists()) dir.mkdir();
         
         try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(10 * 1024);
                factory.setRepository(dir);
    
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setSizeMax(10 * 1024 * 1024);
                upload.setHeaderEncoding("utf-8");
                                
                List<FileItem> items = (List<FileItem>)upload.parseRequest(request);
                
                for(int i = 0; i < items.size(); ++i) {
                   FileItem item = (FileItem)items.get(i);

                   String value = item.getString("utf-8");
                   
                   if(item.isFormField()) {                 
                      if(item.getFieldName().equals("med_id")) medicine.setMed_id(value);
                      else if(item.getFieldName().equals("med_name")) medicine.setMed_name(value);
                      else if(item.getFieldName().equals("symptom")) medicine.setSymptom(value);
                      else if(item.getFieldName().equals("co_name")) medicine.setCo_name(value);
                      else if(item.getFieldName().equals("med_category")) medicine.setMed_category(value);
                      else if(item.getFieldName().equals("price")) medicine.setPrice(Integer.parseInt(value));
                      else if(item.getFieldName().equals("quantity")) medicine.setQuantity(Integer.parseInt(value));
                      else if(item.getFieldName().equals("picture")) medicine.setDir(item.getName());
                   }
                   else {
                      if(item.getFieldName().equals("picture")) {
                         filename = item.getName();
                         if(filename == null || filename.trim().length() == 0) continue;
                         filename = filename.substring(filename.lastIndexOf("\\") + 1);
                         File file = new File(dir, filename);
                         item.write(file);
                         medicine.setFilename(filename);
                      }
                   }
                }
                request.setAttribute("dir", path);
                request.setAttribute("filename", filename);     
         }catch(SizeLimitExceededException e) {
            e.printStackTrace();           
            }catch(FileUploadException e) {
                e.printStackTrace();
            }catch(Exception e) {            
                e.printStackTrace();
            }
         //       request.setAttribute("filename", filename);
         //      request.setAttribute("dir", dir);
         
         
      }
        log.debug("Create Medicine : {}", medicine);

      try {
         MedicineManager medicineManager = MedicineManager.getInstance();
         medicineManager.create(medicine);
//           return "redirect:/medicine/admin/list";   // 성공 시 약품 리스트 화면으로 redirect
         return "redirect:/medicine/admin/list";
         
      } catch (ExistingUserException e) {   // 예외 발생 시 약품 등록 form 으로 forwarding
            request.setAttribute("registerFailed", true);
         request.setAttribute("exception", e);
         request.setAttribute("medicine", medicine);
         return "/medicine/registerForm.jsp";
      }
    }
}