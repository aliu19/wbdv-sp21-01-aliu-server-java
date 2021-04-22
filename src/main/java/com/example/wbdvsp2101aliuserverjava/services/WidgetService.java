package com.example.wbdvsp2101aliuserverjava.services;

import com.example.wbdvsp2101aliuserverjava.models.Widget;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Widgets for Topic ABC123");
    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Widgets for Topic ABC234");
    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w5 = new Widget(567l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }
}
