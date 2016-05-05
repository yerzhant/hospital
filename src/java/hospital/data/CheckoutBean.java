/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.data;

import hospital.model.Checkout;
import hospital.model.Patient;
import java.util.List;
import javax.ejb.Stateless;

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

}
