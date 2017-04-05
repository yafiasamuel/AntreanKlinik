package service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import model.Antrean;

public class AntreanService extends HttpServlet{

  @EJB
  AntreanFacade af;

  List<Antrean> la;

  public int getCurrentAntrean() {
    la = af.getCurrentAntrean();
    Antrean currentAntrean = la.get(0);
    return currentAntrean.getIdAntrean();
  }
  
  public static void main(String[] args) {
    System.out.println(new AntreanService().getCurrentAntrean());
  }
}
