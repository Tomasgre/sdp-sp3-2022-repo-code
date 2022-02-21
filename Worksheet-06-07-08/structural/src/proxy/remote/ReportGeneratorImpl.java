package proxy.remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class ReportGeneratorImpl extends UnicastRemoteObject implements ReportGenerator {
  private static final long serialVersionUID = 3107413009881629428L;

  protected ReportGeneratorImpl() throws RemoteException {
  }

  @Override
  public String generateDailyReport() throws RemoteException {
    StringBuilder sb = new StringBuilder();
    sb.append("********************Location X Daily Report********************");
    sb.append("\\n Location ID: 012");
    sb.append("\\n Today's Date: " + new Date());
    sb.append("\\n Total Pizza's Sell: 112");
    sb.append("\\n Total Price: $2534");
    sb.append("\\n Net Profit: $1985");
    sb.append("\\n ***************************************************************");

    return sb.toString();
  }

  public static void main(String[] args) {
    try {
      Naming.rebind("PizzaCoRemoteGenerator", new ReportGeneratorImpl());
      System.err.println("Server ready");
    } catch (Exception e) {
        System.err.println("Server exception: " + e.toString());
        e.printStackTrace();
    }
  }
}