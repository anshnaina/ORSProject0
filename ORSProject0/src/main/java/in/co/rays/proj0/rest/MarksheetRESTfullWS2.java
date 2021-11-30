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
import in.co.rays.proj0.dto.MarksheetDTO;
import in.co.rays.proj0.form.MarksheetForm;
import in.co.rays.proj0.service.MarksheetServiceInt;


/**
 * Marksheet RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/Marksheet")
public class MarksheetRESTfullWS2 extends BaseCtl {

    private static Logger log = Logger.getLogger(MarksheetRESTfullWS2.class);

    @Autowired
    private MarksheetServiceInt service;

    /**
     * Gets Marksheet information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MarksheetDTO get(@PathVariable long id) {
        MarksheetDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets Marksheet list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(MarksheetForm form, HttpSession session) {
        MarksheetDTO dto = (MarksheetDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a Marksheet
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public MarksheetDTO delete(@PathVariable long id) throws Exception {
        MarksheetDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
