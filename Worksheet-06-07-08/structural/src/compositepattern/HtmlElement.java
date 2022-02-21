package compositepattern;

public class HtmlElement extends HtmlTag {

  private String tagBody;

  public HtmlElement(String tagName) {
    super(tagName);
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
  public void setTagBody(String tagBody) {
    this.tagBody = tagBody;
  }

  @Override
  public void generateHtml() {
    System.out.println(super.startTag + tagBody + super.endTag);
  }
}
