/*
 * Copyright (c) 2016.
 */

package com.crooks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by johncrooks on 6/20/16.
 */
@Controller
public class MBSController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model,)
}
