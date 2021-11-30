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
import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.form.TimeTableForm;
import in.co.rays.proj0.service.TimeTableServiceInt;


/**
 * TimeTable RESTFul Web Service.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/TimeTable")
public class TimeTableRESTfullWS extends BaseCtl {

    private static Logger log = Logger.getLogger(TimeTableRESTfullWS.class);

    @Autowired
    private TimeTableServiceInt service;

    /**
     * Gets TimeTable information
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TimeTableDTO get(@PathVariable long id) {
        TimeTableDTO dto = service.findById(id);
        return dto;
    }

    /**
     * Gets TimeTable list
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List getList(TimeTableForm form, HttpSession session) {
        TimeTableDTO dto = (TimeTableDTO) form.getDto(session);
        return service.search(dto, form.getPageNo(), form.getPageSize());
    }

    /**
     * Deletes a TimeTable
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public TimeTableDTO delete(@PathVariable long id) throws Exception {
        TimeTableDTO dto = service.findById(id);
        service.delete(id);
        return dto;

    }

}
