package org.doctor.dao;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.doctor.entity.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@EnableTransactionManagement
public class PaitentDAOImpl implements PaitentDAO {

	private JdbcTemplate jdbcTemplate;
	String path = "/server/local";

	  public PaitentDAOImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	@Override
	@Transactional
	public int save(Patient patient) {
            // insert
            String sql = "INSERT INTO paitent (p_name,p_dob,blood_group,address,mobile_no,email,d_appointment,doc)"
                        + " VALUES (?,?,?,?,?,?,?,?)";
            int i=jdbcTemplate.update(sql, patient.getP_name(), patient.getP_dob(),patient.getBlood_group(),
            		patient.getAddress(),patient.getMobile_number(),patient.getEmail(),
            		patient.getDate_of_appointment(),patient.getUpload().getOriginalFilename());
            if(i==1) { 
             int id=jdbcTemplate.queryForInt("select last_insert_id()");
             System.out.println(id);
             String uploadPath = path + File.separator + "PA" +id+ File.separator;
             System.out.println(uploadPath);
    			MultipartFile file = patient.getUpload();
    			try {
    				File f=new File(uploadPath+file.getOriginalFilename());
    				FileUtils.touch(f);
    				file.transferTo(f);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		return 1;
            }
            else
            return 0;
	}

}
