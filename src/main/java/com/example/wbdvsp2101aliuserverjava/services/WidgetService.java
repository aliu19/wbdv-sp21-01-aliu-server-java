package com.example.wbdvsp2101aliuserverjava.services;

import com.example.wbdvsp2101aliuserverjava.models.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget(123l, "607670d5820c72001740e6c2", "HEADING", 1, "Widgets for Topic ABC123");
    Widget w2 = new Widget(234l, "607670d5820c72001740e6c2", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w3 = new Widget(345l, "607670f3820c72001740e6c4", "HEADING", 2, "Widgets for Topic ABC234");
    Widget w4 = new Widget(456l, "607670f3820c72001740e6c4", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w5 = new Widget(567l, "607670f3820c72001740e6c4", "PARAGRAPH", 1, "Lorem Ipsum");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> ws = new ArrayList<Widget>();
    for(Widget w: widgets) {
      if (w.getTopicId().equals(topicId)) {
        ws.add(w);
      }
    }
    return ws;
  }

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    widget.setId((new Date()).getTime());
    widgets.add(widget);
    return widget;
  }
}
