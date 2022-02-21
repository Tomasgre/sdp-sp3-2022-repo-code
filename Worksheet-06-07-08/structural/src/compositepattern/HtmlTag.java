package compositepattern;

import java.util.List;

public abstract class HtmlTag {

  protected String tagName;
  protected String startTag;
  protected String endTag;

  public HtmlTag (String tagName) {
    this.tagName = tagName;
  }

  public abstract String getTagName();

  public abstract void setStartTag(String tag);

  public abstract void setEndTag(String tag);

  public void setTagBody(String tagBody) {
    throw new UnsupportedOperationException("Current operation is not support for this object");
  }

  public void addChildTag(HtmlTag htmlTag) {
    throw new UnsupportedOperationException("Current operation is not support for this object");
  }

  public void removeChildTag(HtmlTag htmlTag) {
    throw new UnsupportedOperationException("Current operation is not support for this object");
  }

  public List<HtmlTag> getChildren() {
    throw new UnsupportedOperationException("Current operation is not support for this object");
  }

  public abstract void generateHtml();
}
