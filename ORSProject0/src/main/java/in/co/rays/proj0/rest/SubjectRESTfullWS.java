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
import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.form.SubjectForm;
import in.co.rays.proj0.service.SubjectServiceInt;


/**
 * Subject RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/Subject")
public class SubjectRESTfullWS extends BaseCtl {

    private static Logger log = Logger.getLogger(SubjectRESTfullWS.class);

    @Autowired
    private SubjectServiceInt service;

    /**
     * Gets Subject information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SubjectDTO get(@PathVariable long id) {
        SubjectDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets Subject list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(SubjectForm form, HttpSession session) {
        SubjectDTO dto = (SubjectDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a Subject
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public SubjectDTO delete(@PathVariable long id) throws Exception {
        SubjectDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
