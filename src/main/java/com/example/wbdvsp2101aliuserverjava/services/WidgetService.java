package com.example.wbdvsp2101aliuserverjava.services;

import com.example.wbdvsp2101aliuserverjava.models.Widget;
import com.example.wbdvsp2101aliuserverjava.repositories.WidgetRepository;
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

    if(newWidget.getName() != null) {
      originalWidget.setName(newWidget.getName());
    }

    if(newWidget.getText() != null) {
      originalWidget.setText(newWidget.getText());
    }

    if(newWidget.getType() != null) {
      originalWidget.setType(newWidget.getType());
    }

    if(newWidget.getSize() != null) {
      originalWidget.setSize(newWidget.getSize());
    }

    if(newWidget.getWidgetOrder() != null) {
      originalWidget.setWidgetOrder(newWidget.getWidgetOrder());
    }

    if(newWidget.getSrc() != null) {
      originalWidget.setSrc(newWidget.getSrc());
    }

    if(newWidget.getWidth() != null) {
      originalWidget.setWidth(newWidget.getWidth());
    }

    if(newWidget.getHeight() != null) {
      originalWidget.setHeight(newWidget.getHeight());
    }

    if(newWidget.getCssClass() != null) {
      originalWidget.setCssClass(newWidget.getCssClass());
    }

    if(newWidget.getStyle() != null) {
      originalWidget.setStyle(newWidget.getStyle());
    }

    if(newWidget.getValue() != null) {
      originalWidget.setValue(newWidget.getValue());
    }

    if(newWidget.getOrdered() != null) {
      originalWidget.setOrdered(newWidget.getOrdered());
    }

    repository.save(originalWidget);
    return 1;
  }
}
