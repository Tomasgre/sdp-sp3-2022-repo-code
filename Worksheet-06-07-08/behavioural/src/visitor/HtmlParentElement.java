package visitor;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {

  String tagName;
  String startTag;
  String endTag;
  List<HtmlTag> childTags = new ArrayList<>();

  public HtmlParentElement(String tagName) {
    this.tagName = tagName;
  }

  @Override
  public String getTagName() {
    return tagName;
  }

  @Override
  public void setStartTag(String startTag) {
    this.startTag = startTag;
  }

  @Override
  public void setEndTag(String endTag) {
    this.endTag = endTag;
  }

  @Override
  public String getStartTag() {
    return startTag;
  }

  @Override
  public String getEndTag() {
    return endTag;
  }

  @Override
  public void addChildTag(HtmlTag htmlTag) {
    childTags.add(htmlTag);
  }

  @Override
  public void removeChildTag(HtmlTag htmlTag) {
    childTags.remove(htmlTag);
  }

  @Override
  public List<HtmlTag> getChildren() {
    return childTags;
  }

  @Override
  public void generateHtml() {
    System.out.println(startTag);
    for (HtmlTag childTag: childTags) {
      childTag.generateHtml();
    }
    System.out.println(endTag);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}