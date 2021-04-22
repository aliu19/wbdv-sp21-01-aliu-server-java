package com.example.wbdvsp2101aliuserverjava.controllers;

import com.example.wbdvsp2101aliuserverjava.models.Widget;
import com.example.wbdvsp2101aliuserverjava.services.WidgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetController {

  @Autowired
  WidgetService service;

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }
}
