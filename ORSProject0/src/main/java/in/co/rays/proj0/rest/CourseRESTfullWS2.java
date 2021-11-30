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
import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.form.CourseForm;
import in.co.rays.proj0.service.CourseServiceInt;


/**
 * Course RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/Course")
public class CourseRESTfullWS2 extends BaseCtl {

    private static Logger log = Logger.getLogger(CourseRESTfullWS2.class);

    @Autowired
    private CourseServiceInt service;

    /**
     * Gets Course information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CourseDTO get(@PathVariable long id) {
        CourseDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets Course list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(CourseForm form, HttpSession session) {
        CourseDTO dto = (CourseDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a Course
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public CourseDTO delete(@PathVariable long id) throws Exception {
        CourseDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
