package com.example.wbdvsp2101aliuserverjava.services;

import com.example.wbdvsp2101aliuserverjava.models.Widget;
import com.example.wbdvsp2101aliuserverjava.repositories.WidgetRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  public List<Widget> findAllWidgets() {
    return repository.findAllWidgets();
//    return (List<Widget>) repository.findAll();
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
  }

  public Widget findWidgetById(Long id) {
    return repository.findWidgetById(id);
//    return repository.findById(id).get();
  }

  public Widget createWidget(String topicId, Widget widget) {
    return repository.save(widget);
  }

  public Integer deleteWidget(Long wid) {
    repository.deleteById(wid);
    return 1;
  }

  public Integer updateWidget(Long wid, Widget newWidget) {
    Widget originalWidget = findWidgetById(wid);
    originalWidget.setText(newWidget.getText());
    originalWidget.setType(newWidget.getType());
    originalWidget.setSize(newWidget.getSize());
    repository.save(originalWidget);
    return 1;
  }
}
