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
import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.form.UserForm;
import in.co.rays.proj0.service.UserServiceInt;


/**
 * User RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/User")
public class UserRESTfullWS extends BaseCtl {

    private static Logger log = Logger.getLogger(UserRESTfullWS.class);

    @Autowired
    private UserServiceInt service;

    /**
     * Gets User information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO get(@PathVariable long id) {
        UserDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets User list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(UserForm form, HttpSession session) {
        UserDTO dto = (UserDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a User
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public UserDTO delete(@PathVariable long id) throws Exception {
        UserDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
