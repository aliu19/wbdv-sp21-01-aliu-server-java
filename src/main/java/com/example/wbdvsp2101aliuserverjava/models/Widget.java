package com.example.wbdvsp2101aliuserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String topicId;
  private String type;
  private Integer size;
  private String text;
  private Integer widgetOrder;
  private String src;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private Boolean ordered;

  public Widget(Long id, String name, String topicId, String type, Integer size,
      String text, Integer widgetOrder, String src, Integer width, Integer height,
      String cssClass, String style, String value, Boolean ordered) {
    this.id = id;
    this.name = name;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.widgetOrder = widgetOrder;
    this.src = src;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.ordered = ordered;
  }

  public Widget() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }
}
