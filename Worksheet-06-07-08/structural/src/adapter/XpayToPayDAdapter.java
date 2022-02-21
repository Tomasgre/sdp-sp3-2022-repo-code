package adapter;

public class XpayToPayDAdapter implements PayD {
  Xpay xpay;

  public XpayToPayDAdapter(Xpay xpay) {
    this.xpay = xpay;
  }

  @Override
  public String getCustCardNo() {
    return this.xpay.getCreditCardNo();
  }

  @Override
  public String getCardOwnerName() {
    return this.xpay.getCustomerName();
  }

  @Override
  public String getCardExpMonthDate() {
    return this.xpay.getCardExpMonth();
  }

  @Override
  public Integer getCVVNo() {
    return this.xpay.getCardCVVNo().intValue();
  }

  @Override
  public Double getTotalAmount() {
    return this.xpay.getAmount();
  }

  @Override
  public void setCustCardNo(String custCardNo) {
    this.xpay.setCreditCardNo(custCardNo);
  }

  @Override
  public void setCardOwnerName(String cardOwnerName) {
    this.xpay.setCustomerName(cardOwnerName);
  }

  @Override
  public void setCardExpMonthDate(String cardExpMonthDate) {
    this.xpay.setCardExpMonth(cardExpMonthDate);
  }

  @Override
  public void setCVVNo(Integer cVVNo) {
    this.xpay.setCardCVVNo(cVVNo.shortValue());
  }

  @Override
  public void setTotalAmount(Double totalAmount) {
    this.xpay.setAmount(totalAmount);
  }
}
