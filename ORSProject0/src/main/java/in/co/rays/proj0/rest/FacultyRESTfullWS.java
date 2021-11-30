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
import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.form.FacultyForm;
import in.co.rays.proj0.service.FacultyServiceInt;


/**
 * Faculty RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/Faculty")
public class FacultyRESTfullWS extends BaseCtl {

    private static Logger log = Logger.getLogger(FacultyRESTfullWS.class);

    @Autowired
    private FacultyServiceInt service;

    /**
     * Gets Faculty information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyDTO get(@PathVariable long id) {
        FacultyDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets Faculty list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(FacultyForm form, HttpSession session) {
        FacultyDTO dto = (FacultyDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a Faculty
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public FacultyDTO delete(@PathVariable long id) throws Exception {
        FacultyDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
