package compositepattern;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {

  private List<HtmlTag> children;

  public HtmlParentElement(String tagName) {
    super(tagName);
    children = new ArrayList<>();
  }

  @Override
  public String getTagName() {
    return super.tagName;
  }

  @Override
  public void setStartTag(String tag) {
    super.startTag = tag;
  }

  @Override
  public void setEndTag(String tag) {
    super.endTag = tag;
  }

  @Override
  public void generateHtml() {
    System.out.println(super.startTag);
    for (HtmlTag child: children) {
        child.generateHtml();
    }
    System.out.println(super.endTag);
  }

  @Override
  public void addChildTag(HtmlTag htmlTag) {
    children.add(htmlTag);
  }

  @Override
  public void removeChildTag(HtmlTag htmlTag) {
    children.remove(htmlTag);
  }

  @Override
  public List<HtmlTag> getChildren() {
    return children;
  }
}
