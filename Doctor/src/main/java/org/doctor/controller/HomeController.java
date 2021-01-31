package org.doctor.controller;


import org.doctor.dao.PaitentDAO;
import org.doctor.entity.Patient;
import org.doctor.mail.MailComposer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	PaitentDAO dao;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView newPaitent(ModelAndView model) {
		Patient newPaitent = new Patient();
		model.addObject("patient", newPaitent);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ModelAndView savePaitent(Patient paitent, BindingResult result, ModelMap model) {
		int i = dao.save(paitent);
		if(i!=0) {
			ApplicationContext context=new FileSystemXmlApplicationContext("classpath:org/doctor/config/applicationContext.xml");
			MailComposer mailer=(MailComposer)context.getBean("emailService");
			String message="Hello"+paitent.getP_name()+",/n Your Appointment for Doctor Sha has been booked on "+paitent.getDate_of_appointment()+"./nPlease be on time.";
			mailer.sendMail(paitent.getEmail(), "Appointment for Doctor",message);
			String name=paitent.getUpload().getOriginalFilename();
			
		model.addAttribute("Appointment has been booked by name"+name+".");
			return new ModelAndView("redirect:/");
		}else {
			String name=paitent.getUpload().getOriginalFilename();
			model.addAttribute("Appointment has not  been booked yet"+name+".");
				return new ModelAndView("redirect:/");
		}
			
	}

}
