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
import in.co.rays.proj0.dto.RoleDTO;
import in.co.rays.proj0.form.RoleForm;
import in.co.rays.proj0.service.RoleServiceInt;


/**
 * Role RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/Role")
public class RoleRESTfullWS extends BaseCtl {

    private static Logger log = Logger.getLogger(RoleRESTfullWS.class);

    @Autowired
    private RoleServiceInt service;

    /**
     * Gets Role information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RoleDTO get(@PathVariable long id) {
        RoleDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets Role list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(RoleForm form, HttpSession session) {
        RoleDTO dto = (RoleDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a Role
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public RoleDTO delete(@PathVariable long id) throws Exception {
        RoleDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
