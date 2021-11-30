package in.co.rays.proj0.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.co.rays.proj0.ctl.BaseCtl;
import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.form.StudentForm;
import in.co.rays.proj0.service.StudentServiceInt;


/**
 * Student RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/Student")
public class StudentRESTfullWS extends BaseCtl {

    private static Logger log = Logger.getLogger(StudentRESTfullWS.class);

    @Autowired
    private StudentServiceInt service;

    /**
     * Gets Student information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentDTO get(@PathVariable long id) {
        StudentDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets Student list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(StudentForm form, HttpSession session) {
        StudentDTO dto = (StudentDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a Student
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public StudentDTO delete(@PathVariable long id) throws Exception {
        StudentDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
