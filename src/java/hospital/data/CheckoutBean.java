/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.data;

import hospital.model.Checkout;
import hospital.model.Patient;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author yerzhan
 */
@Stateless
public class CheckoutBean extends Bean<Checkout> {

    public CheckoutBean() {
        super(Checkout.class);
    }

    public List<Checkout> find(Patient patient) {
        return em.createNamedQuery(Checkout.FIND_BY_PATIENT).setParameter("patient", patient).getResultList();
    }
    
    @Resource
    private DataSource ds;
    
    public byte[] report() throws SQLException, JRException {
        JasperPrint jp = JasperFillManager.fillReport("/home/yerzhan/checkout.jasper", null, ds.getConnection());
        return JasperExportManager.exportReportToPdf(jp);
    }

}
